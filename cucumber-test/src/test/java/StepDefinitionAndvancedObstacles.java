import static org.junit.Assert.assertEquals;

import board.Board;
import environment_elements.Chaining_Panel;
import environment_elements.Fire;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Reversal_Panel;
import environment_elements.Teleporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import piece_basics.Robot;
import io.cucumber.java.en.Then;

public class StepDefinitionAndvancedObstacles {
	private Context context;
	//these are going to have to change
	int Xdistance;
	int Ydistance;
	int newXdistance;
	int newYdistance;
	
	public StepDefinitionAndvancedObstacles(Context context) {
		this.context = context;
	}

	@Given("a laser")
	public void a_laser() {
		Board board = context.board;
		Laser l = new Laser(board, 6, 5);
		board.placeEElement(l);
	    context.laser = l;
	}
	@Given("a robot")
	public void a_robot() {
		context.robot.setHealth(3);
	}
	@When("the robot steps into the laser")
	public void the_robot_steps_into_the_laser() {
		context.robot.shiftX(1);
	}
	@Then("the robot loses life points")
	public void the_robot_loses_life_points() {
		context.laser.activate(context.robot);
	}
	@Then("the robot lost life points")
	public void the_robot_lost_life_points() {
		assertEquals(context.robot.getHealth(),2);
	}
	


	@Given("an oil spill")
	public void an_oil_spill() {
		OilSpill s = new OilSpill(context.board, 6, 5);
		context.board.placeEElement(s);
	    context.spill = s;
	}
//	@Given("a robot")
//	public void a_robot() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("the robot steps into the oil spill")
	public void the_robot_steps_into_the_oil_spill() {
		context.robot.shiftX(1);
	}
	@Then("the oil spill ignites")
	public void the_oil_spill_ignites() {
	    context.spill.ignite();
	}
//	@Then("the robot loses life points")
//	public void the_robot_loses_life_points() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	
	@Given("a fire")
	public void a_fire() {
		Fire f = new Fire(context.board, 6, 5);
		context.board.placeEElement(f);
	    context.fire = f;
	}
//	@Given("a robot")
//	public void a_robot() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("the robot steps into the fire")
	public void the_robot_steps_into_the_fire() {
		context.robot.shiftX(1);
	}
	@Then("the robot loses life points")
//	public void the_robot_loses_life_points() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	
	@Given("a fire")
//	public void a_fire() {
//		Fire f = new Fire(context.board, 8, 5);
//		context.board.placeEElement(f);
//	    context.fire = f;
//	}
	
	@When("a turn passes")
	public void a_turn_passes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the fire spreads to a random adjacent cell")
	public void the_fire_spreads_to_a_random_adjacent_cell() {
	    context.fire.spread(context.board);
	}
	
	@Given("reversal panel")
	public void reversal_panel() {
	    Reversal_Panel rp = new Reversal_Panel(context.board, 6, 5);
	    context.board.placeEElement(rp);
	    context.revpan = rp;
	    
	}
	@Given("a robot")
//	public void a_robot() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@Given("some remaining moves for the robots")
	public void some_remaining_moves_for_the_robots() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the robot steps into the reversal panel")
	public void the_robot_steps_into_the_reversal_panel() {
		context.robot.shiftX(1);
	}
	@Then("the remaining moves get reversed")
	public void the_remaining_moves_get_reversed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("chaining panel")
	public void chaining_panel() {
	    Chaining_Panel cp = new Chaining_Panel(context.board, 5, 5);
	    context.board.placeEElement(cp);
	    context.chainpan = cp;
	}
	
	@Given("a robot")
//	public void a_robot() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@Given("no chainable robots")
	public void no_chainable_robots() {
	    context.chainpan.noChainable(context.robot); //parameter needs to be list of robots
	}
	@When("the robot steps into the chaining panel")
	public void the_robot_steps_into_the_chaining_panel() {
		context.robot.shiftX(1);
	}
	@Then("the robot becomes chainable")
	public void the_robot_becomes_chainable() {
	    context.chainpan.chain1(context.robot);
	}
	@Then("the chaining panel becomes inactive")
	public void the_chaining_panel_becomes_inactive() {
	    context.chainpan.inactivate();
	    assertEquals(true, context.robot.chainable);
	    assertEquals(false, context.chainpan.active);
	}
	
