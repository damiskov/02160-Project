import static org.junit.Assert.assertEquals;

import board.Board;
import board.Position;
import environment_elements.RespawnPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDRespawnPoint {
	private Context context;

	public SDRespawnPoint(Context context) {
		this.context = context;
	}
	
	@Given("a respawn point on the board at \\({int}, {int})")
	public void a_respawn_point_on_the_board_at(Integer int1, Integer int2) {
	    RespawnPoint rp = new RespawnPoint();
	    context.board.initialPlacement(rp, int1, int2);
	    context.respawnPoint = rp;
	}
	
	@Given("the robot having its respawn point set")
	public void the_robot_having_its_respawn_point_set() {
	    context.robot.setRespawnPoint(context.respawnPoint);
	}

	@Then("the robot is back at max health")
	public void the_robot_is_back_at_max_health() {
		Robot robot = context.robot;
		assertEquals(robot.getHealth(), robot.getMaxHealth());
	}
}
