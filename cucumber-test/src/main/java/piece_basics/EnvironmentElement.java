package piece_basics;
import board.Position;
import environment_elements.Teleporter;
import environment_elements.Wall;

public abstract class EnvironmentElement extends Piece {
	public Position calculatePosition() {
		return board.calculatePosition(this);
	}
	public int getX() {
		return board.calculatePosition(this).getX();
	}
	public int getY() {
		return board.calculatePosition(this).getY();
	}
	
	public boolean isConveyorBlocking() {
		return false;
	}
	public boolean isLaserBlocking() {
		return false;
	}
	public boolean isWallCollsion() {
		return false;
	}
	
	// This method is called by Board whenever a Robot moves onto this environment element, and the robot is passed as argument.
	public void performImmediateAction(Robot robot) {}
	

}
