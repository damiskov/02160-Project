package environment_elements;

import board.IBoard;
import piece_basics.*;

public class Laser extends EnvironmentElement implements IRegisterActor{
	
	public Laser(int x, int y) {
		super(x, y);
	}

	public void interact(Robot r) {
		r.takeDamage();
	}
	
	public void activate(Robot r) {
		if(this.getX() == r.getX() && this.getY() == r.getY()) {
			this.interact(r);
		}
			
	}
	
	@Override
	public void performRegisterAction() {
		
	}
}

