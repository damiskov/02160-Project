import board.Board;
import io.cucumber.java.en.Given;

public class SDBoard {
	private Context context;

	public SDBoard(Context context) {
		this.context = context;
	}

	@Given("a board")
	public void a_board() {
	    context.board = new Board(10, 10);
	}
}
