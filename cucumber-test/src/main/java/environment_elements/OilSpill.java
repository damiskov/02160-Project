package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {


	public OilSpill(int x, int y) {
		super(x, y);
	}
	
	@Override 
	public void performRegisterAction() {
		board.removeEElement(this.getX(), this.getY());
		board.place(new Fire(this.getX(), this.getY()));
	}
}
