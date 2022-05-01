package environment_elements;

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
			int programLength = program.getCardList().size();
			
			/*iterate through the program and create a new program 
			with the opposite card of each card in the program*/
			for (int i = 0; i < programLength; i++) {
				System.out.println("YES");
				newProg.getCardList().add(program.getCardList().get(i).getOppositeCard());
			}
			//Card c = new Card();
			
			
//			Card c = program.getCardList().pop();
//			while(program.getCardList().size() != 0) {
//				System.out.println(program.getCardList().size());
//				newProg.getCardList().add(c.getOppositeCard());
//				c = program.getCardList().pop();
//				if(program.getCardList().size() == 0) {
//					newProg.getCardList().add(c.getOppositeCard());
//				
//				}
//			}
				
//				else {
//					c = null;
//				}
			
			
			
			System.out.println(board.getRobotAt(calculatePosition()) + " got the moves in its program reversed");
			System.out.println(board.getRobotAt(calculatePosition()).getProgram().getCardList());
			board.getRobotAt(calculatePosition()).setProgram(newProg.getCardList()); //set the robot's program to be the reversed program
			System.out.println(board.getRobotAt(calculatePosition()).getProgram().getCardList());

		}
		}

	}


//}
