package property_changes;

import board.Position;

public class ChainingPanelActivationEvent implements IPropertyChangeEvent {

	private Position pos;

	public ChainingPanelActivationEvent(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
