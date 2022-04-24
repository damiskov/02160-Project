import static org.junit.Assert.assertEquals;

import cards.Deck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDDeck {
	
	private Context context;
	
	public SDDeck(Context context) {
		this.context = context;
	}
	
	@Given("a deck")
	public void a_deck() {
		Deck d = new Deck();
	    context.deck = d;
	}

	@Then("the hand is removed from the deck")
	public void the_hand_is_removed_from_the_deck() {
	    assertEquals(context.deck.getDeck().size(), 151);
	}
}

