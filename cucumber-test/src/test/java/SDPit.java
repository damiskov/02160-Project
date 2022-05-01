import environment_elements.Pit;
import io.cucumber.java.en.Given;

public class SDPit {
	private Context context;

	public SDPit(Context context) {
		this.context = context;
	}
	
	@Given("a pit on the board at \\({int}, {int})")
	public void a_pit_on_the_board_at(Integer int1, Integer int2) {
		Pit p = new Pit();
	    context.board.initialPlacement(p, int1, int2);
	    context.pit = p;
	}

}
