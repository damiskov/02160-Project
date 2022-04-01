package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Gear extends EnvironmentElement implements IRegisterActor {

	private boolean counterClockwise;

	public Gear(boolean counterClockwise) {
		this.counterClockwise = counterClockwise;
	}
	
	@Override
	public void performRegisterAction() {
		Position p = getPosition();
		if (board.hasRobotAt(p)) {
			if (counterClockwise) {
				board.getRobotAt(p).turnLeft();
			} else {
				board.getRobotAt(p).turnRight();
			}
		}
	}

}
