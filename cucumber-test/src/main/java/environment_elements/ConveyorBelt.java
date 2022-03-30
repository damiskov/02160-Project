package environment_elements;
import board.IBoard;
import board.Position;
import piece_basics.IRegisterActor;
import piece_basics.Orientation;
import piece_basics.Robot;

public class ConveyorBelt extends EnvironmentElement implements IRegisterActor {
	
	private Orientation orientation;
	
	public ConveyorBelt(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public void performRegisterAction() {
		// if a robot is on top of the conveyer, push the robot in the conveyer's direction unless there is a robot or wall in the way
		
		Position p = getPosition();
		
		if (board.hasRobotAt(p)) {
			Position newP = getPosition();
			
			switch (orientation) {
			case UP:
				newP.incrY(1);
				break;
			case RIGHT:
				newP.incrX(1);
				break;
			case DOWN:
				newP.incrY(-1);
				break;
			case LEFT:
				newP.incrX(-1);
				break;
			}
			
			if (!isBlocking(p)) {
				board.moveRobotFromTo(p, newP);
			}
		}
	}
	
	private boolean isBlocking(Position p) {
		return board.hasRobotAt(p) || (board.hasEElementAt(p) && board.getEElementAt(p) instanceof Wall);
	}

}
