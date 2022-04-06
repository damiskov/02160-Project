package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";

	@Override
	public void performRegisterAction() {
		Position p = this.getPosition();
		board.removeEElement(this.getX(),this.getY());
		board.initialPlacement(new Fire(), p);
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}
