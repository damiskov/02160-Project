package environment_elements;

import piece_basics.EnvironmentElement;

public class RespawnPoint extends EnvironmentElement {

	public static final String ID = "respawn_point";

	@Override
	public String getPieceID() {
		return ID;
	}

}
