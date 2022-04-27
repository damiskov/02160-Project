import io.cucumber.java.en.*;
import piece_basics.Orientation;
import piece_basics.Robot;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Stack;

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
	
	@Given("a player with a robot")
	public void a_player_with_a_robot()
	{
		this.context.player = new Player();
		this.context.robot = new Robot();
		context.player.setRobot(context.robot);
	}


	@And("a non empty program")
	public void a_non_empty_program() {
		this.context.program = new Program();
		Stack<Card> cardlst = new Stack<Card>();
		cardlst.addAll(Arrays.asList(new Card("move1")));
		context.player.setProgram(cardlst);
		context.program = context.player.getProgram();
	}

	@When("a card is taken from the front of the program")
	public void a_card_is_taken_from_the_front_of_the_program() {
		context.card = context.program.getTopOfProgram();
	    
	    
	}
	@Then("the robot executes the action on the card")
	public void the_robot_executes_the_action_on_the_card() {
	    context.card.executeAction(context.player.getRobot());
	}
	
	
	//scenario - Move the robot one step in the direction it is facing
	
	@Given("a Move1 card")
	public void a_Move1_card() {
		context.card = new Move1();
    
	}

	@When("the card is executed")
	public void the_card_is_executed() {
		context.card.executeAction(context.robot);
		
	
	}

	@Then("the robot moves one step in its direction")
	public void the_robot_moves_one_step_in_its_direction() {
	    assertEquals(context.board.calculatePosition(context.robot), new Position(5,6));
	}

	//scenario - Move the robot two steps in the direction it is facing
	
	@Given("a Move2 card")
	public void a_Move2_card() {
		context.card = new Move2();
    
	}

	@Then("the robot moves two steps in its direction")
	public void the_robot_moves_two_steps_in_its_direction() {
	    assertEquals(context.board.calculatePosition(context.robot), new Position(5,7));
	}

	
	//scenario - Move the robot three steps in the direction it is facing
	
	@Given("a Move3 card")
	public void a_Move3_card() {
		context.card = new Move3();
    
	}

	@Then("the robot moves three steps in its direction")
	public void the_robot_moves_three_steps_in_its_direction() {
	    assertEquals(context.board.calculatePosition(context.robot), new Position(5,8));
	}
	

	//scenario - turn robot to the right
	
	@Given("Right Direction card")
	public void right_direction_card() {
		
		context.card = new TurnRight();
	    
	}
	
	
	@Then("the robot moves ninety degrees to the right")
	public void the_robot_moves_ninety_degrees_to_the_right() {
	    assertEquals(context.robot.getOrientation(), Orientation.RIGHT);
	}
	
	
	//scenario - turn robot to the left
	
	@Given("Left turn card")
	public void left_turn_card() {
		
		context.card = new TurnLeft();
	    
	}
	
	
	@Then("the robot moves ninety degrees to the left")
	public void the_robot_moves_ninety_degrees_to_the_left() {
	    assertEquals(context.robot.getOrientation(), Orientation.LEFT);
	}
		
	
	
	
//scenario - turn robot to the right

	@Given("UTurn card")
	public void UTurn_card() {
		
		context.card = new UTurn();
	    
	}
	
	
	@Then("the robot faces opposite orientation")
	public void the_robot_faces_opposite_orientation() {
	    assertEquals(context.robot.getOrientation(), Orientation.DOWN);
	}
	

	// Backup card 
	
	
	@Given("Backup card")
	public void backup_card() {
		context.card = new BackUp();
	}
	
	@Then("the robot moves one space back without changing its direction")
	public void the_robot_moves_one_space_back_without_changing_its_direction() {
	    assertEquals(context.board.calculatePosition(context.robot), new Position(5,4));
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
		assertEquals(new Position(int1, int2), context.robot.calculatePosition());
		
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
	
	@When("a move backwards two command is executed")
	public void a_move_backwards_two_command_is_executed() {
		Card b2_card = new Back2();
		context.card = b2_card;
		context.card.executeAction(context.robot);
	}
	
	@When("a move backwards three command is executed")
	public void a_move_backwards_three_command_is_executed() {
		Card b3_card = new Back3();
		context.card = b3_card;
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

	@Given("a non-determined card")
	public void a_non_determined_card() {
	    Card c = new Card("card");
	    context.card = c;
	}
	
	@When("the card gets reversed")
	public void the_card_gets_reversed() {
	   card = context.card.getOppositeCard();
	}
	
	@Then("no card is returned")
	public void no_card_is_returned() {
	    assertEquals(card, null);
	}
	

	@When("the number of the card is set")
	public void the_number_of_the_card_is_set() {
	    context.card.setNum(43);
	}
	@Then("the card has a number")
	public void the_card_has_a_number() {
	    assertEquals(context.card.getNum(), 43);
	}
}
