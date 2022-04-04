import static org.junit.Assert.assertTrue;

import environment_elements.Fire;
import environment_elements.OilSpill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SDOilSpill{

	private Context context;
	
	public SDOilSpill(Context context) {
		this.context = context;		
	}

	@Given("an oil spill")
	public void an_oil_spill() {
		OilSpill s = new OilSpill();
		context.board.initialPlacement(s, 6, 5);
	    context.spill = s;
	}
	
	@When("the robot steps into the oil spill")
	public void the_robot_steps_into_the_oil_spill() {
		context.robot.shiftX(1);
		context.spill.performRegisterAction();
	}
	
	@Then("the oil spill ignites")
	public void the_oil_spill_ignites() {
		assertTrue(context.board.getEElementAt(context.spill.getPosition()) instanceof Fire);
	}
	
}
