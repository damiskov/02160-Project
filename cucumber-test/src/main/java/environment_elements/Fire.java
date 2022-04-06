package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement {
	//necessary for the Then step in the step definitions, has a getter method lower
	private Position p;
	
	public static final String ID = "fire";
	
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

			
		board.initialPlacement(new Fire(), newX, newY);
		p.setX(newX);
		p.setY(newY);
		
		board.initialPlacement(new Fire(), newX, newY);
	}

	@Override
	public String getPieceID() {
		return ID;
	}
	
	public Position getP() {
		return p;
	}

}
