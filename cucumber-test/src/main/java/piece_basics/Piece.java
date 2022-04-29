package piece_basics;

import board.Board;
import property_changes.IPropertyChangeEvent;

public abstract class Piece {
	protected Board board;
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	protected final void firePropertyChange(IPropertyChangeEvent event) {
		board.firePropertyChange(event);
	}
	
	
	
	public void performRegisterAction() {}
	public void performImmediateAction(Robot r) {}
	
	public abstract String getPieceID();


}
