package environment_elements;

import piece_basics.*;

public class Laser extends EnvironmentElement implements IRegisterActor{
	
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
