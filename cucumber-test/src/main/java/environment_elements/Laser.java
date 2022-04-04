package environment_elements;

import piece_basics.*;
import piece_basics.EnvironmentElement;

public class Laser extends EnvironmentElement implements IRegisterActor{

	public void interact(Robot r) {
		r.takeDamage();
	}
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getPosition())) {
			board.getRobotAt(getPosition()).takeDamage();
		}
	}
}

