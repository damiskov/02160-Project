package board;

import piece_basics.Orientation;

public class PropertyChangeEvent {

	private PropertyChangeType propertyChangeType;
	private String ID;
	private Position posCurrent;
	private Position posNew;
	private Orientation orientationOld;
	private Orientation orientationNew;
	
	
	public PropertyChangeEvent(PropertyChangeType propertyChangeType, String ID, Position posCurrent, Position posNew,
			Orientation orientOld, Orientation orientNew) {
		super();
		this.propertyChangeType = propertyChangeType;
		this.posCurrent = posCurrent;
		this.posNew = posNew;
		this.orientationOld = orientOld;
		this.orientationNew = orientNew;
		this.ID = ID;
		
	}



	public PropertyChangeType getPropertyChangeType() {
		return propertyChangeType;
	}
	
	public String getID() {
		return ID;
	}


	public Position getPosCurrent() {
		return posCurrent;
	}


	public Position getPosNew() {
		return posNew;
	}


	public Orientation getOrientationOld() {
		return orientationOld;
	}


	public Orientation getOrientationNew() {
		return orientationNew;
	}

	
	
}
