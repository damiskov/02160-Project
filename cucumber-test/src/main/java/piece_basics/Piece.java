package piece_basics;

import java.io.IOException;

import board.IBoard;

public abstract class Piece {
	protected IBoard board;
	
	public void setBoard(IBoard board) {
		this.board = board;
	}
	
	public void performRegisterAction() {}
	public void performImmediateAction(Robot r) {}
	
	public abstract String getPieceID();


}
