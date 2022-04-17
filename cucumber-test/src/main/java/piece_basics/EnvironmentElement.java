package piece_basics;
import board.Position;

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
	};
	

}
