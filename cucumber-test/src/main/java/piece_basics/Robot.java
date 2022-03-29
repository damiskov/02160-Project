package piece_basics;

import board.IBoard;
import environment_elements.Pit;
import environment_elements.RespawnPoint;
import environment_elements.Wall;

public class Robot extends Piece implements IRegisterActor{
	private Orientation orientation;
	private int health = 3;
	private final int maxHealth = 3;
	private RespawnPoint currentRespawnPoint;
	private boolean chainable;
	private Robot chainedTo;

	
	public Robot(int x, int y) {
		super(x, y);
		orientation = Orientation.UP;
		
	}
	
	@Override
	public void setPosition(int newX, int newY) {
		super.setPosition(newX, newY);
		if (board.hasEElementAt(newX, newY) && board.getEElementAt(newX, newY) instanceof Pit) {
			reboot();
		}
	}
	
	public void setRespawnPoint(RespawnPoint r) {
		this.currentRespawnPoint = r;
	}

	public void executeProgram() {
		
		System.out.println("Program executed");
		
	}
	
	public void executeCommand() {
		
		System.out.println("Command executed");
		
	}
	
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void turnLeft() {
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
	}
	public void turnRight() {
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
	}
	public void move(int spaces) {
		switch(orientation) {
		case UP:
			shiftY(spaces);
			break;
		case RIGHT:
			shiftX(spaces);
			break;
		case DOWN:
			shiftY(-spaces);
			break;
		case LEFT:
			shiftX(-spaces);
			break;
		}
	}
	

	public void takeDamage() {
		health--;
		if (health == 0) reboot();
	}
	public void heal() {
		if (health < maxHealth) health++;
	}
	
	//is this method still relevant?
	public void setHealth(int x) {
		this.health = x;
	}
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
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
		setPosition(currentRespawnPoint.getX(), currentRespawnPoint.getY());
		health = maxHealth;
		// also must discard all cards in hand and stop moving
	}

	public void pullChained(Robot r, int spaces, String dir) {
		if (dir == "X") {
			r.shiftX(spaces);
		}
		else if (dir == "Y") {
			r.shiftY(spaces);
		}
	}
	

	@Override
	public void performRegisterAction() {
		Robot foundRobot = findRobotAhead();
		
		if (foundRobot != null) {
			foundRobot.takeDamage();
		}
	}
	private Robot findRobotAhead() {
		int searchX = 0;
		int searchY = 0;
		
		switch(orientation) {
		case UP:
			searchX = getX();
			searchY = getY() + 1;
			break;
		case RIGHT:
			searchX = getX() + 1;
			searchY = getY();
			break;
		case DOWN:
			searchX = getX();
			searchY = getY() - 1;
			break;
		case LEFT:
			searchX = getX() - 1;
			searchY = getY();
			break;
		}
		
		Robot foundRobot = null;
		while (board.coordinateWithinBounds(searchX, searchY) && !laserBlocking(searchX, searchY)) {
			if (board.hasRobotAt(searchX, searchY)) {
				foundRobot = board.getRobotAt(searchX, searchY);
				break;
			}
			switch (orientation) {
			case UP:
				searchY++; break;
			case RIGHT:
				searchX++; break;
			case DOWN:
				searchY--; break;
			case LEFT:
				searchX--; break;
			}
		}
		return foundRobot;
	}
	
	
	private boolean laserBlocking(int x, int y) {
		return board.hasEElementAt(x, y) ? board.getEElementAt(x, y) instanceof Wall : false;
	}

}
