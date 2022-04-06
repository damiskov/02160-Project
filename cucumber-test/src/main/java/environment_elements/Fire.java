package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {
	
	public Position p;
	
	@Override
	public void performRegisterAction() {
		if(board.hasRobotAt(getPosition())) {
			board.getRobotAt(getPosition()).takeDamage();
		}
		
		p = getPosition();
		int x_c = p.getX();
		int y_c = p.getY();
		
		int newX = x_c + (int)(Math.random() * 3) -1;
		int newY = y_c + (int)(Math.random() * 3) -1;

		
		p.setX(newX);
		p.setY(newY);
		board.initialPlacement(new Fire(), p);
		System.out.println(board.getEElementAt(p) instanceof Fire); //this evaluates to true
	}

}
