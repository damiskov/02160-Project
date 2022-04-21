package board;

import piece_basics.Orientation;
import piece_basics.Piece;

public class PropertyChangeEvent {

	private PropertyChangeType propertyChangeType;
	private Piece piece;
	private Position posCurrent;
	private Position posNew;
	private Orientation orientationOld;
	private Orientation orientationNew;
	
	
	public PropertyChangeEvent(PropertyChangeType propertyChangeType, Piece piece, Position posCurrent, Position posNew,
			Orientation orientOld, Orientation orientNew) {
		super();
		this.propertyChangeType = propertyChangeType;
		this.posCurrent = posCurrent;
		this.posNew = posNew;
		this.orientationOld = orientOld;
		this.orientationNew = orientNew;
		this.piece = piece;
		
	}



	public PropertyChangeType getPropertyChangeType() {
		return propertyChangeType;
	}


	public Piece getPiece() {
		return piece;
	}


	public Position getPosCurrent() {
		return posCurrent;
	}


	public Position getPosNew() {
		return posNew;
	}


	public Orientation getOrientationOld() {
		return orientationOld;
	}


	public Orientation getOrientationNew() {
		return orientationNew;
	}

	
	
}
