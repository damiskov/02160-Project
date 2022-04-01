import environment_elements.Pit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDPit {
	private Context context;

	public SDPit(Context context) {
		this.context = context;
	}
	
	@Given("a pit on the board")
	public void a_pit_on_the_board() {
	    Pit p = new Pit();
	    context.board.initialPlacement(p, 6, 5);
	    context.pit = p;
	}
	@When("the robot moves into the pit during a register")
	public void the_robot_moves_into_the_pit_during_a_register() {
	    context.robot.shiftX(1);
	}

}
