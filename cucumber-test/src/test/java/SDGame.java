import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
	
	@Given("a game with an empty board")
	public void a_game_with_an_empty_board() {
	    Game game = new Game();
	    Board board = new Board(12, 12);
	    game.setBoard(board);
	    context.game = game;
	    context.board = board;
	}
	
	@When("the board elements activate")
	public void the_board_elements_activate() {
		context.game.activateRegisterActors();
	}
}
