package environment_elements;

import board.Position;
import piece_basics.IRegisterActor;

public class HealthStation extends EnvironmentElement implements IRegisterActor {

	@Override
	public void performRegisterAction() {
		Position p = getPosition();
		if (board.hasRobotAt(p)) {
			board.getRobotAt(p).heal();
		}
	}

}
