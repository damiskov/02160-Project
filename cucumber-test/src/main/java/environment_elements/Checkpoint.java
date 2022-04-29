package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import property_changes.GameWinEvent;

public class Checkpoint extends EnvironmentElement {
	public static final String ID = "checkpoint";
	
	private int number;
	
	public Checkpoint(int number) {
		this.number = number;
	}

	@Override
	public void performImmediateAction(Robot r) {
		System.out.println("checkpoint activated");
		/*
		 * If this checkpoint's number is one greater than the robot's most recent checkpoint, this is indeed the next checkpoint it had to go to,
		 * so its most recent checkpoint number can be incremented
		 */
		if (r.getMostRecentCheckpoint() + 1 == number) {
			r.setMostRecentCheckpoint(number);
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
	
	public int getNumber() {
		return number;
	}

}
