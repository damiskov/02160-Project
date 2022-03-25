package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {


	public OilSpill(IBoard board, int x, int y) {
		super(board, x, y);
	}

	public void ignite() {
		Fire f = new Fire(board, this.xPos, this.yPos);
	}
	
	@Override
	public void performRegisterAction() {
		
	}
}
