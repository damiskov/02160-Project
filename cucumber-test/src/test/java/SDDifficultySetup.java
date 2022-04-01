import static org.junit.Assert.assertEquals;

import board.Board;
import board.Game;
import board.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Piece;


public class SDDifficultySetup {
	
	
	private Context context;
	
	public SDDifficultySetup(Context context) {
		this.context = context;
	}
	
	
	//given an easy difficulty
	
	@Then("set number of obstacles")
	public void set_number_of_obstacles() {
		context.board.setNumberOfObstacles(5);
	}
	@Then("set obstacles on board")
	public void set_obstacles_on_board() {
		context.robot.setPosition(new Position(1, 2) );
	}
	@Then("Generate board")
	public void generate_board() {
	    context.game.genBoard();
	    
	    assertEquals(context.robot.getX(), 1);
	    assertEquals(context.robot.getY(), 2);
	    

	    assertEquals(context.board.getNumberObstacles(), 5);
	    
	}


}
