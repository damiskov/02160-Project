package environment_elements;
import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Orientation;

public class ConveyorBelt extends EnvironmentElement implements IRegisterActor {
	private Orientation orientation;
	
	public ConveyorBelt(IBoard board, int x, int y, Orientation orientation) {
		super(board, x, y);
		this.orientation = orientation;
	}

	@Override
	public void performRegisterAction() {
		// if a robot is on top of the conveyer, push the robot in the conveyer's direction unless there is a robot or wall in the way
		
		if (board.hasRobotAt(getX(), getY())) {
			int newX = 0;
			int newY = 0;
			
			switch (orientation) {
			case UP:
				newX = getX();
				newY = getY() + 1;
				break;
			case RIGHT:
				newX = getX() + 1;
				newY = getY();
				break;
			case DOWN:
				newX = getX();
				newY = getY() - 1;
				break;
			case LEFT:
				newX = getX() - 1;
				newY = getY();
				break;
			}
			
			if (!isBlocking(newX, newY)) {
				board.getRobotAt(getX(), getY()).setPosition(newX, newY);
			}
		}
	}
	
	private boolean isBlocking(int x, int y) {
		return board.hasRobotAt(x, y) || (board.hasEElementAt(x, y) && board.getEElementAt(x, y) instanceof Wall);
	}

}
