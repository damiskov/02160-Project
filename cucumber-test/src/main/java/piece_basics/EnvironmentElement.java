package piece_basics;
import board.Position;

public abstract class EnvironmentElement extends Piece {
	public Position getPosition() {
		return board.getPosition(this);
	}
	public boolean isConveyorBlocking() {
		return false;
	}
	public boolean isLaserBlocking() {
		return false;
	}
}
