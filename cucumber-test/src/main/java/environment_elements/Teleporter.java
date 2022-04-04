package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Teleporter extends EnvironmentElement implements IRegisterActor{

	private Teleporter receiving;
	
	public void setReceiving(Teleporter receiving) {
		this.receiving = receiving;
	}

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getPosition())) {
			board.moveRobotFromTo(getPosition(), receiving.getPosition());
		}
		
	}
}