import io.cucumber.java.en.Given;
import board.*;

public class SDGame {
	private Context context;

	public SDGame(Context context) {
		this.context = context;
	}

	@Given("a game")
	public void a_game() {
	    context.game = new Game();
	}
}
