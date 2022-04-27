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
	
	@Given("a second respawn point on the board at \\({int}, {int})")
	public void a_second_respawn_point_on_the_board_at(Integer int1, Integer int2) {
		RespawnPoint rp = new RespawnPoint();
	    context.board.initialPlacement(rp, int1, int2);
	    context.respawnPoint2 = rp;
	}
	
	@Given("the robot having its respawn point set")
	public void the_robot_having_its_respawn_point_set() {
	    context.robot.setRespawnPoint(context.respawnPoint);
	}
	
	@Given("the first robot having its respawn point set")
	public void the_first_robot_having_its_respawn_point_set() {
		context.robot.setRespawnPoint(context.respawnPoint);
	}
	
	@Given("the second robot having its respawn point set to the second respawn point")
	public void the_second_robot_having_its_respawn_point_set_to_the_second_respawn_point() {
	    context.robot2.setRespawnPoint(context.respawnPoint2);
	}
	
	@Given("the second robot having its respawn point set to the respawn point")
	public void the_second_robot_having_its_respawn_point_set_to_the_respawn_point() {
	    context.robot2.setRespawnPoint(context.respawnPoint);
	}

	@Then("the robot is back at max health")
	public void the_robot_is_back_at_max_health() {
		Robot robot = context.robot;
		assertEquals(robot.getHealth(), robot.getMaxHealth());
	}
}
