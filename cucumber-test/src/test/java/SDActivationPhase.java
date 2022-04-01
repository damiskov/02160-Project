import io.cucumber.java.en.When;
import phases.ActivationPhase;

public class SDActivationPhase {
	private Context context;

	public SDActivationPhase(Context context) {
		this.context = context;
	}
	
	@When("the activation phase activates the board elements")
	public void the_activation_phase_activates_the_board_elements() {
	    ActivationPhase.getInstance().activateRegisterActors();
	}
}
