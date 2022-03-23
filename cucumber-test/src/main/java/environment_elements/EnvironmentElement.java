package environment_elements;
import board.IBoard;
import piece_basics.Piece;

public abstract class EnvironmentElement extends Piece {

	public EnvironmentElement(IBoard board, int x, int y) {
		super(board, x, y);
	}

	
}
