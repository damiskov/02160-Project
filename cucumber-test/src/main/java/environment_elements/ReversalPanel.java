package environment_elements;

import java.util.ArrayList;

import piece_basics.EnvironmentElement;
import cards.Card;

public class ReversalPanel extends EnvironmentElement {

	public static final String ID = "reversal_panel";
	public ArrayList<Card> newProg = new ArrayList<Card>();

	@Override
	public String getPieceID() {
		return ID;
	}
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getPosition())) {
			ArrayList<Card> program = board.getRobotAt(getPosition()).getProgram();
			int programLength = program.size();
			
			for (int i = 0; i < programLength; i++) {
				newProg.add(program.get(i).getOppositeCard());
			}
			
			board.getRobotAt(getPosition()).updateProgram(newProg);
		}

	}

}
