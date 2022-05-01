package property_changes;

import game_basics.Position;


public class TeleportEvent implements IPropertyChangeEvent {

	private int robotNumber;
	private Position posNew;
	
	public TeleportEvent(int robotNumber, Position posNew) {
		this.robotNumber = robotNumber;
		this.posNew = posNew;
	}
	
	public int getRobotNum() {
		return robotNumber;
	}
	
	public Position getPosNew() {
		return posNew;
	}


	
	
	
	
}
