package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class RespawnPoint extends EnvironmentElement implements IRegisterActor {

	public RespawnPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getX(), getY())) {
			board.getRobotAt(getX(), getY()).setRespawnPoint(this);
		}
	}

}
