package property_changes;

import piece_basics.Orientation;

public class RotationEvent implements IPropertyChangeEvent {

	private int robotNumber;
	private Orientation orientationOld;
	private Orientation orientationNew;
	
	public RotationEvent(int robotNumber, Orientation orientationOld, Orientation orientationNew) {
		this.robotNumber = robotNumber;
		this.orientationOld = orientationOld;
		this.orientationNew = orientationNew;
	}

	public int getRobotNum() {
		return robotNumber;
	}
	public Orientation getOrientationOld() {
		return orientationOld;
	}
	public Orientation getOrientationNew() {
		return orientationNew;
	}
	
	
	
	
}
