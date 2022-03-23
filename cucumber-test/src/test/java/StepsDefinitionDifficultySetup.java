import board.Board;
import board.Game;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Piece;


public class StepsDefinitionDifficultySetup {
	
	Board board = new Board();
	Game game = new Game();
	
	
	@Given("A Difficulty")
	public void a_difficulty(String d) {
		game.setDifficulty(d);
	}
	
	@Then("set number of obstacles")
	public void set_number_of_obstacles(int n) {
	    board.setNumberOfObstacles(n);
	}
	@Then("set their location")
	public void set_location(Piece p, int x, int y) {
	    p.setPosition(x, y);
	}
	@Then("Generate board")
	public void generate_board() {
	    game.genBoard();
	}


}
