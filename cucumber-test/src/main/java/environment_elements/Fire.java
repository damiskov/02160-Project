package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	public Position p;	//ask Andrea about this
	public static final String ID = "fire";

	
	@Override
	public void performRegisterAction() {
		if(board.hasRobotAt(calculatePosition())) {
			board.getRobotAt(calculatePosition()).takeDamage();
		}
		
		p = calculatePosition();

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
