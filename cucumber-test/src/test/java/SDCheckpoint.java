import static org.junit.jupiter.api.Assertions.assertEquals;

import environment_elements.Checkpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDCheckpoint {

	private Context context;
	
	public SDCheckpoint(Context context) {
		this.context = context;
	}
	
	@Given("checkpoint number {int} on the board at \\({int}, {int})")
	public void checkpoint_number_on_the_board_at(Integer int1, Integer int2, Integer int3) {
	    Checkpoint c = new Checkpoint(int1);
	    context.board.initialPlacement(c, int2, int3);
	    context.checkpoint = c;
	}
	
	@Then("the robot has checkpoint {int} as its most recent checkpoint")
	public void the_robot_has_checkpoint_as_its_most_recent_checkpoint(Integer int1) {
	    assertEquals(int1, context.robot.getMostRecentCheckpoint());
	}
}
