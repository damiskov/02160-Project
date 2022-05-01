package piece_basics;

import java.util.Stack;

import board.Position;
import cards.Card;
import environment_elements.ChainingPanel;
import environment_elements.RespawnPoint;

import property_changes.ChainingEvent;
import property_changes.HealthChangeEvent;
import property_changes.MovementEvent;
import property_changes.RobotLaserEvent;
import property_changes.RotationEvent;
import property_changes.TeleportEvent;
import cards.Program;

public class Robot extends Piece {
	private int robotNumber;
	
	private Orientation orientation = Orientation.UP;
	private int health;
	public static final int MAX_ROBOT_HEALTH = 3;
	private RespawnPoint currentRespawnPoint;
	private ChainingPanel ChainedFrom;
	private boolean chainable = false;
	private Robot chainedTo;
	private String command;	
	private Program program;
	/*
	 *  The number of the most recent checkpoint this robot validly stepped on. 
	 *  Robots must reach checkpoints in ascending number order, starting from 1
	 */
	private int mostRecentCheckpoint = 0;
	
	public static final String ID = "robot";
	
	private String spriteName;
	
	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
	}
	
	public String getSpriteName() {
		return spriteName;
	}
	
	// Instantiate a robot without a number identity, used in tests
	public Robot() {
		health = MAX_ROBOT_HEALTH; // robots start at maximum health
	}
	
	// Instantiate a robot with a number identity for communicating with the view, mostly used in actual gameplay
	public Robot(int robotNumber) {
		this();
		this.robotNumber = robotNumber;
	}
	
	public void setPosition(Position p) {
		board.setPosition(this, p);
	}
	public Position calculatePosition() {
		return board.calculatePosition(this);
	}
	public int getX() {
		return board.calculatePosition(this).getX();
	}
	public int getY() {
		return board.calculatePosition(this).getY();
	}
	
	public void setRespawnPoint(RespawnPoint r) {
		this.currentRespawnPoint = r;
	}
	

	
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void turnLeft() {
		Orientation oldOrientation = orientation;
		switch(orientation) {
		case UP:
			orientation = Orientation.LEFT;
			break;
		case RIGHT:
			orientation = Orientation.UP;
			break;
		case DOWN:
			orientation = Orientation.RIGHT;
			break;
		case LEFT:
			orientation = Orientation.DOWN;
			break;
		}
		firePropertyChange(new RotationEvent(robotNumber, oldOrientation, orientation));
	}
	public void turnRight() {
		Orientation oldOrientation = orientation;
		switch(orientation) {
		case UP:  
			orientation = Orientation.RIGHT;
			break;
		case RIGHT:
			orientation = Orientation.DOWN;
			break;
		case DOWN:
			orientation = Orientation.LEFT;
			break;
		case LEFT:
			orientation = Orientation.UP;
			break;
		}
		firePropertyChange(new RotationEvent(robotNumber, oldOrientation, orientation));
	}	
	
	//This method tries to push another robot and return true if it was successful
	private boolean pushOtherRobot(Robot other, int step) {
		Position newOtherPos = other.calculatePosition().next(this.getOrientation(), step);
		
		//Check if the robot can be pushed to the proposed new position
		if(board.coordinateWithinBounds(newOtherPos) &&
		   !board.hasRobotAt(newOtherPos) &&
		   !eElementBlocking(newOtherPos)) {
			
			firePropertyChange(new MovementEvent(other.getRobotNumber(), other.calculatePosition(), newOtherPos));
			board.moveRobotFromTo(other.calculatePosition(), newOtherPos);
			System.out.println("Other robot pushed to" + newOtherPos);		
			return true;
		} else {
			System.out.println("Other robot cannot be pushed");
			return false;
		}
	}

	//This method tries to move our robot
	private void tryMoveRobot(Position posToMoveTo, int step) {
		
		if(board.coordinateWithinBounds(posToMoveTo)) {
			
			//there is nothing in the way
			if (!eElementBlocking(posToMoveTo) &&
					!board.hasRobotAt(posToMoveTo)) {
					
					firePropertyChange(new MovementEvent(robotNumber, calculatePosition(), posToMoveTo));
					board.setPosition(this, posToMoveTo);
					
					System.out.println("Moved robot with clear path");
					
				//There is another robot in the way, skipped if other robot cannot be moved
				} else if (board.hasRobotAt(posToMoveTo) &&
						   pushOtherRobot(board.getRobotAt(posToMoveTo),step)){
					firePropertyChange(new MovementEvent(robotNumber, calculatePosition(), posToMoveTo));
					board.setPosition(this, posToMoveTo);
					System.out.println("Moved own robot with push");
				}
		} else {
			System.out.println("Cannot move, coordinate out of bounds");
		}
	}

	//needed to de-clutter if() statements for ease of reading
	private boolean eElementBlocking(Position posToMoveTo) {
		return (board.hasEElementAt(posToMoveTo) && board.getEElementAt(posToMoveTo).isRobotBlocking());
	}
	
	/*
	 * Robots can only move forwards and backwards, unless they are pushed by a conveyor belt or pulled by a chained robot. This method
	 * handles forward movement by a certain number of cells. Backwards movements are accomplished by giving this method a negative int
	 * parameter. This method is called by the forward and backward movement cards.
	 */
	public void move(int spaces) {
			
		 	while(spaces!=0) {
		 		//robot is not chained
		 		if(this.getChainedTo() == null) {
					this.tryMoveRobot(calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
				//robot is chained to something, moved the chained robot first, then ourselves
		 		} else {
					this.getChainedTo().tryMoveRobot(this.getChainedTo().calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
					this.tryMoveRobot(calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
		 		}
		 		//its important that the above similar looking statement just gives -1 if spaces is negative +1 othervise
		 		//this one increments spaces itself towards 0 in steps of 1
		 		spaces += spaces < 0 ? 1 : -1;
		 	}
	}		

	public void heal() {
		if (health < MAX_ROBOT_HEALTH) {
			health++;
			firePropertyChange(new HealthChangeEvent(robotNumber, health));
		}
	}
	public void takeDamage() {
		health--;
		if (health == 0) reboot();
		firePropertyChange(new HealthChangeEvent(robotNumber, health));
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public boolean isChainable() {
		return this.chainable;
	}
	public void setChainable(boolean chainable) {
		this.chainable = chainable;
	}
	public Robot getChainedTo() {
		return this.chainedTo;
	}
	public void setChainedTo(Robot chainedTo) {
		this.chainedTo = chainedTo;
	}
	
	public void reboot() {
		// unchains the robot when it reboots
		if (getChainedTo() != null) {
			int chaintoNum = getChainedTo().robotNumber;
			getChainedTo().setChainedTo(null);
			getChainedTo().setChainable(false);
			setChainable(false);
			setChainedTo(null);
			firePropertyChange(new ChainingEvent(robotNumber, chaintoNum, false));
		}
		
		if (currentRespawnPoint != null) {
			Position respawnPointPos = board.calculatePosition(currentRespawnPoint);
			System.out.println("Rebooting to " + respawnPointPos);
			if (board.hasRobotAt(respawnPointPos) && board.getRobotAt(respawnPointPos) != this) {
				board.getRobotAt(respawnPointPos).reboot();
			}
			System.out.println(calculatePosition());
			setPosition(respawnPointPos);
			firePropertyChange(new TeleportEvent(robotNumber, respawnPointPos));
			health = MAX_ROBOT_HEALTH;
		} else throw new NullPointerException("Killed a robot with null respawn point");
	}

	//Shoot a laser at the first robot in line of sight, if there are any
	@Override
	public void performRegisterAction() {
		System.out.println("Looking for robot ahead of robot " + robotNumber);
		Robot foundRobot = findRobotAhead();
		
		if (foundRobot != null) {
			System.out.println("Robot " + getRobotNumber() + " firing at robot " + foundRobot.getRobotNumber());
			firePropertyChange(new RobotLaserEvent(getRobotNumber(), foundRobot.getRobotNumber()));
			foundRobot.takeDamage();
		}
	}
	// This helper method looks for a robot in line of sight
	private Robot findRobotAhead() {
		Position p = calculatePosition();
		
		System.out.println("Initializing search from position " + p);
		
		switch(orientation) {
		case UP:
			p.incrY(1);
			break;
		case RIGHT:
			p.incrX(1);
			break;
		case DOWN:
			p.incrY(-1);
			break;
		case LEFT:
			p.incrX(-1);
			break;
		default :
			throw new NullPointerException("Orientation is null");
		}
		
		
		Robot foundRobot = null;
		while (board.coordinateWithinBounds(p) && !laserBlocking(p)) {
			System.out.println("Searchin at " + p);
			if (board.hasRobotAt(p)) {
				foundRobot = board.getRobotAt(p);
				break;
			}
			switch (orientation) {
			case UP:
				p.incrY(1); break;
			case RIGHT:
				p.incrX(1); break;
			case DOWN:
				p.incrY(-1); break;
			case LEFT:
				p.incrX(-1); break;
			}
		}
		return foundRobot;
	}
	
	// This helper method returns true if the board has a laser-blocking environment element at the given position, and false otherwise
	private boolean laserBlocking(Position p) {
		return board.hasEElementAt(p) && board.getEElementAt(p).isLaserBlocking();
	}
	
	public Program getProgram(){
		return this.program;
	}
	
	public void setChainedFrom(ChainingPanel chainedFrom) {
		this.ChainedFrom = chainedFrom;
	}
	
	public ChainingPanel getChainedFrom() {
		return this.ChainedFrom;
	}
	
	public void setProgram(Stack<Card> stack) {
		Program p = new Program();
		p.setCardList(stack);
		this.program = p;
	}

	@Override
	public String getPieceID() {
		return ID;
	}
	


	public int getMostRecentCheckpoint() {
		return mostRecentCheckpoint;
	}

	public void setMostRecentCheckpoint(int mostRecentCheckpoint) {
		this.mostRecentCheckpoint = mostRecentCheckpoint;
	}

	public int getRobotNumber() {
		return robotNumber;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
