import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import environment_elements.ConveyorBelt;
import game_basics.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import piece_basics.Orientation;

public class SDConveyorBelt {
	private Context context;
	
	public SDConveyorBelt(Context context) {
		this.context = context;
	}
	
	@Given("a conveyor belt on the board at \\({int}, {int}) facing {string}")
	public void a_conveyor_belt_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    ConveyorBelt c = null;
	    switch (string.toLowerCase()) {
	    case "up":
	    	c = new ConveyorBelt(Orientation.UP); break;
	    case "right":
	    	c = new ConveyorBelt(Orientation.RIGHT); break;
	    case "down":
	    	c = new ConveyorBelt(Orientation.DOWN); break;
	    case "left":
	    	c = new ConveyorBelt(Orientation.LEFT); break;
	    default:
	    	throw new IllegalArgumentException("Invalid orientation");
	    }
    	context.board.initialPlacement(c, int1, int2);
    	context.conveyorBelt = c;
	}
	
	@Then("the environment element at \\({int}, {int}) is orientated")
	public void the_environment_element_at_is_orientated(Integer int1, Integer int2) {
		assertTrue(context.board.getEElementAt(new Position(int1, int2)) instanceof ConveyorBelt);
		assertEquals(((ConveyorBelt) context.board.getEElementAt(new Position(int1, int2))).getOrientation(), Orientation.RIGHT);
	}
}
