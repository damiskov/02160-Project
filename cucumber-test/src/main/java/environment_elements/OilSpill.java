package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";

	private Position p; //the public position is declared here
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			setPosition(calculatePosition());
			board.removeEElement(getPosition()); //removes the OilSpill
			board.initialPlacement(new Fire(), getPosition()); //places the fire
			
			System.out.println(board.getRobotAt(getPosition()) + " got damaged by the fire");
			board.getRobotAt(getPosition()).takeDamage(); //damages the robot
		}
	}

	public void setPosition(Position pos) {
		this.p = pos;
	}
	
	public Position getPosition() {
		return this.p;
	}
	@Override
	public String getPieceID() {
		return ID;
	}
}
