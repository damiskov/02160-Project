package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import property_changes.TeleportEvent;

public class Teleporter extends EnvironmentElement {
	private Teleporter receiving;
	private boolean sending;
	
	public Teleporter(boolean sending) {
		this.sending = sending;
		
	}

	public Teleporter() {
		
	}

	



	public boolean isSending() {
		return this.sending;
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
		if (board.hasRobotAt(p) && isSending()) { //if a robot is on a sending teleporter
			Robot r = board.getRobotAt(p);
			Position receivingP = receiving.calculatePosition();
			
			//if there is a robot on the receiving teleporter, kill it
			if(board.hasRobotAt(receivingP)) {
				board.getRobotAt(receivingP).reboot();
			}
			
			board.moveRobotFromTo(p, receivingP); //teleport it to the receiving teleporter
			System.out.println( r + " is being moved to " + receiving.calculatePosition());			
			
			getPropertyChangeSupport().firePropertyChange(new TeleportEvent(r.getRobotNumber(), receivingP));
		}
	}
}

