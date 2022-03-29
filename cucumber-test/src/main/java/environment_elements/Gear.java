package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class Gear extends EnvironmentElement implements IRegisterActor {

	private boolean counterClockwise;

	public Gear(int x, int y, boolean counterClockwise) {
		super(x, y);
		this.counterClockwise = counterClockwise;
	}
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getX(), getY())) {
			if (counterClockwise) {
				board.getRobotAt(getX(), getY()).turnLeft();
			} else {
				board.getRobotAt(getX(), getY()).turnRight();
			}
		}
	}

}
