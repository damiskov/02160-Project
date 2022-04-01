package environment_elements;

import board.IBoard;
import piece_basics.*;
import piece_basics.EnvironmentElement;

public class Laser extends EnvironmentElement implements IRegisterActor{

	public void interact(Robot r) {
		r.takeDamage();
	}
	
	// needs changing, you need to first check if a robot exists at your position, and then interact with it. Same issue in Teleporter
	
//	public void activate(Robot r) {
//		if(this.getX() == r.getX() && this.getY() == r.getY()) {
//			this.interact(r);
//		}
//			
//	}
	
	@Override
	public void performRegisterAction() {
		
	}

	@Override
	public String getActorClassID() {
		return "laser";
	}
}

