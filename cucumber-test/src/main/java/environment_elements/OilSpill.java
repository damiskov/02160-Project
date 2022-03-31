package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {


	public OilSpill(int x, int y) {
		super(x, y);
	}

	public void ignite() {
		board.place(new Fire(this.getX(), this.getY()));
	}
	
	@Override
	public void performRegisterAction() {
		
	}
}
