package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class Pit extends EnvironmentElement implements IRegisterActor {
	
	public Pit(IBoard board, int x, int y) {
		super(board, x, y);
	}

	@Override
	public void performRegisterAction() {

	}

}
