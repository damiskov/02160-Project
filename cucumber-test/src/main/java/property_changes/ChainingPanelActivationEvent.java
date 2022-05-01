package property_changes;

import game_basics.Position;

public class ChainingPanelActivationEvent implements IPropertyChangeEvent {

	private Position pos;

	public ChainingPanelActivationEvent(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	
}
