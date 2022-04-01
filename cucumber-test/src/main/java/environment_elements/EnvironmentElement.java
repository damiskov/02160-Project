package environment_elements;
import board.Position;
import piece_basics.Piece;

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
}
