package environment_elements;

import game_basics.Position;
import piece_basics.EnvironmentElement;

public class HealthStation extends EnvironmentElement {

	public static final String ID = "health_station";

	//if it has a robot on it, heal it
	@Override
	public void performRegisterAction() {
		Position p = calculatePosition();
		if (board.hasRobotAt(p)) {
			board.getRobotAt(p).heal();
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