	@Given("chaining panel")
//	public void chaining_panel() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Given("a robot")
//	public void a_robot() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@Given("a chainable robot")
	public void a_chainable_robot() {
	    Robot r = new Robot(context.board, 7, 10);
	    r.chainable = true;
	    context.board.placeRobot(r);
	    context.robot2 = r;
	    
	}
	@When("the first robot steps into the chaining panel")
	public void the_first_robot_steps_into_the_chaining_panel() {
		context.robot.shiftX(1);
	}
	@Then("the robots get chained together")
	public void the_robots_get_chained_together() {
	    context.chainpan.chainRobots(context.robot, context.robot2);
	}
	@Then("the first chaining panel become active again")
	public void the_first_chaining_panel_become_active_again() {
	    context.chainpan.activate();
	}
	@Then("the robots are chained")
	public void the_robots_are_chained() {
		assertEquals(context.robot, context.robot2.chainedTo);
	    assertEquals(context.robot2, context.robot.chainedTo);
	}
	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
		context.robot.chainedTo = context.robot2;
		context.robot2.chainedTo = context.robot;
		Xdistance = context.robot.getX()-context.robot2.getX();
		Ydistance = context.robot.getY()-context.robot2.getY();

	}
	@When("one robot moves and the distance between them becomes greater")
	public void one_robot_moves_and_the_distance_between_them_becomes_greater() {
		newXdistance = context.robot.getX()-context.robot2.getX();
		newYdistance = context.robot.getY()-context.robot2.getY();
		
	}
	@Then("the other robot gets pulled in the same direction")
	public void the_other_robot_gets_pulled_in_the_same_direction() {
		if(newXdistance > Xdistance) {
	    context.robot.pullChained(context.robot2, (newXdistance - Xdistance), "X" );
	    }
		else if(newYdistance > Ydistance) {
		    context.robot.pullChained(context.robot2, (newYdistance - Ydistance), "Y" );
		}
		
	}
	
	@Then("the other robot got pulled in the same direction")
	public void the_other_robot_got_pulled_in_the_same_direction() {
		//if context.robot moved in the X direction
		assertEquals(context.robot2.getX(), 5 + (newXdistance - Xdistance));
		//if context.robot moved in the Y direction
		assertEquals(context.robot2.getY(), 5 + (newYdistance - Ydistance));
		//if context.robot2 moved in the X direction
		assertEquals(context.robot.getX(), 5 + (newXdistance - Xdistance));
		//if context.robot2 moved in the Y direction
		assertEquals(context.robot.getY(), 5 + (newYdistance - Ydistance));
	}
	
	@Given("two robots chained together")
//	public void two_robots_chained_together() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("one of them moves and the distance between them decreases")
	public void one_of_them_moves_and_the_distance_between_them_decreases() {
		newXdistance = context.robot.getX()-context.robot2.getX();
		newYdistance = context.robot.getY()-context.robot2.getY();
	}
	@Then("the robots get unchained")
	public void the_robots_get_unchained() {
	    context.chainpan.unChain(context.robot, context.robot2);
	}
	
	@Then("the robots are unchained")
	public void the_robots_are_unchained() {
	    assertEquals(context.robot.chainable,false);
	    assertEquals(context.robot2.chainable,false);
	    
	}
	
	@Given("a sending teleporter")
	public void a_sending_teleporter() {
		Teleporter sed = new Teleporter(context.board, 5, 5);
		context.board.placeEElement(sed);
	    context.sending = sed;
	}
	@Given("a robot")
//	public void a_robot() {
//		
//	}
	@Given("a receiving teleporter")
	public void a_receiving_teleporter() {
		Teleporter rec = new Teleporter(context.board, 10, 5);
		context.board.placeEElement(rec);
	    context.receiving = rec;
	}
	@When("the robot steps into the sending teleporter")
	public void the_robot_steps_into_the_sending_teleporter() {
		context.robot.shiftX(1);
	}
	@Then("the robot get teleported to the receiving teleporter")
	public void the_robot_get_teleported_to_the_receiving_teleporter() {
		context.sending.activate(context.robot, context.receiving);
	}
	
	@Then("the robot got teleported to the receiving teleporter")
	public void the_robot_got_teleported_to_the_receiving_teleporter() {
		assertEquals(context.robot.getX(),context.receiving.getX());
		assertEquals(context.robot.getY(),context.receiving.getY());
	}

	
	
	
	
	
	
	
	
	
	
//Random Teleporter
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
	
}
