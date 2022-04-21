package board;

import java.util.ArrayList;
import java.util.List;

import piece_basics.Orientation;
import piece_basics.Piece;
import view.PropertyChangeListener;

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
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, piece, pos, null, null, null));
	}
	
	// for activating or removing elements
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position pos) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, pos, null, null, null));
	}
	
	// for movements and teleports
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position posOld, Position posNew) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, posOld, posNew, null, null));
	}
	
	// for rotations
	public void firePropertyChange(PropertyChangeType propertyChangeType, Position pos, Orientation orientOld, Orientation orientNew) {
		firePropertyChange(new PropertyChangeEvent(propertyChangeType, null, pos, null, orientOld, orientNew));
	}
	
	


}
