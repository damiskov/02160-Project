import static org.junit.Assert.assertEquals;

import environment_elements.ChainingPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Robot;

public class SDChainingPanel {
	private Context context;
	//can someone look at this and the corresponding step code?
	//no idea if this is viable
	//Change some "Then"
	int Xdistance;
	int Ydistance;
	int newXdistance;
	int newYdistance;
	
	public SDChainingPanel(Context context) {
		this.context = context;
	}
	

	@Given("chaining panel")
	public void chaining_panel() {
	    ChainingPanel cp = new ChainingPanel(5, 5);
	    context.board.place(cp);
	    context.chainpan = cp;
	}
	
	@Given("no chainable robots")
	public void no_chainable_robots() {
	    context.chainpan.noChainable(context.robot); //parameter needs to the list of robots on the board
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
	    context.chainpan.setActive(false);
	    assertEquals(true, context.robot.isChainable());
	    assertEquals(false, context.chainpan.isActive());
	}
	
	@Given("a chainable robot")
	public void a_chainable_robot() {
	    Robot r = new Robot(7, 10);
	    r.setChainable(true);
	    context.board.place(r);
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
	    context.chainpan.setActive(true);
	}
	@Then("the robots are chained")
	public void the_robots_are_chained() {
		assertEquals(context.robot, context.robot2.getChainedTo());
	    assertEquals(context.robot2, context.robot.getChainedTo());
	}
	
	
	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
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
	    assertEquals(context.robot.isChainable(),false);
	    assertEquals(context.robot2.isChainable(),false);
	    
	}
}
