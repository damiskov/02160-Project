package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	public Position p;	
	public static final String ID = "fire";

	
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
		

	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
