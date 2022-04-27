import static org.junit.Assert.assertEquals;

import board.Board;
import board.BoardFactory;
import board.BoardGenerator;
import board.BoardRetriever;
import board.Difficulty;
import board.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;
import player.Player;
import property_changes.PropertyChangeSupport;

public class SDBoardGeneration {
	

	private Context context;
	
	
	public SDBoardGeneration(Context context)
	{
		this.context = context;
	}
	
	@Given("two players")
	public void two_players() {
	    Player player = new Player();
	    Player player2 = new Player();
	    context.player = player;
	    context.player2 = player2;
	}
	
	@Given("robots for the players")
	public void robots_for_the_players() {
	    context.player.setRobot(new Robot());
	    context.player2.setRobot(new Robot());
	}

	
	
	@Given("a BoardFactory")
	public void a_BoardFactory() {
		BoardFactory bf = new BoardFactory();
	}
	
	@When ("a board is generated")
	public void a_board_is_generated()
	{
		Robot[] r = {context.player.getRobot(),context.player2.getRobot()};
		PropertyChangeSupport pcs = new PropertyChangeSupport();
		Board b = BoardFactory.generateBoard(context.d, r, pcs);
		context.board = b;
	}
	
	@Then("an easy board is generated")
	public void an_easy_board_is_generated() {
		assertEquals(context.board.getDifficulty().getLevel(), 1);
	    
	}
	@Then("a medium board is generated")
	public void a_medium_board_is_generated() {
		assertEquals(context.board.getDifficulty().getLevel(), 2);
	}
	@Then("a hard board is generated")
	public void a_hard_board_is_generated() {
		assertEquals(context.board.getDifficulty().getLevel(), 3);
	}

	@Then("no board is generated")
	public void no_board_is_generated() {
		assertEquals(context.board, null);
	}
}
