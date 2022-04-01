package environment_elements;

import piece_basics.EnvironmentElement;

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
