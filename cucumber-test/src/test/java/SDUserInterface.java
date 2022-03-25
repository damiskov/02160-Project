
import static org.junit.Assert.assertEquals;

import UserInterface.Screen;
import board.Board;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SDUserInterface {
private Context context;
	
	public SDUserInterface(Context context) {
		this.context = context;
	}

	//Update board(User Interface)
	
	@Given("a screen")
	public void a_screen() {
	    Screen screen = context.screen;
	}
	@Given("a board array")
	public void a_board_array() {
		Board board = context.board;
	}
	@When("update board on screen")
	public void update_board_on_screen() {
	    context.screen.update(context.board);
	}
	@Then("display board on screen")
	public void display_board_on_screen() {
	   assertEquals(context.screen.output(),"[Board]");
	}


	//Update obstacles(User Interface)

	//@Given("a screen")
	
	@Given("a board on screen")
	public void a_board_on_screen() {
	    context.screen.setOutput("[Board]");
	}
	@When("update obstacles on screen")
	public void update_obstacles_on_screen() {
	    context.screen.displayObstacles();
	}
	@Then("display obstacles on screen")
	public void display_obstacles_on_screen() {
		assertEquals(context.screen.output(),"[Board][Obstacles]");
		
	}


	//Update robots(User Interface)

	//@Given("a screen")
	
	//@Given("a board on screen")
	
	@Given("obstacles on screen")
	public void obstacles_on_screen() {
		context.screen.setOutput("[Board][Obstacles]");
	}
	@When("update robots on screen")
	public void update_robots_on_screen() {
	    context.screen.displayRobots();
	}
	@Then("display robots on screen")
	public void display_robots_on_screen() {
		assertEquals(context.screen.output(),"[Board][Obstacles][Robot1][Robot2]");
	}
	@Then("display robot player markers on screen")
	public void display_robot_player_markers_on_screen() {
		context.screen.displayRobotMarkers();
	    assertEquals(context.screen.output(),"[Board][Obstacles][Robot1 P1][Robot2 P2]");
	}
	@Then("display robot health on screen")
	public void display_robot_health_on_screen() {
	    context.screen.displayRobotHealth();
	    assertEquals(context.screen.output(),"[Board][Obstacles][Robot1 P1 HP:3][Robot2 P2 HP:2]");
	}


	//Show player cards(User Interface)

	//@Given("a screen")
	
	@Given("player turn is current player")
	public void player_turn_is_current_player() {
	    context.game.setCurrentPlayer(2);
	}
	@When("show current player hand")
	public void show_current_player_hand() {
	   context.screen.showCurrPlayerHand();
	}
	@Then("display current player cards on screen")
	public void display_current_player_cards_on_screen() {
	   assertEquals(context.screen.output(),"[Player 2][Forward x1][Right x2][Left x1]");
	}


	//Show player turn(User Interface)

	//@Given("a screen")
	
	@When("show current player number")
	public void show_current_player_number() {
	    context.screen.showCurrPlayerNumber();
	}
	@Then("display current player number on screen")
	public void display_current_player_number_on_screen() {
		assertEquals(context.screen.output(),"[Player 2]");
	}
	
}
