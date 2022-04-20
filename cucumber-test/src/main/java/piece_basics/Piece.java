package piece_basics;

import board.IBoard;
import board.PropertyChangeSupport;

public abstract class Piece {
	protected IBoard board;
	
	public void setBoard(IBoard board) {
		this.board = board;
	}
	
	public PropertyChangeSupport getPropertyChangeSupport() {
		return board.getPropertyChangeSupport();
	}
	
	public void performRegisterAction() {}
	public void performImmediateAction(Robot r) {}
	
	public abstract String getPieceID();
}
