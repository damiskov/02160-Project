

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
	
	@Given("an upwards-pointing conveyor belt on the board")
	public void an_upwards_pointing_conveyor_belt_on_the_board() {
	    Board board = context.board;
	    ConveyorBelt c = new ConveyorBelt(board, 6, 5, Orientation.UP);
	    board.placeEElement(c);
	    context.conveyorBelt = c;
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
	    ConveyorBelt c = new ConveyorBelt(board, 6, 5, Orientation.DOWN);
	    board.placeEElement(c);
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
	    ConveyorBelt c = new ConveyorBelt(board, 6, 5, Orientation.RIGHT);
	    board.placeEElement(c);
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
	    ConveyorBelt c = new ConveyorBelt(board, 6, 5, Orientation.LEFT);
	    board.placeEElement(c);
	    context.conveyorBelt = c;
	}
	@Then("the robot is pushed left at the end of the register")
	public void the_robot_is_pushed_left_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
	    assertEquals(5, context.robot.getX());
	}
	
	@Given("a robot blocking the way of the conveyor belt")
	public void a_robot_blocking_the_way_of_the_conveyor_belt() {
	    context.board.placeRobot(new Robot(context.board, 7, 5));
	}
	@Then("the robot stays on the conveyor belt at the end of the register")
	public void the_robot_stays_on_the_conveyor_belt_at_the_end_of_the_register() {
		context.conveyorBelt.performRegisterAction();
		assertEquals(6, context.robot.getX());
	}
	
	@Given("a wall blocking the way of the conveyor belt")
	public void a_wall_blocking_the_way_of_the_conveyor_belt() {
	    context.board.placeEElement(new Wall(context.board, 7, 5));
	}
}
