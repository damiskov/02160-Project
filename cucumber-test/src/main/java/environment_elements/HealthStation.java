package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class HealthStation extends EnvironmentElement {

	public static final String ID = "health_station";

	@Override
	public void performRegisterAction() {
		Position p = getPosition();
		if (board.hasRobotAt(p)) {
			board.getRobotAt(p).heal();
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
