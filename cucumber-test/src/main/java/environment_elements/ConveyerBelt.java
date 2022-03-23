package environment_elements;
import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Orientation;

public class ConveyerBelt extends EnvironmentElement implements IRegisterActor {
	private Orientation orientation;
	
	public ConveyerBelt(IBoard board, int x, int y, Orientation orientation) {
		super(board, x, y);
		this.orientation = orientation;
	}



	@Override
	public void performRegisterAction() {
		// if a robot is on top of the conveyer, push the robot in the conveyer's direction
		if (board.hasRobotAt(getX(), getY())) 

	}

}
