package piece_basics;

import board.Board;
import property_changes.PropertyChangeSupport;

public abstract class Piece {
	protected Board board;
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	protected PropertyChangeSupport getPropertyChangeSupport() {
		return board.getPropertyChangeSupport();
	}
	
	
	
	public void performRegisterAction() {}
	public void performImmediateAction(Robot r) {}
	
	public abstract String getPieceID();


}
