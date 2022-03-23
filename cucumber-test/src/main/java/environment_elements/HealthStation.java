package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class HealthStation extends EnvironmentElement implements IRegisterActor {
	
	public HealthStation(IBoard board, int x, int y) {
		super(board, x, y);
	}

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getX(), getY())) {
			Robot r = board.getRobotAt(getX(), getY());
			r.setHealth(r.getHealth() + 1);
		}
	}

}
