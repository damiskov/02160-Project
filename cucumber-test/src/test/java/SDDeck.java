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
	@When("a deck generate a list of nine random cards for a player")
	public void a_deck_generate_a_list_of_nine_random_cards_for_a_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a player receives a hand")
	public void a_player_receives_a_hand() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}

