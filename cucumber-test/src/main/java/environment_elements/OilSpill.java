package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {

	public void ignite() {
		board.initialPlacement(new Fire(), getPosition());
	}
	
	@Override
	public void performRegisterAction() {
		
	}

	@Override
	public String getActorClassID() {
		return "oil_spill";
	}
}
