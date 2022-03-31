package environment_elements;

import javax.naming.Context;

import board.Board;
import board.IBoard;
import board.Position;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {

	@Override
	public void performRegisterAction() {
		
	}

	public void spread() {
		Position p = getPosition();
		int x_c = p.getX();
		int y_c = p.getY();
		
		int newX = x_c + (int)(Math.random() * 3) -1;
		int newY = y_c + (int)(Math.random() * 3) -1;
		
		board.place(new Fire(), newX, newY);
	}
}
