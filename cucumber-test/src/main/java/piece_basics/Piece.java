package piece_basics;

import board.IBoard;
import property_changes.PropertyChangeSupport;

public abstract class Piece {
	protected IBoard board;
	
	public void setBoard(IBoard board) {
		this.board = board;
	}
	
	protected PropertyChangeSupport getPropertyChangeSupport() {
		return board.getPropertyChangeSupport();
	}
	
	public void performRegisterAction() {}
	public void performImmediateAction(Robot r) {}
	
	public abstract String getPieceID();
}
