package environment_elements;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class Teleporter extends EnvironmentElement implements IRegisterActor{

	public void interact(Robot r, Teleporter t ) {
		r.setPosition(t.getPosition());
	}
	
	// needs changing, you need to first check if a robot exists at your position, and then interact with it. Same issue in Laser
//	public void activate(Robot r, Teleporter t) {
//		if(this.getX() == r.getX() && this.getY() == r.getY()) {
//			this.interact(r,t);
//		}
//			
//	}
	
	@Override
	public void performRegisterAction() {
		
	}

	@Override
	public String getActorClassID() {
		return "teleporter";
	}
}
