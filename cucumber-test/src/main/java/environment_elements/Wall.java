package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class Wall extends EnvironmentElement implements IRegisterActor {
	
	
	public Wall(IBoard board, int x, int y) {
		super(board, x, y);
	}

	@Override
	public void performRegisterAction() {
	}

}
