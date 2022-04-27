import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import property_changes.PropertyChangeSupport;
import view.MasterView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		Game game = new Game(pcs, int1);
		Difficulty d = new Difficulty(1);
		game.setDifficulty(d);
		context.game = game;
	}
	
	@Given("a medium game with {int} players")
	public void a_medium_game_with_players(Integer int1) {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, int1);
		Difficulty d = new Difficulty(2);
		game.setDifficulty(d);
		context.game = game;
	}
	
	@Given("a hard game with {int} players")
	public void a_hard_game_with_players(Integer int1) {
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Game game = new Game(pcs, int1);
		Difficulty d = new Difficulty(3);
		game.setDifficulty(d);
		context.game = game;
	}
	
	@When("the game begins")
	public void the_game_begins() {
	    context.game.Begin(context.game.getNumPlayers(), context.game.getDifficulty(), context.game.getPropertyChangeSupport());
	}
	
	@Then("the players are created")
	public void the_players_are_created() {
	    assertEquals(context.game.getPlayers().length, context.game.getNumPlayers());
	    for(int i = 0; i < context.game.getPlayers().length; i++) {
	    	assertTrue(context.game.getPlayers()[i] != null);
	    }
	}
	
	@Then("the robots for the players are created")
	public void the_robots_for_the_players_are_created() {
		assertEquals(context.game.getRobots().length, context.game.getNumPlayers());
	    for(int i = 0; i < context.game.getPlayers().length; i++) {
	    	assertTrue(context.game.getPlayers()[i].getRobot() != null);
	    }
	}
	
	@Then("the game has an easy board")
	public void the_game_has_an_easy_board() {
	    assertEquals(context.game.getBoard().getDifficulty().getLevel(), 1);
	}
	
	@Then("the game has a medium board")
	public void the_game_has_a_medium_board() {
	    assertEquals(context.game.getBoard().getDifficulty().getLevel(), 2);
	}
	
	@Then("the game has a hard board")
	public void the_game_has_a_hard_board() {
	    assertEquals(context.game.getBoard().getDifficulty().getLevel(), 3);
	}
}
