import static org.junit.Assert.assertTrue;

import environment_elements.ReversalPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDReversalPanel {
	
	private Context context;
	
	public SDReversalPanel(Context context) {
		this.context = context;		
	}
	
	@Given("reversal panel")
	public void reversal_panel() {
	    ReversalPanel rp = new ReversalPanel();
	    context.board.initialPlacement(rp, 6, 5);
	    context.revpan = rp;
	}
	@When("the robot steps into the reversal panel")
	public void the_robot_steps_into_the_reversal_panel() {
		context.robot.shiftX(1);
		context.revpan.performRegisterAction();
	}
	/*@Then("the remaining moves get reversed")
	public void the_remaining_moves_get_reversed() {
	    assertequals(context.robot.program, context.revpan.newProg);
	}*/
}
