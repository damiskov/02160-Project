import environment_elements.Fire;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDFire {

	//Change the "Then" and complete steps
	
	private Context context;
	
	public SDFire(Context context) {
		this.context = context;		
	}
	
	@Given("a fire")
	public void a_fire() {
		Fire f = new Fire(6, 5);
		context.board.place(f);
	    context.fire = f;
	}
	@When("the robot steps into the fire")
	public void the_robot_steps_into_the_fire() {
		context.robot.shiftX(1);
		context.fire.performRegisterAction();
	}
	
	@Then("the robot loses life points")

	//Turns have not been implemented yet
	@When("a turn passes")
	public void a_turn_passes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the fire spreads to a random adjacent cell")
	public void the_fire_spreads_to_a_random_adjacent_cell() {
	    context.fire.spread();
	}
	
}
