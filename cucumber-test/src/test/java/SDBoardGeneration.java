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
	
	private Robot[] robots;
	private Difficulty d;
	private Context context;
	
	
	public SDBoardGeneration(Context context)
	{
		this.context = context;
	}
	
	@Given("two players")
	public void two_players() {
	    Player player1 = new Player();
	}
	
	@Given("robots for the players")
	public void robots_for_the_players() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("an easy difficulty")
	public void an_easy_difficulty() {
		d.setLevel(3);
	}
	
	@Given("a medium difficulty")
	public void a_medium_difficulty() {
	    d.setLevel(2);
	}
	
	@Given("a hard difficulty")
	public void a_hard_difficulty() {
		d.setLevel(3);
	}
	@When ("A board is generated")
	public void a_board_is_generated()
	{
		
		context.board = BoardFactory.generateBoard(d, robots);
	}
	
	@Then("An easy board is generated")
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
