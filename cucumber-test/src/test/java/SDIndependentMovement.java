
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Robot;
import piece_basics.Orientation;
import static org.junit.Assert.*;
import board.Board;
import cards.BackUp;
import cards.Card;
import cards.Move1;
import cards.TurnLeft;
import cards.TurnRight;
public class SDIndependentMovement {
	
	private Context context;
	
	public SDIndependentMovement(Context context) {
		this.context = context;
	}
	
	
//given a robot on the board

//given a command
	@Given("A turn right command")
	public void a_turn_right_command() {
		 Card r1_card = new TurnRight();
		 context.card = r1_card;
	}

	
//given a robot on the board
	@Then("Robot turns right")
	public void robot_turns_right() {
		Orientation prev_o = context.robot.getOrientation();
		   
		context.card.executeAction(context.robot);
		   
		   Orientation curr_o = context.robot.getOrientation();
		   
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
		Card l1_card = new TurnLeft();
		context.card = l1_card;
	}

//given a robot on the board
	@Then("Robot turns left")
	public void robot_turns_left() {
	   
		Orientation prev_o = context.robot.getOrientation();
	   
		context.card.executeAction(context.robot);
	   
	   Orientation curr_o = context.robot.getOrientation();
	   
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
		Card f1_card = new Move1();
		context.card = f1_card;
	}

//given a robot on the board
	@Then("Robot moves forward")
	public void robot_moves_forward() {
		int n = 1;
		int old_x = context.robot.getX();
		int old_y = context.robot.getY();
	   
		context.card.executeAction(context.robot);
	   
	   int new_x = context.robot.getX();
	   int new_y = context.robot.getY();
	   
	   switch(context.robot.getOrientation()) {
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
		Card b1_card = new BackUp();
		context.card = b1_card;
	}

//given a robot on the board
	@Then("Robot moves backward")
	public void backwards() {
		int n = -1;
		int old_x = context.robot.getX();
		int old_y = context.robot.getY();
	   
		context.card.executeAction(context.robot);
	   
	   int new_x = context.robot.getX();
	   int new_y = context.robot.getY();
	   
	   switch(context.robot.getOrientation()) {
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

}
