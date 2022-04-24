package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import property_changes.PropertyChangeType;

public class Teleporter extends EnvironmentElement {
	private Teleporter receiving;
	private boolean Sending;
	
	public void setSending(boolean isSending) {
		this.Sending = isSending;
	}
	
	public boolean IsSending() {
		return this.Sending;
	}
	
	public static final String ID = "teleporter";
	
	public void setReceiving(Teleporter receiving) {
		this.receiving = receiving;
	}
	
	@Override
	public String getPieceID() {
		return ID;
	}


	@Override
	public void performRegisterAction() {
		Position p = calculatePosition();
		if (board.hasRobotAt(p) && IsSending() == true) {
			Robot r = board.getRobotAt(p);
			Position receivingP = receiving.calculatePosition();
			board.moveRobotFromTo(p, receivingP);
			System.out.println( r + " is being moved to " + receiving.calculatePosition());
			// TODO: if there is a robot on the receiving teleporter, kill it
			getPropertyChangeSupport().firePropertyChange(PropertyChangeType.TELEPORT, p, receivingP);
		}
	}
}

