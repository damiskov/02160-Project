package environment_elements;

import piece_basics.EnvironmentElement;

public class RespawnPoint extends EnvironmentElement {

	public static final String ID = "respawn_point";
	
	// Respawning (rebooting) logic is handled in the Robot class

	@Override
	public String getPieceID() {
		return ID;
	}

}
