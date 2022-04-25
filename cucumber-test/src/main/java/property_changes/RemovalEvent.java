package property_changes;

import board.Position;

public class RemovalEvent implements IPropertyChangeEvent {

	private Position pos;

	public RemovalEvent(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
