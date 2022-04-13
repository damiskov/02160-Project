package environment_elements;

import java.util.ArrayList;

import piece_basics.EnvironmentElement;
import cards.Card;
import cards.Program;

public class ReversalPanel extends EnvironmentElement {

	public static final String ID = "reversal_panel";
	//public ArrayList<Card> newProg = new ArrayList<Card>();
	public Program newProg = new Program();

	@Override
	public String getPieceID() {
		return ID;
	}
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) {
			Program program = board.getRobotAt(calculatePosition()).getProgram();
			int programLength = program.getProgram().size();
			
			for (int i = 0; i < programLength; i++) {
				newProg.getProgram().add(program.getProgram().get(i).getOppositeCard());
			}
			
			board.getRobotAt(calculatePosition()).setProgram(newProg.getProgram());
		}

	}

}
