package environment_elements;

import board.IBoard;
import piece_basics.*;

public class Laser extends EnvironmentElement implements IRegisterActor{
	
	public Laser(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getX(), getY())) {
			board.getRobotAt(getX(), getY()).takeDamage();
		}
	}
}

