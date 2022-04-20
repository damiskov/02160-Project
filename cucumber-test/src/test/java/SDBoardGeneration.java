import static org.junit.Assert.assertEquals;

import board.Board;
import board.BoardFactory;
import board.BoardGenerator;
import board.Difficulty;
import board.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;
import player.Player;

public class SDBoardGeneration {
	
	Robot[] robots;
	Difficulty d;

	@Given("Robots")
	public void robots() {
	    Robot[] r = {new Robot(), new Robot()};
	    robots = r;
	}
	@Given("a Difficulty level")
	public void a_difficulty_level() {
		d = new Difficulty(1);
	}
	
	@Then("Generate board")
	public void generate_board()
	{
		new BoardFactory();
		Board b = BoardFactory.generateBoard(d, robots);
	}


}
