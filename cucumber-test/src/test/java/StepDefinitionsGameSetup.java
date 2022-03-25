import io.cucumber.java.en.*;

public class StepDefinitionsGameSetup {
	
	// Scenario 1 - Start game
	
	@Given("A Host")
	public void a_host() {
	    Player h = new host();
	}
	@Given("A Difficulty")
	public void a_difficulty() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Start button pressed")
	public void start_button_pressed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Generate Board")
	public void generate_board() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	// Scenario 2 - Robot assignment 

	@Given("A Player")
	public void a_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("Robot selected by Player")
	public void robot_selected_by_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Assign Robot to Player")
	public void assign_robot_to_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	// Scenario 3 - Select Robot skin
	
	@Given("A Player")
	public void a_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("A Robot assigned to a Player")
	public void a_robot_assigned_to_a_player() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the Player selects a Robot skin")
	public void the_player_selects_a_robot_skin() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Robot acquires skin")
	public void robot_acquires_skin() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
