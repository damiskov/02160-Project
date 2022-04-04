package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {

	@Override
	public void performRegisterAction() {

		if (board.hasRobotAt(new Position( getX(), getY()))) {
			board.getRobotAt(new Position(getX(), getY())).takeDamage();
		}
		int x_c = this.getX();
		int y_c = this.getY();

		int newX = x_c + (int)(Math.random() * 3) -1;
		int newY = y_c + (int)(Math.random() * 3) -1;
			
		board.initialPlacement(new Fire(), newX, newY);
	}

}
