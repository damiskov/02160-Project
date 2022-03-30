import static org.junit.Assert.assertEquals;

import board.Board;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import piece_basics.Orientation;
import piece_basics.Robot;

public class SDCards {
	
private Context context;
	
	public SDCards(Context context) {
		this.context = context;
	}
	
	//Accept the programming card(Programming Cards)
	@Given("a player")
	public void a_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("the cards")
	public void the_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the cards are dealt")
	public void the_cards_are_dealt() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the player accepts nine cards")
	public void the_player_accepts_nine_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//Programming the cards(Programming Cards)


	@When("the player chooses five cards")
	public void the_player_chooses_five_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the program is executed")
	public void the_program_is_executed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot performs some actions")
	public void the_robot_performs_some_actions() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Move the robot one step in the direction it is facing(Programming Cards)
	@Given("a one step card")
	public void a_one_step_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	//@Given("a robot on the board")
	//public void a_robot_on_the_board() {
	//	Board board = context.board;
	//}
	@When("the card is executed")
	public void the_card_is_executed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot moves one step in its direction")
	public void the_robot_moves_one_step_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//Move the robot two steps in the direction it is facing(Programming Cards)
	@Given("a two steps card")
	public void a_two_steps_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Then("the robot moves two steps in its direction")
	public void the_robot_moves_two_steps_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//Move the robot three steps in the direction it is facing(Programming Cards)
	@Given("three steps card")
	public void three_steps_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot moves three steps in its direction")
	public void the_robot_moves_three_steps_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Move the robot towards right at ninety degrees angle(Programming Cards)
	@Given("Right Direction card")
	public void right_direction_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot moves ninety degrees to the right")
	public void the_robot_moves_ninety_degrees_to_the_right() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//Move the robot towards left at ninety degrees angle(Programming Cards)
	@Given("Left Direction card")
	public void left_direction_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot moves ninety degrees to the left")
	public void the_robot_moves_ninety_degrees_to_the_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Move the robot at one hundred eighty degrees angle(Programming Cards)
	@Given("U-turn card")
	public void u_turn_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot moves one hundred eighty degrees so it faces opposite direction")
	public void the_robot_moves_one_hundred_eighty_degrees_so_it_faces_opposite_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Move the robot in the downwards direction(Programming Cards) 
	@Given("Backup card")
	public void backup_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot moves one space back without changing its direction")
	public void the_robot_moves_one_space_back_without_changing_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Energy cubes for the mat(Programming Cards) 
	@Given("Power up card")
	public void power_up_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the player takes one energy cube")
	public void the_player_takes_one_energy_cube() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the player places the energy cube on its mat")
	public void the_player_places_the_energy_cube_on_its_mat() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
