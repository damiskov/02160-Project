import io.cucumber.java.en.*;
import cards.*;
import player.*;

public class SDCard {
	private Context context;
	private Card card;
	
	
	public SDCard(Context context) {
		this.context = context;
	}

	// @Given("a player")
	
	
	@Given("a Deck")
	public void a_Deck() {
		Deck deck = context.deck;
	    
	}
	
	@When("a Hand is created")
	public void a_Hand_is_created() {
		Hand hand = context.deck.genHand();
	    
	}
	
	@Then("the player accepts nine cards")
	public void the_player_accepts_nine_cards() {
	    context.player.setHand(context.deck.genHand());
	}
	
	
	
	
	// @Given("a player")
	// public void a_player()

	// @Given("a Hand")
	public void a_Hand() {
		Deck deck = context.deck;
		Hand hand = deck.genHand();
		context.player.setHand(hand);
	}

	@When("the player creates a program")
	public void the_player_creates_a_program() {
	    context.player.setProgram();
	}
	@When("a card is taken from the front of the program")
	public void a_card_is_taken_from_the_fron_of_the_program() {
	    this.card = context.player.getTopCardInProgram();
	    
	}
	@Then("the robot executes the action on the card")
	public void the_robot_executes_the_action_on_the_card() {
	    card.executeAction(context.player.getRobot());
	}
	
	
	
	
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




}
