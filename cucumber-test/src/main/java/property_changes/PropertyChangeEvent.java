package property_changes;

import board.Position;
import piece_basics.Orientation;
import piece_basics.Piece;

public class PropertyChangeEvent {

	private PropertyChangeType propertyChangeType;
	private Piece piece;
	private Position posCurrent;
	private Position posNew;
	private Orientation orientationOld;
	private Orientation orientationNew;
	private int health;
	private int robotNum;
	
	
	public PropertyChangeEvent(PropertyChangeType propertyChangeType, Piece piece, Position posCurrent, Position posNew,
			Orientation orientOld, Orientation orientNew, int health, int robotNum) {
		super();
		this.propertyChangeType = propertyChangeType;
		this.posCurrent = posCurrent;
		this.posNew = posNew;
		this.orientationOld = orientOld;
		this.orientationNew = orientNew;
		this.piece = piece;
		this.health = health;
		this.robotNum = robotNum;
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

	
	public int getRobotNum() {
		return robotNum;
	}
	

	public int getHealth() {
		return health;
	}


	

	
	
}
