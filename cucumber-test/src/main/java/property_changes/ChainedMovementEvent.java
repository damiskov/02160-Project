package property_changes;

import board.Position;

public class ChainedMovementEvent implements IPropertyChangeEvent {

	private int leadingRobotNumber;
	private int towedRobotNumber;
	private Position posChange;
	
	public ChainedMovementEvent(int leadingRobotNumber, int towedRobotNumber, Position posChange) {
		this.leadingRobotNumber = leadingRobotNumber;
		this.towedRobotNumber = towedRobotNumber;
		this.posChange = posChange;
	}

	public int getLeadingRobotNumber() {
		return leadingRobotNumber;
	}

	public int getTowedRobotNumber() {
		return towedRobotNumber;
	}
	
	public Position getPosChange() {
		return posChange;
	}




	
	
}
