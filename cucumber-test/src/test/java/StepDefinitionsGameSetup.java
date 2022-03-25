import io.cucumber.java.en.*;

public class StepDefinitionsGameSetup {
	
	Host host;
	String d;
	Player p;
	StartButton b = new StartButton();
	
	// Scenario 1 - Start game
	
	@Given("A Host")
	public void a_host() {
	    this.host = new Host();
	}
	@Given("A Difficulty")
	public void a_difficulty(String diff) {
		this.d = diff;
	}
	
	@When("Start button pressed")
	public void start_button_pressed() {
	    b.press();
	}
	@Then("Generate Board")
	public void generate_board() {
	    // Generate board
		// Then display
	}
		
	// Scenario 2 - Robot assignment 

	@Given("A Player")
	public void new_player() {
		this.p = new Player();
	    
	}
	@When("Robot selected by Player")
	public void robot_selected_by_player(Robot r) {
	    assign_robot_to_player(r);
	}
	@Then("Assign Robot to Player")
	public void assign_robot_to_player(Robot r) {
		p.AssignRobot(r);
	}

}