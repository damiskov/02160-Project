package piece_basics;

import board.IBoard;

public abstract class Piece {
	protected IBoard board;
	
	public void setBoard(IBoard board) {
		this.board = board;
	}
	
	public void performRegisterAction() {}
	public abstract String getPieceID();
}
