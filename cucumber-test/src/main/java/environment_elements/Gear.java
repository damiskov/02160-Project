package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class Gear extends EnvironmentElement implements IRegisterActor {

	private boolean counterClockwise;

	
	public Gear(IBoard board, int x, int y,boolean counterClockwise) {
		super(board, x, y);
		this.counterClockwise = counterClockwise;
		
	}
	
	@Override
	public void performRegisterAction() {

	}

}
