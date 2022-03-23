package piece_basics;

import board.IBoard;

public abstract class Piece {
	private int xPos;
	private int yPos;
	protected IBoard board;
	
	public Piece(IBoard board, int x, int y) {
		this.board = board;
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setPosition(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getX() {
		return xPos;
	}
	public void setX(int x) {
		setPosition(x, yPos);
	}
	public int getY() {
		return yPos;
	}
	public void setY(int y) {
		setPosition(xPos, y);
	}
	
	public void moveX(int offset) {
		setPosition(xPos + offset, yPos);
	}
	public void moveY(int offset) {
		setPosition(xPos, yPos + offset);
	}
}
