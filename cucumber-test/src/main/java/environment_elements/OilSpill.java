package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class OilSpill extends EnvironmentElement implements IRegisterActor {

	@Override
	public void performRegisterAction() {
		board.initialPlacement(new Fire(), getPosition());
	}
}
