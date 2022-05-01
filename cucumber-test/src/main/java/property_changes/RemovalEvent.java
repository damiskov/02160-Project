package property_changes;

import game_basics.Position;

public class RemovalEvent implements IPropertyChangeEvent {

	private Position pos;

	public RemovalEvent(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
