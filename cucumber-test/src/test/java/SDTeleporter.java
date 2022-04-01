import static org.junit.Assert.assertEquals;
import environment_elements.Teleporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SDTeleporter {
	//Adjust the "Then"
	private Context context;
	
	public SDTeleporter(Context context) {
		this.context = context;
	}

	@Given("a sending teleporter")
	public void a_sending_teleporter() {
		Teleporter sed = new Teleporter();
		context.board.initialPlacement(sed, 5,5);
	    context.sending = sed;
	}

	@Given("a receiving teleporter")
	public void a_receiving_teleporter() {
		Teleporter rec = new Teleporter();
		context.board.initialPlacement(rec, 10, 5);
	    context.receiving = rec;
	}
	@When("the robot steps into the sending teleporter")
	public void the_robot_steps_into_the_sending_teleporter() {
		context.robot.shiftX(1);
	}
	@Then("the robot get teleported to the receiving teleporter")
	public void the_robot_get_teleported_to_the_receiving_teleporter() {
//		context.sending.activate(context.robot, context.receiving);
	}
	
	@Then("the robot got teleported to the receiving teleporter")
	public void the_robot_got_teleported_to_the_receiving_teleporter() {
		assertEquals(context.robot.getX(),context.receiving.getX());
		assertEquals(context.robot.getY(),context.receiving.getY());
	}	
}
