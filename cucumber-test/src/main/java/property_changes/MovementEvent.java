package property_changes;

import board.Position;

public class MovementEvent implements IPropertyChangeEvent {

	private int robotNumber;
	private Position posChange;
	
	public MovementEvent(int robotNumber, Position posChange) {
		this.robotNumber = robotNumber;
		this.posChange = posChange;
	}
	
	public int getRobotNum() {
		return robotNumber;
	}
	
	public Position getPosChange() {
		return posChange;
	}
	
	
}
