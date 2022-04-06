package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {

	public Position p; 
	
	@Override
	public void performRegisterAction() {
		p = this.getPosition();
		board.removeEElement(this.getX(),this.getY());
		board.initialPlacement(new Fire(), p);
		
		board.getRobotAt(p).takeDamage();
	}
}
