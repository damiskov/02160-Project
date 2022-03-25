import static org.junit.Assert.assertEquals;

import board.Board;
import board.Game;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Piece;


public class SDDifficultySetup {
	
	
	private Context context;
	
	public SDDifficultySetup(Context context) {
		this.context = context;
	}
	
	
	@Given("A Difficulty")
	public void a_difficulty(String d) {
		context.game.setDifficulty(d);
	}
	
	@Then("set number of obstacles")
	public void set_number_of_obstacles() {
		context.board.setNumberOfObstacles(5);
	}
	@Then("set their location")
	public void set_location() {
		context.piece.setPosition(1, 2);
	}
	@Then("Generate board")
	public void generate_board() {
	    context.game.genBoard();
	    
	    assertEquals(context.piece.getX(), 1);
	    assertEquals(context.piece.getY(), 2);
	    

	    assertEquals(context.board.getNumberObstacles(), 5);
	    
	}


}
