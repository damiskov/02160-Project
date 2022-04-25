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
	
	public void firePropertyChange(IPropertyChangeEvent pci) {
		for (PropertyChangeListener vf: subscribers) {
			vf.propertyChange(pci);
		}
	}
	
	


}
