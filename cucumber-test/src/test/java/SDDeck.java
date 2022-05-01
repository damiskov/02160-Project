import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cards.Deck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
	@Given("a deck for the game")
	public void a_deck_for_the_game() {
		Deck d = new Deck();
	    context.deck = d;
	    context.game.setDeck(context.deck);
	}
	
	@When("we try to add a {string} card to the deck")
	public void we_try_to_add_a_card_to_the_deck(String string) {
	    context.deck.addToDeck(string, 1);
	}
	
	@Then("the {string} card is not added")
	public void the_card_is_not_added(String string) {
		assertTrue(!(context.deck.getCards().contains(string)));
	}
}

