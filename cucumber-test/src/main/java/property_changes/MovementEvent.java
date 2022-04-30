package property_changes;

import board.Position;

public class MovementEvent implements IPropertyChangeEvent {

	
	private int robotNumber;
	private Position oldPos;
	private Position newPos;
	
	public MovementEvent(int robotNumber,Position oldPos, Position newPos) {
		this.robotNumber = robotNumber;
		this.oldPos = oldPos;
		this.newPos = newPos;
	}
	
	public int getRobotNum() {
		return robotNumber;
	}

	public Position getOldPos() {
		return oldPos;
	}

	public Position getNewPos() {
		return newPos;
	}
	
	
}
