import board.Board;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDRobot {
	private Context context;
	
	public SDRobot(Context context) {
		this.context = context;
	}

	@Given("a robot on the board")
	public void a_robot_on_the_board() {
		Board board = context.board;
	    Robot r = new Robot(5, 5);
	    board.place(r);
	    context.robot = r;
	}
	@When("the robot takes enough damage to kill it")
	public void the_robot_takes_enough_damage_to_kill_it() {
	    for (int i = 0; i < 3; i++) {
	    	context.robot.takeDamage();
	    }
	}

}
