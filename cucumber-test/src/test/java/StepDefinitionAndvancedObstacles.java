import static org.junit.Assert.assertEquals;

import environment_elements.Laser;
import environment_elements.Receiving_teleporter;
import environment_elements.Sending_teleporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import piece_basics.Robot;
import io.cucumber.java.en.Then;

public class StepDefinitionAndvancedObstacles {
	Laser laser;
	Robot robot;
	Sending_teleporter sending;
	Receiving_teleporter receiving1;
	Receiving_teleporter receiving2;
	
	@Given("a laser")
	public void a_laser() {
		Laser laser = new Laser();
	}
	@Given("a robot")
	public void a_robot() {
		Robot robot = new Robot();
		robot.setHealth(3);
	}
	@When("the robot steps into the laser")
	public void the_robot_steps_into_the_laser() {
	    robot.setPosition(laser.getX(),laser.getY());
	    
	}
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
		laser.activate(robot);
	}
	@Then("the robot lost life points")
	public void the_robot_lost_life_points() {
		assertEquals(robot.getHealth(),2);
	}
	
//	@Given("a sending teleporter")
//	public void a_sending_teleporter() {
//	    Sending_teleporter sending = new Sending_teleporter();
//	}
////	@Given("a robot")
////	public void a_robot() {
////		Robot robot = new Robot();
////	}
//	@Given("multiple receiving teleporters")
//	public void multiple_receiving_teleporters() {
//	    Sending_teleporter receiving1 = new Sending_teleporter();
//	    Sending_teleporter receiving2 = new Sending_teleporter();
//	}
//	@When("the robot steps into the sending teleporter")
//	public void the_robot_steps_into_the_sending_teleporter() {
//		robot.setPosition(sending.getX(),sending.getY());
//	}
//	@Then("the robot get teleported to a random receiving teleporter")
//	public void the_robot_get_teleported_to_a_random_receiving_teleporter() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("an oil spill")
	public void an_oil_spill() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a robot")
	public void a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot steps into the oil spill")
	public void the_robot_steps_into_the_oil_spill() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the oil spill ignites")
	public void the_oil_spill_ignites() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("a fire")
	public void a_fire() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a robot")
	public void a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot steps into the fire")
	public void the_robot_steps_into_the_fire() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("a fire")
	public void a_fire() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("a turn passes")
	public void a_turn_passes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the fire spreads to a random adjacent cell")
	public void the_fire_spreads_to_a_random_adjacent_cell() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("reversal panel")
	public void reversal_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a robot")
	public void a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("some remaining moves for the robots")
	public void some_remaining_moves_for_the_robots() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot steps into the reversal panel")
	public void the_robot_steps_into_the_reversal_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the remaining moves get reversed")
	public void the_remaining_moves_get_reversed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("chaining panel")
	public void chaining_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a robot")
	public void a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("no chainable robots")
	public void no_chainable_robots() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot steps into the chaining panel")
	public void the_robot_steps_into_the_chaining_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot becomes chainable")
	public void the_robot_becomes_chainable() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the chaining panel becomes inactive")
	public void the_chaining_panel_becomes_inactive() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("chaining panel")
	public void chaining_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a robot")
	public void a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a chainable robot")
	public void a_chainable_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the first robot steps into the chaining panel")
	public void the_first_robot_steps_into_the_chaining_panel() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robots get chained together")
	public void the_robots_get_chained_together() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the first chaining panel become active again")
	public void the_first_chaining_panel_become_active_again() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("one robot moves and the distance between them becomes greater")
	public void one_robot_moves_and_the_distance_between_them_becomes_greater() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the other robot gets pulled in the same direction")
	public void the_other_robot_gets_pulled_in_the_same_direction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("one of them moves and the distance between them decreases")
	public void one_of_them_moves_and_the_distance_between_them_decreases() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robots get unchained")
	public void the_robots_get_unchained() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("a sending teleporter")
	public void a_sending_teleporter() {
		Sending_teleporter sending = new Sending_teleporter();
	}
//	@Given("a robot")
//	public void a_robot() {
//		
//	}
	@Given("a receiving teleporter")
	public void a_receiving_teleporter() {
		Receiving_teleporter receiving = new Receiving_teleporter();
	}
	@When("the robot steps into the sending teleporter")
	public void the_robot_steps_into_the_sending_teleporter() {
		robot.setPosition(laser.getX(),laser.getY());
	}
	@Then("the robot get teleported to the receiving teleporter")
	public void the_robot_get_teleported_to_the_receiving_teleporter() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
}
