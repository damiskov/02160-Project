import static org.junit.Assert.assertTrue;

import environment_elements.Fire;
import environment_elements.OilSpill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SDOilSpill{

	private Context context;
	
	public SDOilSpill(Context context) {
		this.context = context;		
	}
	
	@Given("an oil spill on the board at \\({int}, {int})")
	public void an_oil_spill_on_the_board_at(Integer int1, Integer int2) {
		OilSpill s = new OilSpill();
		context.board.initialPlacement(s, int1, int2);
	    context.spill = s;
	}
	
	@Then("the oil spill ignites")
	public void the_oil_spill_ignites() {
		assertTrue(context.board.getEElementAt(context.spill.getP()) instanceof Fire);
	}
	
}
