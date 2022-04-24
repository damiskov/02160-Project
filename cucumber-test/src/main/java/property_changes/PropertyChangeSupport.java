package property_changes;

import java.util.ArrayList;
import java.util.List;

import board.Position;
import piece_basics.Orientation;
import piece_basics.Piece;

public class PropertyChangeSupport {

	private List<PropertyChangeListener> subscribers = new ArrayList<>();
	
	public void addSubscriber(PropertyChangeListener vf) {
		subscribers.add(vf);
	}
	
	public void removeSubscriber(PropertyChangeListener vf) {
		subscribers.remove(vf);
	}
	
	public void firePropertyChange(PropertyChangeEvent pci) {
		for (PropertyChangeListener vf: subscribers) {
			vf.propertyChange(pci);
		}
	}
	
	// for adding elements
	public void firePropertyChange(PropertyChangeType propertyChangeType, Piece piece, Position pos) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, piece, pos, null, null, null, 0, 0));
	}
	
	// for activating or removing elements
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position pos) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, pos, null, null, null, 0, 0));
	}
	
	// for movements, teleports, and robot lasers
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position posOld, Position posNew) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, posOld, posNew, null, null, 0, 0));
	}
	
	// for rotations
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position pos, Orientation orientOld, Orientation orientNew) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, pos, null, orientOld, orientNew, 0, 0));
	}
	
	// for health changes
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position pos, int health, int robotNum) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, pos, null, null, null, health, robotNum));
	}
	
	


}
