import static org.junit.Assert.assertEquals;

import board.Board;
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
	
	@Given("a respawn point on the board")
	public void a_respawn_point_on_the_board() {
	    Board board = context.board;
	    RespawnPoint r = new RespawnPoint(board, 1, 1);
	    board.placeEElement(r);
	    context.respawnPoint = r;
	}
	@Given("the robot having its respawn point set")
	public void the_robot_having_its_respawn_point_set() {
	    context.robot.setRespawnPoint(context.respawnPoint);
	}
	@Then("the robot respawns at its respawn point")
	public void the_robot_respawns_at_its_respawn_point() {
		Robot robot = context.robot;
		RespawnPoint resp = context.respawnPoint;
	    assertEquals(resp.getX(), robot.getX());
	    assertEquals(resp.getY(), robot.getY());
	}
	@Then("the robot is back at max health")
	public void the_robot_is_back_at_max_health() {
		Robot robot = context.robot;
		assertEquals(robot.getHealth(), robot.getMaxHealth());
	}
	
	@When("the robot is on the respawn point at the end of a register")
	public void the_robot_is_on_the_respawn_point_at_the_end_of_a_register() {
		RespawnPoint resp = context.respawnPoint;
	    context.robot.setPosition(resp.getX(), resp.getY());
	    resp.performRegisterAction();
	}
	@When("the robot moves away from the respawn point")
	public void the_robot_moves_away_from_the_respawn_point() {
	    context.robot.shiftY(4);
	}
}
