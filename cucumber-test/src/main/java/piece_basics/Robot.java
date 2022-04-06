package piece_basics;

import java.util.ArrayList;
import java.util.List;

import board.Position;
import cards.Card;
import environment_elements.RespawnPoint;

public class Robot extends Piece {
	private Orientation orientation;
	private int health = 3;
	private final int maxHealth = 3;
	private RespawnPoint currentRespawnPoint;
	private boolean chainable;
	private Robot chainedTo;
	private String command;	
	private ArrayList<Card> program; //setter method?
	
	public static final String ID = "robot";
	
	public Robot() {
		orientation = Orientation.UP;
	}
	
	public void setPosition(Position p) {
		board.setPosition(this, p);
	}
	public Position getPosition() {
		return board.getPosition(this);
	}
	public int getX() {
		return board.getPosition(this).getX();
	}
	public int getY() {
		return board.getPosition(this).getY();
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
	
	public void shiftX(int spaces) {
		// TODO: Add wall collision logic
		Position p = getPosition();
		p.incrX(spaces);
		board.setPosition(this, p);
	}
	public void shiftY(int spaces) {
		Position p = getPosition();
		p.incrY(spaces);
		board.setPosition(this, p);
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
		setPosition(board.getPosition(currentRespawnPoint));
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
		Position p = getPosition();
		
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
	
	
	private boolean laserBlocking(Position p) {
		return board.hasEElementAt(p) && board.getEElementAt(p).isLaserBlocking();
	}
	
	public ArrayList<Card> getProgram(){
		return this.program;
	}
	
	public void updateProgram(ArrayList<Card> program) {
		this.program = program;
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
