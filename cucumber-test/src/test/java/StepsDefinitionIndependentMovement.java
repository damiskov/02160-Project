import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Robot;

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
	public void a_robot_on_the_board(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot turns right")
	public void robot_turns_right() {
	    r.turnRight();
	}


	@Given("A turn left command")
	public void a_turn_left_command() {
		r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot turns left")
	public void robot_turns_left() {
	   Orientation prev_o = r.getOrientation();
	   r.turnLeft();
		switch(prev_o):
			case UP:
				
				break;
			case RIGHT:
				setX(getX() + spaces);
				break;
			case DOWN:
				setY(getY() - spaces);
				break;
			case LEFT:
				setX(getX() - spaces);
				break;
			
	}


	@Given("A move forward command")
	public void a_move_forward_command() {
		r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot moves forward")
	public void robot_moves_forward() {
	    r.move(1)
	}


	@Given("a move backwards command")
	public void a_move_backwards_command() {
		r.executeCommand();
	}
	@Given("a robot on the board")
	public void a_robot_on_the_board(Robot robo_cop) {
		r = robo_cop;
	}
	@Then("Robot moves forward")
	public void robot_moves_forward() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
