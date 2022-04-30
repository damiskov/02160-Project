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
	
	// This method is called by Game at the end of every register
	public void performRegisterAction() {}
	
	public abstract String getPieceID();

}
