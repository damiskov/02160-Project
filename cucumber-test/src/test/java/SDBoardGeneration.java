import static org.junit.Assert.assertEquals;

import board.Board;
import board.BoardFactory;
import board.Game;
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
		Game game = new Game(pcs, 2);
		Board b = BoardFactory.generateBoard(context.d, r, game);
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
	
	@When("a name is set")
	public void a_name_is_set() {
		context.board.setName(null);
	}
	@Then("the board has its name set")
	public void the_board_has_its_name_set() {
		assertEquals(context.board.getName(), null);
	}

	@Then("no board is generated")
	public void no_board_is_generated() {
		assertEquals(context.board, null);
	}
	

//	@Given("a board with X rows")
//	public void a_board_with_x_rows() {
//		context.board.getNumRows();
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//	@Given("a board with Y column")
//	public void a_board_with_y_column() {
//		context.board.getNumColumns();
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//	@Then("the board of X rows and Y columns is generated")
//	public void the_board_of_x_rows_and_y_columns_is_generated() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
}
