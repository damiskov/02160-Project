package environment_elements;

import piece_basics.Robot;
import property_changes.GameWinEvent;

public class FinalCheckpoint extends Checkpoint {

	public FinalCheckpoint(int number) {
		super(number);
	}

	@Override
	public void performImmediateAction(Robot r) {
		super.performImmediateAction(r);
		if (r.getMostRecentCheckpoint() == getNumber()) {
			getPropertyChangeSupport().firePropertyChange(new GameWinEvent(r.getRobotNumber()));
			board.getGame().finishGame();
		}
	}
}
