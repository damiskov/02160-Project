import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDProgram {
	
	private Context context;
	public SDProgram(Context context) {
		this.context = context;
		
	}
	
	@When("the first card is executed")
	public void the_first_card_is_executed() {
		context.robot.getProgram().getTopOfProgram();
	    
	}
	@Then("the top card is removed")
	public void the_top_card_is_removed() {
		assertEquals(context.robot.getProgram().getCardList().size(), 4);
	    
	}

}
