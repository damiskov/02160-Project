package piece_basics;

import board.IBoard;

public class Robot extends Piece implements IRegisterActor{
	private Orientation orientation;
	private int health;
	
	public Robot(IBoard board, int x, int y) {
		super(board, x, y);
	}

	public void executeProgram() {
		
		System.out.println("Program executed");
		
	}
	
	public void executeCommand() {
		
		System.out.println("Command executed");
		
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
			setY(getY() + spaces);
			break;
		case RIGHT:
			setX(getX() + spaces);
			break;
		case DOWN:
			setY(getY() - spaces);
			break;
		case LEFT:
			setX(getX() - spaces);
			break;
		}
	}
	

	public void takeDamage() {
		health--;
	}
	
	public void setHealth(int x) {
		this.health = x;
	}
	public int getHealth() {
		return this.health;
	}

	@Override
	public void performRegisterAction() {
		
	}
}
