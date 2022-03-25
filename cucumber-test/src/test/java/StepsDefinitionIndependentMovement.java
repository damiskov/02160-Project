import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Robot;
import piece_basics.Orientation;
import static org.junit.Assert.*;
public class StepsDefinitionIndependentMovement {
	
	Robot r;

	//scenario 1
	@Given("a Robot")
	public void a_robot(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("execute program")
	public void execute_program() {
	    r.executeProgram();
	}

	@Given("A turn right command")
	public void a_turn_right_command() {
	    r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board1(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot turns right")
	public void robot_turns_right() {
		Orientation prev_o = r.getOrientation();
		   
		   r.turnRight();
		   
		   Orientation curr_o = r.getOrientation();
		   
		   switch(prev_o) {
				case UP:
					assertEquals(curr_o, Orientation.RIGHT);
					break;
				case RIGHT:
					assertEquals(curr_o, Orientation.DOWN);
					break;
				case DOWN:
					assertEquals(curr_o, Orientation.LEFT);
					break;
				case LEFT:
					assertEquals(curr_o, Orientation.DOWN);
					break;
			}
	}


	@Given("A turn left command")
	public void a_turn_left_command() {
		r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board2(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot turns left")
	public void robot_turns_left() {
	   
		Orientation prev_o = r.getOrientation();
	   
	   r.turnLeft();
	   
	   Orientation curr_o = r.getOrientation();
	   
	   switch(prev_o) {
			case UP:
				assertEquals(curr_o, Orientation.LEFT);
				break;
			case RIGHT:
				assertEquals(curr_o, Orientation.UP);
				break;
			case DOWN:
				assertEquals(curr_o, Orientation.RIGHT);
				break;
			case LEFT:
				assertEquals(curr_o, Orientation.DOWN);
				break;
		}
	   
			
	}


	@Given("A move forward command")
	public void a_move_forward_command() {
		r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot2(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot moves forward")
	public void robot_moves_forward() {
		int n = 1;
		int old_x = r.getX();
		int old_y = r.getY();
	   
	   r.move(n);
	   
	   int new_x = r.getX();
	   int new_y = r.getY();
	   
	   switch(r.getOrientation()) {
			case UP:
				assertEquals(new_y, old_y+n);
				break;
			case RIGHT:
				assertEquals(new_x, old_x+n);
				break;
			case DOWN:
				assertEquals(new_y, old_y-n);
				break;
			case LEFT:
				assertEquals(new_x, old_x-n);
				break;
		}
	}


	@Given("a move backwards command")
	public void a_move_backwards_command() {
		int n = -1;
		int old_x = r.getX();
		int old_y = r.getY();
	   
	   r.move(n);
	   
	   int new_x = r.getX();
	   int new_y = r.getY();
	   
	   switch(r.getOrientation()) {
			case UP:
				assertEquals(new_y, old_y+n);
				break;
			case RIGHT:
				assertEquals(new_x, old_x+n);
				break;
			case DOWN:
				assertEquals(new_y, old_y-n);
				break;
			case LEFT:
				assertEquals(new_x, old_x-n);
				break;
		}
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board3(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot moves backward")
	public void backwards() {
		System.out.println("moves backward");
	}

}
