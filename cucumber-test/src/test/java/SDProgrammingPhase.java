import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import cards.Card;
import cards.Move2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDProgrammingPhase {
	
	private Context context;
	
	public SDProgrammingPhase(Context context) {
		this.context = context;
	}

	@Given("a robot for the player")
	public void a_robot_for_the_player() {
		Robot r = new Robot();
	    context.robot = r;
	    context.player.setRobot(context.robot);
	}
	@When("the cards are dealt")
	public void the_cards_are_dealt() {
	    context.player.setHand(context.deck.genHand());
	}
	@When("the player chooses the cards for their robot")
	public void the_player_chooses_the_cards_for_their_robot() {
		ArrayList<Card> g = new ArrayList<Card>();
		context.gram = g;
		Random rand = new Random();
		for(int i = 0; i <= 5; i++) {
		    Card randomCard = context.player.getHand().getCardList().get(rand.nextInt(context.player.getHand().getCardList().size()));
		    context.gram.add(randomCard);
		    context.player.getHand().getCardList().remove(randomCard); //avoids getting the same card multiple times
		}
		context.player.setProgram(context.gram); 
	}
	@Then("the robot is assigned the program that the player chose")
	public void the_robot_is_assigned_the_program_that_the_player_chose() {
		assertEquals(context.robot.getProgram().getCardList(), context.gram);
	}

}
