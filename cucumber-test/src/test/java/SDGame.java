import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import property_changes.PropertyChangeSupport;
import view.MasterView;
import board.*;

public class SDGame {
	private Context context;

	public SDGame(Context context) {
		this.context = context;
	}
	
	@Given("a game with an empty board")
	public void a_game_with_an_empty_board() {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, 2);
	    Board board = new Board(12, 12, game);
	    game.setBoard(board);
	    context.game = game;
	    context.board = board;
	}
	
	@Given("a game with a {int} x {int} board")
	public void a_game_with_a_x_board(Integer int1, Integer int2) {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, 2);
	    Board board = new Board(int1, int2, game);
	    game.setBoard(board);
	    context.game = game;
	    context.board = board;
	}
	
	@When("the board elements activate")
	public void the_board_elements_activate() {
		context.game.activateRegisterActors();
	}
}
