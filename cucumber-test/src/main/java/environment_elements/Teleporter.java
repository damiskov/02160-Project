package environment_elements;

import piece_basics.EnvironmentElement;

public class Teleporter extends EnvironmentElement {
	private Teleporter receiving;
	
	public static final String ID = "teleporter";
	
	public void setReceiving(Teleporter receiving) {
		this.receiving = receiving;
	}

	@Override
	public String getPieceID() {
		return ID;
	}


	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			board.moveRobotFromTo(calculatePosition(), receiving.calculatePosition());
		}
		
	}
}

