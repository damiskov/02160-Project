package piece_basics;
import board.Position;

public abstract class EnvironmentElement extends Piece {
	public Position getPosition() {
		return board.getPosition(this);
	}
	public int getX() {
		return board.getPosition(this).getX();
	}
	public int getY() {
		return board.getPosition(this).getY();
	}
	
	public boolean isConveyorBlocking() {
		return false;
	}
	public boolean isLaserBlocking() {
		return false;
	}
}
