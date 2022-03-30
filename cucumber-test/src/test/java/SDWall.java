import board.Board;
import environment_elements.Wall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import static org.junit.Assert.assertEquals;

public class SDWall{
private Context context;
	
	public SDWall(Context context) {
		this.context = context;
	}
	
	//Wall stops the robot from the right side(Wall)
	
	@Given("a wall on the right side of the robot")
	public void a_wall_on_the_right_side_of_the_robot() {
		Board board = context.board;
		Wall w = new Wall(board, 6, 5);
	    board.placeEElement(w);
	    context.wall = w;
	}

	@When("robot bumps into the wall from the right side")
	public void robot_bumps_into_the_wall_from_the_right_side() {
		context.robot.shiftX(1);
	}
	@Then("wall stops the robot from the right")
	public void wall_stops_the_robot_from_the_right() {
	    
	}

	//Wall stops the robot from the left side(Wall)
	@Given("a wall on the left side of the robot")
	public void a_wall_on_the_left_side_of_the_robot() {
		Board board = context.board;
		Wall w = new Wall(board, 4, 5);
	    board.placeEElement(w);
	    context.wall = w;
	}
	
	@When("robot bumps into the wall from the left side")
	public void robot_bumps_into_the_wall_from_the_left_side() {
		context.robot.shiftX(-1);
	}

	@Then("wall stops the robot from the left")
	public void wall_stops_the_robot_from_the_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	//Wall stops the robot in the direction it is facing(Wall)
	@Given("a wall standing infront of the robot")
	public void a_wall_standing_infront_of_the_robot() {
		Board board = context.board;
		Wall w = new Wall(board, 5, 6);
	    board.placeEElement(w);
	    context.wall = w;
	}
	
	@When("robot bumps into the wall in its facing direction")
	public void robot_bumps_into_the_wall_in_its_facing_direction() {
		context.robot.shiftY(1);
	}

	@Then("wall stops the robot from moving forward")
	public void wall_stops_the_robot_from_moving_forward() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//Wall stops the robot from the opposite direction(Wall)
	@Given("a wall standing behined the robot")
	public void a_wall_standing_behined_the_robot() {
		Board board = context.board;
		Wall w = new Wall(board, 5, 4);
	    board.placeEElement(w);
	    context.wall = w;
	}
	
	@When("robot bumps in the wall from behind")
	public void robot_bumps_in_the_wall_from_behind() {
		context.robot.shiftY(-1);
	}

	@Then("wall stops the robot from moving backward")
	public void wall_stops_the_robot_from_moving_backward() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}