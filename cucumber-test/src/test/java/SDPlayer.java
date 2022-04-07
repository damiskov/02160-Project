import board.Board;
import io.cucumber.java.en.Given;
import player.Player;

public class SDPlayer {

	private Context context;

	public SDPlayer(Context context) {
		this.context = context;
	}

	@Given("a player")
	public void a_player() {
	    context.player = new Player();
	}
	
}
