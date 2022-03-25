package piece_basics;

import board.IBoard;

public abstract class Piece {
	public int xPos; //changed to public for ignite method in class OilSpill
	public int yPos; //changed to public for ignite method in class OilSpill
	protected IBoard board;
	
	public Piece(IBoard board, int x, int y) {
		this.board = board;
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setPosition(int newX, int newY) {
		int oldXPos = xPos;
		int oldYPos = yPos;
		this.xPos = newX;
		this.yPos = newY;
		board.updatePiecePosition(oldXPos, oldYPos, this);
	}
	
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	
	public void shiftX(int offset) {
		setPosition(xPos + offset, yPos);
	}
	public void shiftY(int offset) {
		setPosition(xPos, yPos + offset);
	}
}
