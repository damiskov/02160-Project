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
			//System.out.println("THIS IS WHERE IT GOES WRONG");
			Program program = board.getRobotAt(calculatePosition()).getProgram(); //get the robot's program
			
			ArrayList<Card> newCards = new ArrayList<>();
			/*iterate through the program and create a new program 
			with the opposite card of each card in the program*/
			System.out.println("-----------------------STEPPED ON REVERSAL PANEL---------------");
			Card c = new Card("");
			//outer:
//			while (program.getCardList().size()!=0)
//			{
//				
//				c = program.getTopOfProgram();
//				newCards.add(c.getOppositeCard());
//				System.out.println("Adding card"+c.getAction()+" to Program");
//				if(program.getCardList().size()==0)
//				{
//
//					System.out.println("End of program");
//					System.out.println("------------------END OF REVERSAL PANEL REGISTER ACTION-----");
//					break outer;
//				}
//
//			//Card c = new Card();
//			
//			
////			Card c = program.getCardList().pop();
////			while(program.getCardList().size() != 0) {
////				System.out.println(program.getCardList().size());
////				newProg.getCardList().add(c.getOppositeCard());
////				c = program.getCardList().pop();
////				if(program.getCardList().size() == 0) {
////					newProg.getCardList().add(c.getOppositeCard());
////				
////				}
////			}
//				
////				else {
////					c = null;
////				}
//			
//			
//			
//			System.out.println("-------------ASSIGNING NEW PROGRAM TO ROBOT ----------------");
//			Program newProgram = new Program();
//			Collections.reverse(newCards);
//			newProgram.getCardList().addAll(newCards);
//			for (Card i : newProgram.getCardList())
//			{
//				System.out.println("Program contains: " + i.getAction());
//			}
//			
//			board.getRobotAt(calculatePosition()).setProgram(newProgram.getCardList()); //set the robot's program to be the reversed program
//			System.out.println(board.getRobotAt(calculatePosition()).getProgram().getCardList());
//
//		}
//			System.out.println("------------- SUCCESSFULLY ADDED CARDS TO PROGRAM ------------");
		}

	}


}
