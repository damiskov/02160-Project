import static org.junit.Assert.assertEquals;

import board.Position;
import environment_elements.ChainingPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

	@When("the robot steps into the chaining panel")
	public void the_robot_steps_into_the_chaining_panel() {
		context.robot.shiftX(1);
		context.chainpan.performRegisterAction();
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
	    context.board.initialPlacement(r2, 7, 5);
	    context.robot2 = r2;
	}

	
	@Given("a second chaining panel on the board at \\({int}, {int})")
	public void a_second_chaining_panel_on_the_board_at(Integer int1, Integer int2) {
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
	@Then("the first chaining panel become active again")
	public void the_first_chaining_panel_become_active_again() {
		assertEquals(true, context.chainpan.isActive());
	}

	
	@Given("two robots chained together")
	public void two_robots_chained_together() {
		Robot r = new Robot();
	    context.board.initialPlacement(r, 8, 5);
	    context.robot = r;
		Robot r2 = new Robot();
	    context.board.initialPlacement(r2, 5, 4);
	    context.robot2 = r2;
	    
		context.robot.setChainedTo(context.robot2);
		context.robot2.setChainedTo(context.robot);
	}
	
	@Then("the robots get unchained")
	public void the_robots_get_unchained() {
		assertEquals(context.robot.getChainedTo(),null);
	    assertEquals(context.robot2.getChainedTo(),null);
	}

}
