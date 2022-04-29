package environment_elements;
import board.Position;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;
import property_changes.MovementEvent;

public class ConveyorBelt extends EnvironmentElement {
	
	private Orientation orientation;
	
	public static final String ID = "conveyor_belt";
	
	public ConveyorBelt(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public void performRegisterAction() {
		// if a robot is on top of the conveyor, push the robot in the conveyor's direction unless there is a robot or wall in the way
		Position p = calculatePosition();
		
		if (board.hasRobotAt(p)) {
			Robot robot = board.getRobotAt(p);
			Position newP = calculatePosition();
			
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
			
			if (board.coordinateWithinBounds(newP) && !conveyorBlocking(newP)) {
				firePropertyChange(new MovementEvent(robot.getRobotNumber(), newP.subtract(p)));
				board.moveRobotFromTo(p, newP);
			}
		}
	}
	
	private boolean conveyorBlocking(Position p) {
		return board.hasRobotAt(p) || (board.hasEElementAt(p) && board.getEElementAt(p).isConveyorBlocking());
	}

	@Override
	public String getPieceID() {
		return ID;
	}

	public Orientation getOrientation() {
		return orientation;
	}

}
