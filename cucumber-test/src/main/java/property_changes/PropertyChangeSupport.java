package property_changes;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used by model classes to inform the view about property changes. It uses the observer
 * pattern by having a list of subscribers implementing IPropertyChangeListener, and whenever firePropertyChange
 * is called, it informs all subscribers by calling propertyChange on them.
 */
public class PropertyChangeSupport {

	private List<IPropertyChangeListener> subscribers = new ArrayList<>();
	
	public void addSubscriber(IPropertyChangeListener pcl) {
		subscribers.add(pcl);
	}
	
	public void removeSubscriber(IPropertyChangeListener pcl) {
		subscribers.remove(pcl);
	}
	
	public void firePropertyChange(IPropertyChangeEvent event) {
		for (IPropertyChangeListener pcl: subscribers) {
			pcl.propertyChange(event);
		}
	}
	
	


}
