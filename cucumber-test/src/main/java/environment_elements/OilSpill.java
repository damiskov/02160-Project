package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {

	public void ignite() {
		board.initialPlacement(new Fire(), getPosition());
	}
	
	@Override
	public void performRegisterAction() {
		
	}
}
