package property_changes;

import board.Position;
import piece_basics.Piece;

public class PlacementEvent implements IPropertyChangeEvent {

	private Piece piece;
	private Position pos;
	
	public PlacementEvent(Piece piece, Position pos) {
		this.piece = piece;
		this.pos = pos;
	}

	public Piece getPiece() {
		return piece;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
