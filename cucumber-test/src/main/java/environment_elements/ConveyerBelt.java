package environment_elements;
import piece_basics.IRegisterActor;
import piece_basics.Orientation;

public class ConveyerBelt extends EnvironmentElement implements IRegisterActor {
	
	private Orientation orientation;
	
	public ConveyerBelt(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public void performRegisterAction() {
		// if a robot is on top of the conveyer, push the robot in the conveyer's direction
	}

}
