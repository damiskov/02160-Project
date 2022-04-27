package environment_elements;

import java.util.ArrayList;

import piece_basics.EnvironmentElement;
import cards.Card;
import cards.Program;

public class ReversalPanel extends EnvironmentElement {

	public static final String ID = "reversal_panel";
	public Program newProg = new Program();

	@Override
	public String getPieceID() {
		return ID;
	}
	
	//performRegisterAction implements the game functionality of the obstacle
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) { //if there is a robot on the panel
			Program program = board.getRobotAt(calculatePosition()).getProgram(); //get the robot's program
			int programLength = program.getCardList().size();
			
			//iterate through the program and create a new program with the opposite card of each card in the program
			for (int i = 0; i < programLength; i++) {
				newProg.getCardList().add(program.getCardList().get(i).getOppositeCard());
			}
			System.out.println(board.getRobotAt(calculatePosition()) + " got the moves in its program reversed");
			board.getRobotAt(calculatePosition()).setProgram(newProg.getCardList()); //set the robot's program to be the reversed program
		}

	}

}
