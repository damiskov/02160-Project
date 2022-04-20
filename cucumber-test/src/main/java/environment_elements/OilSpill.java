package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";

	private Position p; //the public position is declared here
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			setP(calculatePosition());
			board.removeEElement(getP()); //removes the OilSpill
			board.initialPlacement(new Fire(), getP()); //places the fire
			
			System.out.println(board.getRobotAt(getP()) + " got damaged by the fire");
			board.getRobotAt(getP()).takeDamage(); //damages the robot
		}
	}

	public void setP(Position pos) {
		this.p = pos;
	}
	
	public Position getP() {
		return this.p;
	}
	@Override
	public String getPieceID() {
		return ID;
	}
}
