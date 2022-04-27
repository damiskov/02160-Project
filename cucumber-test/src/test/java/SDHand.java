import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDHand {

	private Context context;
	
	public SDHand (Context context) {
		this.context = context;
	}

//	@Then("a hand is created")
//	public void a_hand_is_created() {
//	    assertEquals(context.player.getHand().getCardList().size(), 9);
//	}
	
	@Then("the player has a hand")
	public void the_player_has_a_hand() {
		assertEquals(context.player.getHand().getCardList().size(), 9);
	}
	
	
}

