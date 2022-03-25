package environment_elements;

import javax.naming.Context;

import board.Board;
import board.IBoard;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {
	
	public Fire(IBoard board, int x, int y) {
		super(board, x, y);
	}

	@Override
	public void performRegisterAction() {
		
	}

	public void spread(Board b) {
		int x_c = this.getX();
		int y_c = this.getY();
		
		int newX = x_c + (int)(Math.random() * 3) -1;
		int newY = y_c + (int)(Math.random() * 3) -1;
		
		Fire newF = new Fire(b, newX, newY);
	}
}
