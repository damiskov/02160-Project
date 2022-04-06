package environment_elements;

import java.util.ArrayList;

import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import cards.Card;

public class ReversalPanel extends EnvironmentElement implements IRegisterActor{

	ArrayList<Card> newProg = new ArrayList<Card>();
	
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
