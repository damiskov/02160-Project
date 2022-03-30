package environment_elements;

import javax.naming.Context;

import board.Board;
import board.IBoard;
import piece_basics.IRegisterActor;

public class Fire extends EnvironmentElement implements IRegisterActor {
	
	public Fire(int x, int y) {
		super(x, y);
	}

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getX(), getY())) {
			board.getRobotAt(getX(), getY()).takeDamage();
		}
		if ( true /* change to turn passes when implemented*/) {
			int x_c = this.getX();
			int y_c = this.getY();
			
			int newX = x_c + (int)(Math.random() * 3) -1;
			int newY = y_c + (int)(Math.random() * 3) -1;
			
			board.place(new Fire(newX, newY));
		}
	}

//	public void spread() {
//		int x_c = this.getX();
//		int y_c = this.getY();
//		
//		int newX = x_c + (int)(Math.random() * 3) -1;
//		int newY = y_c + (int)(Math.random() * 3) -1;
//		
//		board.place(new Fire(newX, newY));
//	}
}
