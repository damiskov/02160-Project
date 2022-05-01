package environment_elements;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Program;
import piece_basics.EnvironmentElement;

public class ReversalPanel extends EnvironmentElement {

	public static final String ID = "reversal_panel";
	public Program newProg = new Program();

	@Override
	public String getPieceID() {
		return ID;
	}
		
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) { 
			Program program = board.getRobotAt(calculatePosition()).getProgram(); //get the robot's program
			
			ArrayList<Card> newCards = new ArrayList<>();
			/*iterate through the program and create a new program 
			with the opposite card of each card in the program*/
			System.out.println("-----------------------STEPPED ON REVERSAL PANEL---------------");
			Card c = new Card("");
			outer:
			while (program.getCardList().size()!=0)
			{
				c = program.getTopOfProgram();
				newCards.add(c.getOppositeCard());
				System.out.println("Adding card"+c.getAction()+" to Program");
				if(program.getCardList().size()==0)
				{
					System.out.println("End of program");
					System.out.println("------------------END OF REVERSAL PANEL REGISTER ACTION-----");
					break outer;
				}
			}
			
			System.out.println("-------------ASSIGNING NEW PROGRAM TO ROBOT ----------------");
			Program newProgram = new Program();
			Collections.reverse(newCards);
			newProgram.getCardList().addAll(newCards);
			for (Card i : newProgram.getCardList())
			{
				System.out.println("Program contains: " + i.getAction());
			}
			
			board.getRobotAt(calculatePosition()).setProgram(newProg.getCardList()); //set the robot's program to be the reversed program
			System.out.println("------------- SUCCESSFULLY ADDED CARDS TO PROGRAM ------------");
		}

	}

}
