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

public class SDBoardGeneration {
	

	private Context context;
	
	
	public SDBoardGeneration(Context context)
	{
		this.context = context;
	}
	
	@Given("two players")
	public void two_players() {
	    Player player = new Player();
	    Player player1 = new Player();
	    context.player = player;
	    context.player1 = player1;
	}
	
	@Given("robots for the players")
	public void robots_for_the_players() {
	    context.player.setRobot(new Robot());
	    context.player1.setRobot(new Robot());
	}

	@Given("an easy difficulty")
	public void an_easy_difficulty() {
		context.d = new Difficulty(1);
	}
	
	@Given("a medium difficulty")
	public void a_medium_difficulty() {
		context.d = new Difficulty(2);
	}
	
	@Given("a hard difficulty")
	public void a_hard_difficulty() {
		context.d = new Difficulty(3);
	}
	@When ("a board is generated")
	public void a_board_is_generated()
	{
		Robot[] r = {context.player.getRobot(),context.player1.getRobot()};
		Board b = BoardFactory.generateBoard(context.d, r);
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

}
