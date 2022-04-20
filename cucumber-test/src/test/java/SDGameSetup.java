import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.*;

public class SDGameSetup {
	
	private Context context;

	public SDGameSetup(Context context) {
		this.context = context;
	}
	
	String d;
	
// Scenario 1 - Start game
//Given a host

	//given a difficulty
	
//	@When("Start button pressed")
//	public void start_button_pressed() {
//	    context.startButton.press();
//	}
//	@Then("Generate Board")
//	public void generate_board() {
//	    // Generate board
//		// Then display
//	}
		
// Scenario 2 - Robot assignment 
//given a player
	@When("Robot selected by Player")
	public void robot_selected_by_player() {
	    context.player.setRobot(context.robot);
	}
	@Then("Assign Robot to Player")
	public void assign_robot_to_player() {
		assertEquals(context.player.getRobot(), context.robot);
	}

}