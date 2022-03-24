package environment_elements;

import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class Teleporter extends EnvironmentElement implements IRegisterActor{
	
	public void interact(Robot r, Teleporter t ) {
		r.setPosition(t.getX(),t.getY());
	}
	
	public void activate(Robot r, Teleporter t) {
		if(this.getX() == r.getX() && this.getY() == r.getY()) {
			this.interact(r,t);
		}
			
	}
	
	@Override
	public void performRegisterAction() {
		
	}
}
