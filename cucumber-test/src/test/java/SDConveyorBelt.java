

import static org.junit.Assert.assertEquals;

import board.Board;
import board.IBoard;
import environment_elements.ConveyorBelt;
import environment_elements.Wall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import piece_basics.Robot;

public class SDConveyorBelt {
	private Context context;
	
	public SDConveyorBelt(Context context) {
		this.context = context;
	}
	
	@Given("a conveyor belt on the board at \\({int}, {int}) facing {string}")
	public void a_conveyor_belt_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    ConveyorBelt c = null;
	    switch (string.toLowerCase()) {
	    case "up":
	    	c = new ConveyorBelt(Orientation.UP); break;
	    case "right":
	    	c = new ConveyorBelt(Orientation.RIGHT); break;
	    case "down":
	    	c = new ConveyorBelt(Orientation.DOWN); break;
	    case "left":
	    	c = new ConveyorBelt(Orientation.LEFT); break;
	    default:
	    	throw new IllegalArgumentException("Invalid orientation");
	    }
    	context.board.initialPlacement(c, int1, int2);
    	context.conveyorBelt = c;
	}
	
	@Given("an upwards-pointing conveyor belt on the board")
	public void an_upwards_pointing_conveyor_belt_on_the_board() {
	    Board board = context.board;
	    ConveyorBelt c = new ConveyorBelt( Orientation.UP);
	    context.conveyorBelt = c;
	    board.initialPlacement(c, 6, 5);
	    
	}
	@When("the robot moves into the conveyor belt during a register")
	public void the_robot_moves_into_the_conveyor_belt_during_a_register() {
	    context.robot.shiftX(1);
	}
	@Then("the robot is pushed upwards at the end of the register")
	public void the_robot_is_pushed_upwards_at_the_end_of_the_register() {
	    context.conveyorBelt.performRegisterAction();
	    assertEquals(6, context.robot.getY());
	}
	
	@Given("a downwards-pointing conveyor belt on the board")
	public void a_downwards_pointing_conveyor_belt_on_the_board() {
		Board board = context.board;
	    ConveyorBelt c = new ConveyorBelt( Orientation.DOWN);
	    board.initialPlacement(c, 6, 5);
	    context.conveyorBelt = c;
	}
	@Then("the robot is pushed downwards at the end of the register")
	public void the_robot_is_pushed_downwards_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
	    assertEquals(4, context.robot.getY());
	}
	
	@Given("a right-pointing conveyor belt on the board")
	public void a_right_pointing_conveyor_belt_on_the_board() {
		Board board = context.board;
	    ConveyorBelt c = new ConveyorBelt( Orientation.RIGHT);
	    board.initialPlacement(c, 6, 5);
	    context.conveyorBelt = c;
	}
	@Then("the robot is pushed right at the end of the register")
	public void the_robot_is_pushed_right_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
	    assertEquals(7, context.robot.getX());
	}
	
	@Given("a left-pointing conveyor belt on the board")
	public void a_left_pointing_conveyor_belt_on_the_board() {
		Board board = context.board;
	    ConveyorBelt c = new ConveyorBelt(Orientation.LEFT);
	    board.initialPlacement(c, 6, 5);
	    context.conveyorBelt = c;
	}
	@Then("the robot is pushed left at the end of the register")
	public void the_robot_is_pushed_left_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
	    assertEquals(5, context.robot.getX());
	}
	
	@Given("a robot blocking the way of the conveyor belt")
	public void a_robot_blocking_the_way_of_the_conveyor_belt() {
	    context.board.initialPlacement(new Robot(), 7, 5);
	}
	@Then("the robot stays on the conveyor belt at the end of the register")
	public void the_robot_stays_on_the_conveyor_belt_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
		assertEquals(6, context.robot.getX());
	}
	
	@Given("a wall blocking the way of the conveyor belt")
	public void a_wall_blocking_the_way_of_the_conveyor_belt() {
	    context.board.initialPlacement(new Wall(), 7, 5);
	}
}
