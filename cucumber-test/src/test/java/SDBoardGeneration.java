import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import board.Board;
import board.BoardFactory;
import board.Game;
import board.PieceNotFoundException;
import environment_elements.ReversalPanel;
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
		BoardFactory bf = new BoardFactory();
		Board b = bf.generateBoard(context.d, r, game);
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
	
	@Then("the board has {int} rows and {int} columns")
	public void the_board_has_rows_and_columns(Integer int1, Integer int2) {
	    assertEquals(context.board.getNumRows(), context.board.getNumColumns());
	}
		
	@Then("the board has a game")
	public void the_board_has_a_game() {
		assertTrue(!(context.board.getGame() == null));
	}
	
	@When("a position is calculated for an obstacle")
	public void a_position_is_calculated_for_an_obstacle() {
	}
				
	@Then("it throws an exception error")
	public void it_throws_an_exception_error() {
		assertThrowsExactly(PieceNotFoundException.class, () -> context.board.calculatePosition(new ReversalPanel()));
	}
	
	@When("a position is calculated for a robot")
	public void a_position_is_calculated_for_a_robot() {
	}
		
	@Then("it throws an exception error if robot not found")
	public void it_throws_an_exception_error_if_robot_not_found() {
		assertThrowsExactly(PieceNotFoundException.class, () -> context.board.calculatePosition(new Robot()));
	}
}
