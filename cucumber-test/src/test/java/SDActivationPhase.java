import io.cucumber.java.en.When;

public class SDActivationPhase {
	private Context context;

	public SDActivationPhase(Context context) {
		this.context = context;
	}
	
	@When("the activation phase happens")
	public void the_activation_phase_happens() {
	    context.game.activationPhase();
	}	
}
