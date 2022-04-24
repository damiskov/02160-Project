package property_changes;

import board.Position;

public class TeleportEvent implements IPropertyChangeEvent {

	private Position posCurrent;
	private Position posNew;
	
	public TeleportEvent(Position posOld, Position posNew) {
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
