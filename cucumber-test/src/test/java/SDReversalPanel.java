import environment_elements.ReversalPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDReversalPanel {
	
	//Complete steps
	private Context context;
	
	public SDReversalPanel(Context context) {
		this.context = context;		
	}
	
	@Given("reversal panel")
	public void reversal_panel() {
	    ReversalPanel rp = new ReversalPanel(6, 5);
	    context.board.place(rp);
	    context.revpan = rp;
	}
	
	@Given("some remaining moves for the robots")
	public void some_remaining_moves_for_the_robots() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the robot steps into the reversal panel")
	public void the_robot_steps_into_the_reversal_panel() {
		context.robot.shiftX(1);
	}
	
	@Then("the remaining moves get reversed")
	public void the_remaining_moves_get_reversed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
