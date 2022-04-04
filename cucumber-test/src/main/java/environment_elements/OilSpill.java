package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {

	@Override
	public void performRegisterAction() {
		Position p = this.getPosition();
		board.removeEElement(this.getX(),this.getY());
		board.initialPlacement(new Fire(), p);
	}

	@Override
	public String getActorClassID() {
		return "oil_spill";
	}
}
