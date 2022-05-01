import static org.junit.Assert.assertEquals;

import environment_elements.ChainingPanel;
import game_basics.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Orientation;
import piece_basics.Robot;

public class SDChainingPanel {
	private Context context;
	
	
	public SDChainingPanel(Context context) {
		this.context = context;
	}
	
	@Given("a chaining panel on the board at \\({int}, {int})")
	public void a_chaining_panel_on_the_board_at(Integer int1, Integer int2) {
		ChainingPanel cp = new ChainingPanel();
	    context.board.initialPlacement(cp, new Position(int1, int2) );
	    context.chainpan = cp;
	}

	@Then("the robot becomes chainable")
	public void the_robot_becomes_chainable() {
		assertEquals(true, context.robot.isChainable());
	}
	@Then("the chaining panel becomes inactive")
	public void the_chaining_panel_becomes_inactive() {
	    assertEquals(false, context.chainpan.isActive());
	}
	
	@Given("a chainable robot")
	public void a_chainable_robot() {
	    Robot r2 = new Robot();
	    r2.setChainable(true);
	    r2.setChainedFrom(context.chainpan2);
	    context.board.initialPlacement(r2, 7, 5);
	    context.robot2 = r2;
	}

	
	@Given("an inactive chaining panel on the board at \\({int}, {int})")
	public void an_inactive_chaining_panel_on_the_board_at(Integer int1, Integer int2) {
		ChainingPanel cp2 = new ChainingPanel();
	    context.board.initialPlacement(cp2, new Position(int1, int2) );
	    cp2.setActive(false);
	    context.chainpan2 = cp2;
	}

	@Then("the robots get chained together")
	public void the_robots_get_chained_together() {
		assertEquals(context.robot, context.robot2.getChainedTo());
		assertEquals(context.robot2, context.robot.getChainedTo());
	}
	@Then("the inactive chaining panel become active again")
	public void the_inactive_chaining_panel_become_active_again() {
		assertEquals(true, context.chainpan2.isActive());
	}

	
	@Given("the robots are chained together")
	public void the_robots_are_chained_together() {
	    context.robot.setChainedTo(context.robot2);
	    context.robot2.setChainedTo(context.robot);
	}
	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    r.setOrientation(Orientation.RIGHT);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 4, 5);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Given("two robots chained together with one facing left")
	public void two_robots_chained_together_with_one_facing_left() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    r.setOrientation(Orientation.LEFT);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 4, 5);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Given("two robots chained together with one facing right")
	public void two_robots_chained_together_with_one_facing_right() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    r.setOrientation(Orientation.RIGHT);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 4, 5);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Given("two robots chained together with one facing up")
	public void two_robots_chained_together_with_one_facing_up() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    r.setOrientation(Orientation.UP);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 4, 5);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Given("two robots chained together with one facing down")
	public void two_robots_chained_together_with_one_facing_down() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    r.setOrientation(Orientation.DOWN);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 4, 5);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Then("the robots get unchained")
	public void the_robots_get_unchained() {
		assertEquals(context.robot.getChainedTo(),null);
	    assertEquals(context.robot2.getChainedTo(),null);
	}

	
	@Then("the chaining panel is still inactive")
	public void the_chaining_panel_is_still_inactive() {
		assertEquals(context.chainpan2.isActive(),false);
		assertEquals(context.robot.getChainedTo(),null);
	}
	
	@Then("the robot is still not chained")
	public void the_robot_is_still_not_chained() {
		assertEquals(context.robot.getChainedTo(),null);
	}
	
	@Then("the chaining panel is at five, five")
	public void the_chaining_panel_is_at_five_five() {
	    assertEquals(context.chainpan.getX(), 5);
	    assertEquals(context.chainpan.getY(), 5);
	}
	
	@Then("the second robot is not chainable")
	public void the_second_robot_is_not_chainable() {
	    assertEquals(false, context.robot2.isChainable());
	}
}
