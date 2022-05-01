package environment_elements;


import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Program;
import piece_basics.EnvironmentElement;

public class ReversalPanel extends EnvironmentElement {

	public static final String ID = "reversal_panel";
	private Program newProgram = new Program();

	@Override
	public String getPieceID() {
		return ID;
	}
		
	public Program getNewProgram() {
		return newProgram;
	}
	
	
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) { 
			Program program = board.getRobotAt(calculatePosition()).getProgram(); 
			ArrayList<Card> newCards = new ArrayList<>();
			
			/*iterate through the program and create a new program 
			with the opposite card of each card in the program*/
			Card c = new Card("");
			outer:
			while (program.getCardList().size()!=0)
			{
				c = program.getTopOfProgram();
				newCards.add(c.getOppositeCard());
				if(program.getCardList().size()==0)
				{
					break outer;
				} 
			}
			
			//sets the program and assigns it to the robot
			Collections.reverse(newCards);
			newProgram.getCardList().addAll(newCards);
			board.getRobotAt(calculatePosition()).setProgram(newProgram.getCardList()); 
			System.out.println(board.getRobotAt(calculatePosition()) + "got its moves reversed");
		}

	}


}
