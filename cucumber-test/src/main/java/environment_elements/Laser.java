package environment_elements;

import piece_basics.*;

public class Laser extends EnvironmentElement {
	
	public static final String ID = "laser";

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			System.out.println(board.getRobotAt(calculatePosition()) + " got damaged by the laser");
			board.getRobotAt(calculatePosition()).takeDamage();
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}

