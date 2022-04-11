import io.cucumber.java.en.*;
import piece_basics.Orientation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import board.Position;
import cards.*;
import player.*;

public class SDCard {
	private Context context;
	private Card card;
	
	
	
	
	public SDCard(Context context) {
		this.context = context;
		
	}

	// scenario - accept the programming cards
	// @Given("a player")
	
	
	@Given("a Deck")
	public void a_Deck() {
	    this.context.deck = new Deck();
	}
	
	@When("a Hand is created")
	public void a_Hand_is_created() {
		Hand hand = context.deck.genHand();
		context.hand = hand;
	    
	}
	
	@Then("the player accepts nine cards")
	public void the_player_accepts_nine_cards() {
	    context.player.setHand(context.hand);
	}
	
	
	// scenario - Programming the cards
	
	// @Given("a player")
	// public void a_player()

	@And("a non empty program")
	public void a_non_empty_program() {
		this.context.program = new Program();
		ArrayList<Card> cardlst = new ArrayList<> (Arrays.asList(new Card("move1")));
		this.context.program.setProgram(cardlst);
		context.player.setProgram(context.program);
	}

	@When("a card is taken from the front of the program")
	public void a_card_is_taken_from_the_fron_of_the_program() {
	    this.card = context.player.getTopCardInProgram();
	    
	}
	@Then("the robot executes the action on the card")
	public void the_robot_executes_the_action_on_the_card() {
	    card.executeAction(context.player.getRobot());
	}
	
	
	//scenario - Move the robot one step in the direction it is facing
	
	@Given("a one step card")
	public void a_one_step_card() {
	    
	}
	// @Given("a robot on the board")

	// @When("the card is executed")

	@Then("the robot moves one step in its direction")
	public void the_robot_moves_one_step_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@Given("a two steps card")
	public void a_two_steps_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")

	// @When("the card is executed")

	@Then("the robot moves two steps in its direction")
	public void the_robot_moves_two_steps_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	
	@Given("three steps card")
	public void three_steps_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")

	// @When("the card is executed")

	@Then("the robot moves three steps in its direction")
	public void the_robot_moves_three_steps_in_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	

	@Given("Right Direction card")
	public void right_direction_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")

	// @When("the card is executed")
	
	@Then("the robot moves ninety degrees to the right")
	public void the_robot_moves_ninety_degrees_to_the_right() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	@Given("Left Direction card")
	public void left_direction_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")
	
	// @When("the card is executed")
	
	@Then("the robot moves ninety degrees to the left")
	public void the_robot_moves_ninety_degrees_to_the_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	@Given("U-turn card")
	public void u_turn_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")
	
	// @When("the card is executed")
	
	@Then("the robot moves one hundred eighty degrees so it faces opposite direction")
	public void the_robot_moves_one_hundred_eighty_degrees_so_it_faces_opposite_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	
	
	@Given("Backup card")
	public void backup_card() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	// @Given("a robot on the board")

	@When("the card is executed")
	public void the_card_is_executed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot moves one space back without changing its direction")
	public void the_robot_moves_one_space_back_without_changing_its_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
//	ROBOT MOVEMENT
	
	//RIGHT AND LEFT
	
	@When("a turn right command is executed")
	public void a_turn_right_command_is_executed() {
		Card r_card = new TurnRight();
		context.card = r_card;
		context.card.executeAction(context.robot);
	}
	
	@When("a turn left command is executed")
	public void a_turn_left_command_is_executed() {
		Card l_card = new TurnLeft();
		context.card = l_card;
		context.card.executeAction(context.robot);
	}
	
	@Then("the robot is at \\({int}, {int}) facing {string}")
	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
		assertEquals(new Position(int1, int2), context.robot.getPosition());
		
		if (string == "up") {
			assertEquals(Orientation.UP, context.robot.getOrientation());
		} else if (string == "down") {
			assertEquals(Orientation.DOWN, context.robot.getOrientation());
		} else if (string == "right") {
			assertEquals(Orientation.RIGHT, context.robot.getOrientation());
		} else if (string == "left") {
			assertEquals(Orientation.LEFT, context.robot.getOrientation());
		}
		
	}
	
	
	
	
//@When("a turn right command is executed")

//@Then("the robot is at \\({int}, {int}) facing {string}")



	
	
	

//@When("a turn right command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	
	

//@When("a turn right command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	
	

//@When("a turn right command is executed")
	
//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	

//@When("a turn left command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	

//@When("a turn left command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	

//@When("a turn left command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	

//@When("a turn left command is executed")

//	@Then("the robot is at \\({int}, {int}) facing {string}")
//	public void the_robot_is_at_facing(Integer int1, Integer int2, String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}


	
	//FORWARD AND BACKWARD
	
	@When("a move forward command is executed")
	public void a_move_forward_command_is_executed() {
		Card f_card = new Move1();
		context.card = f_card;
		context.card.executeAction(context.robot);
	}
	
	@When("a move backward command is executed")
	public void a_move_backward_command_is_executed() {
		Card b_card = new BackUp();
		context.card = b_card;
		context.card.executeAction(context.robot);
	}
	

	@When("a move forward {int} command is executed")
	public void a_move_forward_command_is_executed(Integer int1) {
		
		Card f_card = new Card("move1");
		
		if (int1 == 2) {
			f_card = new Move2();
		} else if(int1 == 3) {
			f_card = new Move3();
		}
		
		context.card = f_card;
		context.card.executeAction(context.robot);
	}


}
