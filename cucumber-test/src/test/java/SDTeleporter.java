import static org.junit.Assert.assertEquals;
import environment_elements.Teleporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SDTeleporter {

	private Context context;
	
	public SDTeleporter(Context context) {
		this.context = context;
	}

	@Given("a teleporter on the board")
	public void a_teleporter_on_the_board() {
		Teleporter sed = new Teleporter();
		context.board.initialPlacement(sed, 5,5);
	    context.sending = sed;
	}

	@Given("another teleporter on the board")
	public void another_teleporter_on_the_board() {
		Teleporter rec = new Teleporter();
		context.board.initialPlacement(rec, 10, 5);
	    context.receiving = rec;
	    context.sending.setReceiving(context.receiving);
	}
	
	@When("the robot steps into the first teleporter")
	public void the_robot_steps_into_the_first_teleporter() {
		context.robot.shiftX(1);
		context.sending.performRegisterAction();
	}
	
	@Then("the robot gets teleported to the other teleporter")
	public void the_robot_gets_teleported_to_the_other_teleporter() {
		assertEquals(context.board.getPosition(context.robot),context.board.getPosition(context.receiving));
	}
	
}
