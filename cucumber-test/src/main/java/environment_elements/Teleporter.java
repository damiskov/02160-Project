package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class Teleporter extends EnvironmentElement implements IRegisterActor{

	public Teleporter(int x, int y) {
		super(x, y);
	}

	public void interact(Robot r, Teleporter t ) {
		r.setPosition(t.getX(),t.getY());
	}
	
	public void activate(Robot r, Teleporter t) {
		if(this.getX() == r.getX() && this.getY() == r.getY()) {
			this.interact(r,t);
		}
			
	}
	
	@Override //can't figure out how to use this in this case so I kept the two other methods
	public void performRegisterAction() {
	}


}
