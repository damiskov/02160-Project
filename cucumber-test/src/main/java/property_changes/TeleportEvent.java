package property_changes;

import board.Position;
import piece_basics.Orientation;

public class TeleportEvent implements IPropertyChangeEvent {

	private int robotNumber;
	private Position posNew;
	private Orientation orientation;
	
	public TeleportEvent(int robotNumber, Position posNew, Orientation orientation) {
		this.robotNumber = robotNumber;
		this.posNew = posNew;
		this.orientation = orientation;
	}
	
	public int getRobotNum() {
		return robotNumber;
	}
	
	public Position getPosNew() {
		return posNew;
	}

	public Orientation getOrientation() {
		return orientation;
	}
	
	
	
	
}
