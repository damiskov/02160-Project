package property_changes;

/*
 *  Common superinterface for all property change events fired by the model to the view. It is empty because
 *  the information required depends on the event type. MasterView and BoardPanel use instanceof to differentiate
 *  between different event types.
 */
public interface IPropertyChangeEvent {}
