import io.cucumber.java.en.Given;
import piece_basics.*;

public class SDPiece {
	private Context context;

	public SDPiece(Context context) {
		this.context = context;
	}

	@Given("a piece")
	public void a_piece() { 
		context.robot = new Robot();
		context.board.initialPlacement(context.robot, 5, 5);
	}
}
