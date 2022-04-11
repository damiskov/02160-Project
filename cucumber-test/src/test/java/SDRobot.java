import static org.junit.Assert.assertEquals;

import board.Board;
import board.Position;
import environment_elements.Wall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import piece_basics.Robot;

public class SDRobot {
	private Context context;
	
	public SDRobot(Context context) {
		this.context = context;
	}
	
	@Given("a robot on the board at \\({int}, {int})")
	public void a_robot_on_the_board_at(Integer int1, Integer int2) {
		Robot r = new Robot();
		context.board.initialPlacement(r, int1, int2);
	    context.robot = r;
	}
	
	@Given("a second robot on the board at \\({int}, {int})")
	public void a_second_robot_on_the_board_at(Integer int1, Integer int2) {
		Robot r = new Robot();
		context.board.initialPlacement(r, int1, int2);
	    context.robot2 = r;
	}
	
	@Given("a program for the robot")
	public void a_program_for_the_robot() {
		//define this
	}

	@Given("a robot on the board at \\({int}, {int}) facing {string}")
	public void a_robot_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    Robot r = new Robot();
	    switch (string.toLowerCase()) {
	    case "up":
	    	r.setOrientation(Orientation.UP); break;
	    case "right":
	    	r.setOrientation(Orientation.RIGHT); break;
	    case "down":
	    	r.setOrientation(Orientation.DOWN); break;
	    case "left":
	    	r.setOrientation(Orientation.LEFT); break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    context.board.initialPlacement(r, int1, int2);
	    context.robot = r;
	}
	
	@When("the robot moves to \\({int}, {int})")
	public void the_robot_moves_to(Integer int1, Integer int2) {
	    context.board.setPosition(context.robot, new Position(int1, int2));
	}
	
	@Then("the robot is at \\({int}, {int})")
	public void the_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot.getPosition());
	}
	
	@Then("the first robot is at \\({int}, {int})")
	public void the_first_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot.getPosition());
	}
	
	@Then("the second robot is at \\({int}, {int})")
	public void the_second_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot2.getPosition());
	}
	
	@When("one robot moves")
	public void one_robot_moves() {
	    context.robot.move(1);
	}
	
	@When("one robot reboots")
	public void one_robot_reboots() {
	    context.robot.reboot();
	}
	
	@Then("the robot is at \\({int}, {int}) and facing {string}")
	public void the_robot_is_at_and_facing(Integer int1, Integer int2, String string) {
	    assertEquals(new Position(int1, int2), context.robot.getPosition());
	    Orientation o = null;
	    switch (string.toLowerCase()) {
	    case "up":
	    	o = Orientation.UP; break;
	    case "right":
	    	o = Orientation.RIGHT; break;
	    case "down":
	    	o = Orientation.DOWN; break;
	    case "left":
	    	o = Orientation.LEFT; break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    assertEquals(o, context.robot.getOrientation());
	}
	
	@Given("a robot on the board")
	public void a_robot_on_the_board() {
	    Robot r = new Robot();
	    context.board.initialPlacement(r, 5, 5);
	    context.robot = r;
	}
	@When("the robot takes enough damage to kill it")
	public void the_robot_takes_enough_damage_to_kill_it() {
	    for (int i = 0; i < 3; i++) {
	    	context.robot.takeDamage();
	    }
	}
	
	@Then("the second robot stays at \\({int}, {int})")
	public void the_second_robot_stays_at(Integer int1, Integer int2) {
	    assertEquals(context.robot2.getPosition(), new Position(int1, int2));
	}
	
	@Then("the second robot reboots")
	public void the_second_robot_reboots() {
	    context.robot2.reboot();
	}
	
	@Then("the second robot takes damage")
	public void the_second_robot_takes_damage() {
	    assertEquals(2, context.robot2.getHealth());
	}
	@Then("the second robot does not take damage")
	public void the_second_robot_does_not_take_damage() {
		assertEquals(3, context.robot2.getHealth());
	}

}
