package piece_basics;

import java.util.Stack;

import board.Position;
import cards.Card;
import environment_elements.ChainingPanel;
import environment_elements.RespawnPoint;

import environment_elements.Wall;
import property_changes.ChainingEvent;
import property_changes.HealthChangeEvent;
import property_changes.MovementEvent;
import property_changes.RobotLaserEvent;
import property_changes.RotationEvent;
import property_changes.TeleportEvent;
import cards.Program;

import java.lang.Math;  

public class Robot extends Piece {
	private static int nextRobotNumber = 1;
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
	
	public Robot() {
		health = MAX_ROBOT_HEALTH; // robots start at maximum health
		robotNumber = nextRobotNumber;
		nextRobotNumber++;
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
	
	private boolean pushOtherRobot(Robot other, int step) {
		Position newOtherPos = other.calculatePosition().next(this.getOrientation(), step);
		
		if(board.coordinateWithinBounds(newOtherPos) &&
		   !board.hasRobotAt(newOtherPos) &&
		   !eElementBlocking(newOtherPos)) {
			
			firePropertyChange(new MovementEvent(other.getRobotNumber(), other.calculatePosition(), newOtherPos));
			board.moveRobotFromTo(other.calculatePosition(), newOtherPos);
			System.out.println(other.calculatePosition()+ ""+ newOtherPos);
			System.out.println("Other robot pushed");
			
			return true;
		} else {
			System.out.println("Other robot cannot be pushed");
			return false;
		}
	}
	
	private boolean hasWallNextRobotShiftPosition(Position posToMove, int spaces) {
		Position shiftedNextRobotPos;
		int increment = spaces / Math.abs(spaces);
		if (orientation == Orientation.LEFT || orientation == Orientation.RIGHT) {
			// move on X axis
			shiftedNextRobotPos = new Position(posToMove.getX() + increment, posToMove.getY());
		} 
		else {
			// move on Y axis
			shiftedNextRobotPos = new Position(posToMove.getX(), posToMove.getY() + increment);
		}
		//check to be shifted 2nd robot position
		if(!(board.coordinateWithinBounds(shiftedNextRobotPos))) {
			return true;
		}
		if (board.hasEElementAt(shiftedNextRobotPos) && (board.getEElementAt(shiftedNextRobotPos).isRobotBlocking())) {
			return true;
		}
		
		return false;
	}
	
	
	private void tryMoveRobot(Position posToMoveTo, int step) {
		System.out.println("Moving to" + posToMoveTo);
		//System.out.println("Robot in the way?" + board.hasRobotAt(posToMoveTo)); 
		
		if(board.coordinateWithinBounds(posToMoveTo)) {
			if (!eElementBlocking(posToMoveTo) &&
					!board.hasRobotAt(posToMoveTo)) {
					
					firePropertyChange(new MovementEvent(robotNumber, calculatePosition(), posToMoveTo));
					board.setPosition(this, posToMoveTo);
					
					System.out.println("Moved robot with clear path");
				} else if (board.hasRobotAt(posToMoveTo) &&
						   pushOtherRobot(board.getRobotAt(posToMoveTo),step)){
					
					//Robot toBePushedRobot = board.getRobotAt(posToMoveTo);
					//toBePushedRobot.setOrientation(this.orientation);		
					//toBePushedRobot.move(1);
					firePropertyChange(new MovementEvent(robotNumber, calculatePosition(), posToMoveTo));
					board.setPosition(this, posToMoveTo);
					System.out.println("Moved own robot with push");
				}
			System.out.println("Cant move, stuff's in the way");
		}
		 else{
			System.out.println("Cannot move, Coordinate out of bounds");
		}
	}

	private boolean eElementBlocking(Position posToMoveTo) {
		return (board.hasEElementAt(posToMoveTo) && board.getEElementAt(posToMoveTo).isRobotBlocking());
	}
	
	public boolean isValidMove(int moves) {
		int newX = calculatePosition().getX() + moves;
		int newY = calculatePosition().getY() + moves;
		switch(orientation) {
		case UP:
			if(!(board.coordinateWithinBounds(calculatePosition().getX(), newY))) {
				return false;
			}
			break;
		case RIGHT:
			if(!(board.coordinateWithinBounds(newX, calculatePosition().getY()))) {
				return false;
			}
			break;
		case DOWN:
			if(!(board.coordinateWithinBounds(calculatePosition().getX(), newY))) {
				return false;
			}
			break;
		case LEFT:
			if(!(board.coordinateWithinBounds(newX, calculatePosition().getY()))) {
				return false;
			}
			break;
		}
		return true;
			
	}
	
	/*
	 * Robots can only move forwards and backwards, unless they are pushed by a conveyor belt or pulled by a chained robot. This method
	 * handles forward movement by a certain number of cells. Backwards movements are accomplished by giving this method a negative int
	 * parameter. This method is called by the forward and backward movement cards.
	 */
	public void move(int spaces) {
		 	while(spaces!=0) {
		 		if(this.getChainedTo() == null) {
					this.tryMoveRobot(calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
		 		} else {
					this.getChainedTo().tryMoveRobot(calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
					this.tryMoveRobot(calculatePosition().next(getOrientation(), spaces < 0 ? -1 : 1),spaces < 0 ? -1 : 1);
		 		}
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
			firePropertyChange(new TeleportEvent(robotNumber, respawnPointPos, this.getOrientation()));
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
		}
		
		Robot foundRobot = null;
		while (board.coordinateWithinBounds(p) && !laserBlocking(p)) {
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
