import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import environment_elements.ReversalPanel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDReversalPanel {
	
	private Context context;
	
	public SDReversalPanel(Context context) {
		this.context = context;		
	}

	@Given("reversal panel on the board at \\({int}, {int})")
	public void reversal_panel_on_the_board_at(Integer int1, Integer int2) {
		ReversalPanel rp = new ReversalPanel();
	    context.board.initialPlacement(rp, int1, int2);
	    context.revpan = rp;
	}
	@Then("the remaining moves get reversed")
	public void the_remaining_moves_get_reversed() {
	    assertEquals(context.robot.getProgram(), context.revpan.newProg);
	}
}
