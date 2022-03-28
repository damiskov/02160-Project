import board.Board;
import io.cucumber.java.en.Given;

public class SDButton {
	
	
	private Context context;

	public SDButton(Context context) {
		this.context = context;
	}

	@Given("a start button")
	public void a_board() {
	    context.startButton = new Button();
	}
	
}
