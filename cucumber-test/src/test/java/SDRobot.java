import static org.junit.Assert.assertEquals;

import board.Board;
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

	@Given("a robot on the board")
	public void a_robot_on_the_board() {
	    Robot r = new Robot(5, 5);
	    context.board.place(r);
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
	    Robot r2 = new Robot(5, 9);
	    context.board.place(r2);
	    context.robot2 = r2;
	}
	@Given("a second robot below the first")
	public void a_second_robot_below_the_first() {
	    Robot r2 = new Robot(5, 1);
	    context.board.place(r2);
	    context.robot2 = r2;
	}
	@Given("a second robot to the right of the first")
	public void a_second_robot_to_the_right_of_the_first() {
	    Robot r2 = new Robot(9, 5);
	    context.board.place(r2);
	    context.robot2 = r2;
	}
	@Given("a second robot to the left of the first")
	public void a_second_robot_to_the_left_of_the_first() {
		Board board = context.board;
	    Robot r2 = new Robot(1, 5);
	    board.place(r2);
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
		Wall w = new Wall((r.getX() + r2.getX())/2, (r.getY() + r2.getY())/2);
		context.board.place(w);
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
