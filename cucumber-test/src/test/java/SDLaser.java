import static org.junit.Assert.assertEquals;
import board.Board;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import environment_elements.Laser;

public class SDLaser {
	
	private Context context;

	public SDLaser(Context context) {
		this.context = context;
	}
	
	@Given("a laser on the board at \\({int}, {int})")
	public void a_laser_on_the_board(Integer int1, Integer int2) {
		Laser l = new Laser();
		context.board.initialPlacement(l, int1, int2);
	    context.laser = l;
	}
	
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
		assertEquals(context.robot.getHealth(),2);
	}
}