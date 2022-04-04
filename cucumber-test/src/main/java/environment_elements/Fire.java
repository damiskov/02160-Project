package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {
	//necessary for the Then step in the step definitions, has a getter method lower
	private Position p;
	
	@Override
	public void performRegisterAction() {
		if(board.hasRobotAt(getPosition())) {
			board.getRobotAt(getPosition()).takeDamage();
		}
		
		Position p = getPosition();
		int x_c = p.getX();
		int y_c = p.getY();
		
		int newX = x_c + (int)(Math.random() * 3) -1;
		int newY = y_c + (int)(Math.random() * 3) -1;
		p.setX(newX);
		p.setY(newY);
		
		board.initialPlacement(new Fire(), newX, newY);
	}
	
	public Position getP() {
		return p;
	}
}
