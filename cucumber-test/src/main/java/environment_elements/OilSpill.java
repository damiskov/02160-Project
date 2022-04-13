package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";

	public Position p; //ask Andrea about this
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			p = calculatePosition();
			board.removeEElement(p);
			board.initialPlacement(new Fire(), p);
			
			board.getRobotAt(p).takeDamage();
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}
