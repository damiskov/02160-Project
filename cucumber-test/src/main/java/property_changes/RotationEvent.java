package property_changes;

import board.Position;
import piece_basics.Orientation;

public class RotationEvent implements IPropertyChangeEvent {

	private Position pos;
	private Orientation orientationOld;
	private Orientation orientationNew;
	
	public RotationEvent(Position pos, Orientation orientationOld, Orientation orientationNew) {
		this.pos = pos;
		this.orientationOld = orientationOld;
		this.orientationNew = orientationNew;
	}

	public Position getPos() {
		return pos;
	}
	public Orientation getOrientationOld() {
		return orientationOld;
	}
	public Orientation getOrientationNew() {
		return orientationNew;
	}
	
	
	
	
}
