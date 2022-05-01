import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;

public class SDHand {

	private Context context;
	
	public SDHand (Context context) {
		this.context = context;
	}
	
	@Then("the player has a hand")
	public void the_player_has_a_hand() {
		assertEquals(context.player.getHand().getCardList().size(), 9);
	}

}

