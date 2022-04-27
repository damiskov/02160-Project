package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;

public class Checkpoint extends EnvironmentElement {
	public static final String ID = "checkpoint";
	
	private int number;
	private boolean finalCheckpoint;
	
	public Checkpoint(int number) {
		this.number = number;
	}

	@Override
	public void performImmediateAction(Robot r) {
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
