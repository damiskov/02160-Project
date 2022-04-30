package environment_elements;

import piece_basics.Robot;

public class FinalCheckpoint extends Checkpoint {

	public FinalCheckpoint(int number) {
		super(number);
	}

	@Override
	public void performImmediateAction(Robot r) {
		super.performImmediateAction(r);
		if (r.getMostRecentCheckpoint() == getNumber()) {
			// Inform the Game that this robot won
			board.getGame().finishGame(r.getRobotNumber());
		}
	}
}
