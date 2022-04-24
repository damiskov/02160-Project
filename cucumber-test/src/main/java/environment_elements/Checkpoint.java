package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import property_changes.GameWinEvent;

public class Checkpoint extends EnvironmentElement {
	public static final String ID = "checkpoint";
	
	private int number;
	private boolean finalCheckpoint;
	
	public Checkpoint(int number) {
		this.number = number;
		this.finalCheckpoint = false;
	}

	public Checkpoint(int number, boolean finalCheckpoint) {
		this.number = number;
		this.finalCheckpoint = finalCheckpoint;
	}

	@Override
	public void performImmediateAction(Robot r) {
		System.out.println("checkpoint activated");
		if (r.getMostRecentCheckpoint() + 1 == number) {
			r.setMostRecentCheckpoint(number);
			if (finalCheckpoint) {
				getPropertyChangeSupport().firePropertyChange(new GameWinEvent(r.getRobotNumber()));
			}
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
