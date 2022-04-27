package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class OilSpill extends EnvironmentElement {

	public static final String ID = "oil_spill";
	private Position p; 
	
	//performRegisterAction implements the game functionality of the obstacle
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) { //if a robot is on the oil spill
			setP(calculatePosition());
			board.removeEElement(getP()); //remove the oil spill
			board.initialPlacement(new Fire(), getP()); //place a fire where the oil spill was
			
			System.out.println(board.getRobotAt(getP()) + " got damaged by the fire");
			board.getRobotAt(getP()).takeDamage(); //damage the robot
		}
	}

	//getter and setter for p
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
