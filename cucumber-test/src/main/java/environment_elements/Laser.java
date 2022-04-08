package environment_elements;

import piece_basics.*;
import piece_basics.EnvironmentElement;

public class Laser extends EnvironmentElement {
	
	public static final String ID = "laser";

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getPosition())) {
			board.getRobotAt(getPosition()).takeDamage();
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}

