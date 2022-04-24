import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDHand {

	private Context context;
	
	public SDHand (Context context) {
		this.context = context;
	}

	@Then("a hand is created")
	public void a_hand_is_created() {
	    assertEquals(context.player.getHand().getCardList().size(), 9);
	}
}

