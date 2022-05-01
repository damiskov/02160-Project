import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import environment_elements.Gear;
import game_basics.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SDGear {
private Context context;
	
	public SDGear(Context context) {
		this.context = context;
	}
	
	@Given("a gear on the board at \\({int}, {int}) spinning {string}")
	public void a_gear_on_the_board_at_spinning(Integer int1, Integer int2, String string) {
	    Gear g = null;
	    switch (string.toLowerCase()) {
	    case "clockwise": 
	    	g = new Gear(false); break;
	    case "counterclockwise": 
	    	g = new Gear(true); break;
    	default:
    		throw new IllegalArgumentException("Invalid direction");
	    }
	    context.board.initialPlacement(g, int1, int2);
	    context.gear = g;
	}
	
	@Then("the environment element at \\({int}, {int}) is a counterclockwise gear")
	public void the_environment_element_at_is_a_counterclockwise_gear(Integer int1, Integer int2) {
	    assertTrue(context.board.getEElementAt(new Position(int1, int2)) instanceof Gear);
		assertEquals(((Gear) context.board.getEElementAt(new Position(int1, int2))).isCounterClockwise(), true);
	}

}
