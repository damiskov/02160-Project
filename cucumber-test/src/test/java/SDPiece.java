import io.cucumber.java.en.Given;
import piece_basics.*;

public class SDPiece {
	private Context context;

	public SDPiece(Context context) {
		this.context = context;
	}

	@Given("a piece")
	public void a_piece() { 
		//context.piece = new Robot(context.board, 5, 5);
	}
}
