import board.Board;
import io.cucumber.java.en.Given;
import piece_basics.Robot;

public class SDRobot {
	private Context context;
	
	public SDRobot(Context context) {
		this.context = context;
	}

	@Given("a robot on the board")
	public void a_robot_on_the_board() {
		Board board = context.board;
	    Robot r = new Robot(board, 5, 5);
	    board.placeRobot(r);
	    context.robot = r;
	}
}
