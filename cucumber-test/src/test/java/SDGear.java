import static org.junit.Assert.assertEquals;

import board.Board;
import environment_elements.Gear;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import piece_basics.Robot;

public class SDGear {
private Context context;
	
	public SDGear(Context context) {
		this.context = context;
	}
	
	
	@Given("a gear pointing towards right")
	public void a_gear_pointing_towards_right() {
		Board board = context.board;
		Gear g = new Gear( false);
		board.initialPlacement(g, 6, 5);
		context.gear = g;
	}
	
	@When("robot steps on a gear")
	public void robot_steps_on_a_gear() {
		context.robot.shiftX(1);
	}
	
	@Then("gear turns the robot towards right")
	public void gear_turns_the_robot_towards_right() {
		context.gear.performRegisterAction();
		assertEquals(Orientation.RIGHT, context.robot.getOrientation());
		
	}
	
	@Given("a gear pointing towards left")
	public void a_gear_pointing_towards_left() {
		Board board = context.board;
		Gear g = new Gear(true);
		board.initialPlacement(g, 6, 5);
		context.gear = g;
	}
	@Then("gear turns the robot towards left")
	public void gear_turns_the_robot_towards_left() {
		context.gear.performRegisterAction();
	    assertEquals(Orientation.LEFT,context.robot.getOrientation());
	}

}
