import static org.junit.Assert.assertEquals;

import board.Board;
import environment_elements.HealthStation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDHealthStation {
	private Context context;
	
	public SDHealthStation(Context context) {
		this.context = context;
	}
	
	@Given("a health station on the board at \\({int}, {int})")
	public void a_health_station_on_the_board_at(Integer int1, Integer int2) {
	    HealthStation hs = new HealthStation();
	    context.board.initialPlacement(hs, int1, int2);
	    context.healthStation = hs;
	}
	
	@Given("the robot does not have full health")
	public void the_robot_does_not_have_full_health() {
	    context.robot.takeDamage();
	    context.robot.takeDamage();
	}
	@Then("the robot gains one HP")
	public void the_robot_gains_one_hp() {
	    Robot r = context.robot;
		int oldHealth = r.getHealth();
		context.healthStation.performRegisterAction();
		assertEquals(oldHealth + 1, r.getHealth());
	}
	
	@Given("the robot has full health")
	public void the_robot_has_full_health() {}
	
	@Then("the robot remains at full health")
	public void the_robot_remains_at_full_health() {
		Robot r = context.robot;
		int oldHealth = r.getHealth();
		context.healthStation.performRegisterAction();
		assertEquals(oldHealth, r.getHealth());
	}
}
