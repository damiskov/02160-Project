package phases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piece_basics.IRegisterActor;

public class ActivationPhase implements IPhase {
	private Map<String, List<IRegisterActor>> executionLists = new HashMap<>();
	private static final List<String> priorityList = List.of(
			"chaining panel",
			"conveyor_belt",
			"gear",
			"laser",
			"robot_laser",
			"fire",
			"oil_spill",
			"reversal_panel",
			"checkpoint"
	);
	
	// Singleton pattern
	private static ActivationPhase instance;
	private ActivationPhase() {}
	public static ActivationPhase getInstance() {
		if (instance == null) {
			instance = new ActivationPhase();
		}
		return instance;
	}
	
	public void add(IRegisterActor actor) {
		String id = actor.getActorClassID();
		executionLists.computeIfAbsent(id, k -> new ArrayList<IRegisterActor>());
		executionLists.get(id).add(actor);
	}
	
	@Override
	public void executePhase() {
		for (int i = 0; i < 5; i++) {
			// TODO: Activate first card from each program in priority order
			activateRegisterActors();
		}
	}
	// Observer pattern
	public void activateRegisterActors() {
		for (String id: priorityList) {
			if (executionLists.containsKey(id)) {
				for (IRegisterActor actor: executionLists.get(id)) {
					actor.performRegisterAction();
				}
			}
		}
		
	}

}
