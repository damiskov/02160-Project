package environment_elements;
import board.Position;
import piece_basics.Piece;

public abstract class EnvironmentElement extends Piece {
	public Position getPosition() {
		return board.getPosition(this);
	}
}
