package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;

public class Pit extends EnvironmentElement {

	public static final String ID = "pit";

	@Override
	public String getPieceID() {
		return ID;
	}

	@Override
	public void performImmediateAction(Robot r) {
		r.reboot();
	}
}
