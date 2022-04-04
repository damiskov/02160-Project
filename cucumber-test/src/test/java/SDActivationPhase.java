import io.cucumber.java.en.When;
import phases.ActivationPhase;

public class SDActivationPhase {
	private Context context;

	public SDActivationPhase(Context context) {
		this.context = context;
	}
	
	@When("the board elements activate")
	public void the_board_elements_activate() {
		ActivationPhase.getInstance().activateRegisterActors();
	}
}
