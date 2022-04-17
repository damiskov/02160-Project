import static org.junit.Assert.assertEquals;

import board.Board;
import board.IBoard;
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
	
	@Given("a gear on the board at \\({int}, {int}) spinning {string}")
	public void a_gear_on_the_board_at_spinning(Integer int1, Integer int2, String string) {
	    Gear g = null;
	    switch (string.toLowerCase()) {
	    case "clockwise": 
	    	g = new Gear(false); break;
	    case "counterclockwise": 
	    	g = new Gear(true); break;
    	default:
    		throw new IllegalArgumentException("Invalid direction");
	    }
	    context.board.initialPlacement(g, int1, int2);
	    context.gear = g;
	}
	
//	@Given("a gear pointing towards right")
//	public void a_gear_pointing_towards_right() {
//		Board board = context.board;
//		Gear g = new Gear( false);
//		context.gear = g;
//		board.initialPlacement(g, 6, 5);
//	}
//	
//	@When("robot steps on a gear")
//	public void robot_steps_on_a_gear() {
//		context.robot.shiftX(1);
//	}
//	
//	@Then("gear turns the robot towards right")
//	public void gear_turns_the_robot_towards_right() {
//		context.gear.performRegisterAction();
//		assertEquals(Orientation.RIGHT, context.robot.getOrientation());
//		
//	}
//	
//	@Given("a gear pointing towards left")
//	public void a_gear_pointing_towards_left() {
//		Board board = context.board;
//		Gear g = new Gear(true);
//		context.gear = g;
//		board.initialPlacement(g, 6, 5);
//	}
//	@Then("gear turns the robot towards left")
//	public void gear_turns_the_robot_towards_left() {
//		context.gear.performRegisterAction();
//	    assertEquals(Orientation.LEFT,context.robot.getOrientation());
//	}

}
