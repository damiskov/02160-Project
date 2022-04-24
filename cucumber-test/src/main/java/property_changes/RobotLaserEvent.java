package property_changes;

import board.Position;

public class RobotLaserEvent implements IPropertyChangeEvent {
	
	private Position posStart;
	private Position posFinish;
	
	public RobotLaserEvent(Position posStart, Position posFinish) {
		this.posStart = posStart;
		this.posFinish = posFinish;
	}
	
	public Position getPosStart() {
		return posStart;
	}
	
	public Position getPosFinish() {
		return posFinish;
	}
	
	

}
