package environment_elements;

import board.IBoard;
import piece_basics.*;

public class Laser extends EnvironmentElement implements IRegisterActor{
	
	public Laser(IBoard board, int x, int y) {
		super(board, x, y);
		// TODO Auto-generated constructor stub
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
