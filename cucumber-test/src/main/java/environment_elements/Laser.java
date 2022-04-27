package environment_elements;

import board.Position;
import piece_basics.*;
import piece_basics.EnvironmentElement;
import property_changes.ActivationEvent;

public class Laser extends EnvironmentElement {
	
	public static final String ID = "laser";

	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			System.out.println(board.getRobotAt(calculatePosition()) + " got damaged by the laser");
			board.getRobotAt(calculatePosition()).takeDamage();
			getPropertyChangeSupport().firePropertyChange(new ActivationEvent(calculatePosition()));
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}
}

