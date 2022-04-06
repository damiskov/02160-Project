package phases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piece_basics.IRegisterActor;

public class ActivationPhase implements IPhase {
	
	
	// Singleton pattern
	private static ActivationPhase instance;
	private ActivationPhase() {}
	public static ActivationPhase getInstance() {
		if (instance == null) {
			instance = new ActivationPhase();
		}
		return instance;
	}
	
	
	
	@Override
	public void executePhase() {
		for (int i = 0; i < 5; i++) {
			// TODO: Activate first card from each program in priority order
			activateRegisterActors();
		}
	}
	

}
