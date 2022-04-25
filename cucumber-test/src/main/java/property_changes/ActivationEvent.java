package property_changes;

import board.Position;

public class ActivationEvent implements IPropertyChangeEvent {

	private Position pos;

	public ActivationEvent(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
