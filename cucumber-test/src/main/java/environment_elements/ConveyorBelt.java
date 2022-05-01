package environment_elements;
import game_basics.Position;
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
		/* 
		 * If a robot is on top of the conveyor, push the robot in the conveyor's direction unless there is something blocking it (explained in
		 * the conveyorBlocking method)
		 */
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
				firePropertyChange(new MovementEvent(robot.getRobotNumber(), p, newP));
				board.moveRobotFromTo(p, newP);
			}
		}
	}
	
	/*
	 *  Conveyor belts should only move the robot on them if the position the robot would be pushed to does not have a robot-blocking
	 *  environment element (like a wall) or another robot. This helper method returns true if the position has one of these things, and
	 *  false otherwise.
	 */
	private boolean conveyorBlocking(Position p) {
		return board.hasRobotAt(p) || (board.hasEElementAt(p) && board.getEElementAt(p).isRobotBlocking());
	}

	@Override
	public String getPieceID() {
		return ID;
	}

	public Orientation getOrientation() {
		return orientation;
	}

}
