package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import property_changes.TeleportEvent;

public class Teleporter extends EnvironmentElement {
	private Teleporter receiving;
	private boolean Sending;
	
	//getter and setter for sending
	public void setSending(boolean isSending) {
		this.Sending = isSending;
	}
	
	public boolean IsSending() {
		return this.Sending;
	}
	
	public static final String ID = "teleporter";
	
	//setter for receiving
	public void setReceiving(Teleporter receiving) {
		this.receiving = receiving;
	}
	
	@Override
	public String getPieceID() {
		return ID;
	}

	//performRegisterAction implements the game functionality of the obstacle
	@Override
	public void performRegisterAction() {
		Position p = calculatePosition();
		if (board.hasRobotAt(p) && IsSending() == true) { //if a robot is on a sending teleporter
			Robot r = board.getRobotAt(p);
			Position receivingP = receiving.calculatePosition();
			
			//if there is a robot on the receiving teleporter, kill it
			if(board.hasRobotAt(receivingP)) {
				board.getRobotAt(receivingP).reboot();
			}
			
			board.moveRobotFromTo(p, receivingP); //teleport it to the receiving teleporter
			System.out.println( r + " is being moved to " + receiving.calculatePosition());			
			
			getPropertyChangeSupport().firePropertyChange(new TeleportEvent(p, receivingP));
		}
	}
}

