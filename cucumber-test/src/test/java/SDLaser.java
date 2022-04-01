import static org.junit.Assert.assertEquals;
import board.Board;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import environment_elements.Laser;

public class SDLaser {

	//change the first "Then" 
	private Context context;
	
	public SDLaser(Context context) {
		this.context = context;		
	}
	
	@Given("a laser")
	public void a_laser() {
		Board board = context.board;
<<<<<<< HEAD
		Laser l = new Laser(6, 5);
		context.board.place(l);
=======
		Laser l = new Laser();
		board.initialPlacement(l, 6, 5);
>>>>>>> refs/heads/main
	    context.laser = l;
	}
	@When("the robot steps into the laser")
	public void the_robot_steps_into_the_laser() {
		context.robot.shiftX(1);
	}
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
//		context.laser.activate(context.robot);
	}
	@Then("the robot lost life points")
	public void the_robot_lost_life_points() {
		assertEquals(context.robot.getHealth(),2);
	}
}

