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
	
	@Then("the robot is at \\({int}, {int}) and pointing {string}")
	public void the_robot_is_at_and_pointing(Integer int1, Integer int2, String string) {
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
	
	@Given("a second robot above the first")
	public void a_second_robot_above_the_first() {
	    Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 5, 9);
	    context.robot2 = r2;
	}
	@Given("a second robot below the first")
	public void a_second_robot_below_the_first() {
	    Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 5, 1);
	    context.robot2 = r2;
	}
	@Given("a second robot to the right of the first")
	public void a_second_robot_to_the_right_of_the_first() {
	    Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 9, 5);
	    context.robot2 = r2;
	}
	@Given("a second robot to the left of the first")
	public void a_second_robot_to_the_left_of_the_first() {
		Board board = context.board;
	    Robot r2 = new Robot();
	    board.initialPlacement(r2, 1, 5);
	    context.robot2 = r2;
	}
	
	@Given("the first robot is facing up")
	public void the_first_robot_is_facing_up() {
	    context.robot.setOrientation(Orientation.UP);
	}
	@Given("the first robot is facing down")
	public void the_first_robot_is_facing_down() {
		context.robot.setOrientation(Orientation.DOWN);
	}
	@Given("the first robot is facing right")
	public void the_first_robot_is_facing_right() {
		context.robot.setOrientation(Orientation.RIGHT);
	}
	@Given("the first robot is facing left")
	public void the_first_robot_is_facing_left() {
		context.robot.setOrientation(Orientation.LEFT);
	}
	
	@When("the first robot performs its register action")
	public void the_first_robot_performs_its_register_action() {
	    context.robot.performRegisterAction();
	}
	@Given("a wall in between the robots")
	public void a_wall_in_between_the_robots() {
		Robot r = context.robot;
		Robot r2 = context.robot2;
		Wall w = new Wall();
		context.board.initialPlacement(w, (r.getX() + r2.getX())/2, (r.getY() + r2.getY())/2);
		context.wall = w;
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
