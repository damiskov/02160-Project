package environment_elements;

import board.Position;
import piece_basics.*;
import piece_basics.EnvironmentElement;
import property_changes.ActivationEvent;

public class Laser extends EnvironmentElement {
	
	public static final String ID = "laser";

	@Override
	public void performRegisterAction() {
		Position p = calculatePosition();
		if (board.hasRobotAt(p)) {
			System.out.println(board.getRobotAt(p) + " got damaged by the laser");
			board.getRobotAt(calculatePosition()).takeDamage();
			getPropertyChangeSupport().firePropertyChange(new ActivationEvent(p));
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}

