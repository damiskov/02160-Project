package environment_elements;

import piece_basics.IRegisterActor;

public class Gear extends EnvironmentElement implements IRegisterActor {

	private boolean counterClockwise;
	//testing
	public Gear(boolean counterClockwise) {
		super();
		this.counterClockwise = counterClockwise;
	}
	
	@Override
	public void performRegisterAction() {

	}

}
