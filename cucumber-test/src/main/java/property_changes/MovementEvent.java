package property_changes;

import board.Position;

public class MovementEvent implements IPropertyChangeEvent {

	private Position posCurrent;
	private Position posNew;
	
	public MovementEvent(Position posOld, Position posNew) {
		this.posCurrent = posOld;
		this.posNew = posNew;
	}

	public Position getPosCurrent() {
		return posCurrent;
	}

	public Position getPosNew() {
		return posNew;
	}
}
