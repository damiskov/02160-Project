package environment_elements;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;

public class Wall extends EnvironmentElement {
	
	@Override
	public boolean isConveyorBlocking() {
		return true;
	}
	@Override
	public boolean isLaserBlocking() {
		return true;
	}
}
