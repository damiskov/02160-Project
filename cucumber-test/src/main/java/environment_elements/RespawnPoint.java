package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class RespawnPoint extends EnvironmentElement {

	public static final String ID = "respawn_point";

	@Override
	public void performRegisterAction() {
		Position p = calculatePosition();
		
		if (board.hasRobotAt(p)) {
			board.getRobotAt(p).setRespawnPoint(this);
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}
