package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";

	public Position p; //the public position is declared here
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			p = calculatePosition();//the position is initiated here
			board.removeEElement(p); //removes the OilSpill
			board.initialPlacement(new Fire(), p); //places the fire
			
			board.getRobotAt(p).takeDamage(); //damages the robot
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}
