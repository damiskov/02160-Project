import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import property_changes.PropertyChangeSupport;
import view.MasterView;

import static org.junit.Assert.assertFalse;

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
	    Board board = new Board(12, 12, pcs);
	    game.setBoard(board);
	    context.game = game;
	    context.board = board;
	}
	
	@Given("a game with a {int} x {int} board")
	public void a_game_with_a_x_board(Integer int1, Integer int2) {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, 2);
	    Board board = new Board(int1, int2, pcs);
	    game.setBoard(board);
	    context.game = game;
	    context.board = board;
	}
	
	@When("the board elements activate")
	public void the_board_elements_activate() {
		context.game.activateRegisterActors();
	}
	
	@Given("an easy game with {int} players")
	public void an_easy_game_with_players(Integer int1) {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, 2);
		game.setDifficulty(1);
		context.game = game;
	}
	
	@When("the game begins")
	public void the_game_begins() {
	    context.game.Begin(context.game.getNumPlayers(), context.game.getDifficulty(), context.game.getPropertyChangeSupport());
	}
	
	@Then("the players are created")
	public void the_players_are_created() {
	    //assertFalse(context.game.getPlayers(), null);
	    
	}
}
