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
	
	@Given("a sending teleporter on the board at \\({int}, {int})")
	public void a_sending_teleporter_on_the_board_at(Integer int1, Integer int2) {
		Teleporter sed = new Teleporter();
		sed.setSending(true);
		context.board.initialPlacement(sed, int1, int2); 
	    context.sending = sed; 
	}
	
	@Given("a linked receiving teleporter on the board at \\({int}, {int})")
	public void a_linked_receiving_teleporter_on_the_board_at(Integer int1, Integer int2) {
		Teleporter rec = new Teleporter();
		rec.setSending(false);
		context.board.initialPlacement(rec, int1, int2);
	    context.receiving = rec;
	    context.sending.setReceiving(context.receiving);
	}
	
	@Then("the robot gets teleported to the other teleporter")
	public void the_robot_gets_teleported_to_the_other_teleporter() {
		assertEquals(context.board.calculatePosition(context.robot),context.board.calculatePosition(context.receiving));

	}
	
}
