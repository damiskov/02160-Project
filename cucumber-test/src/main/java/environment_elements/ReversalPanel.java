package environment_elements;

import java.util.ArrayList;

import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import cards.Card;

public class ReversalPanel extends EnvironmentElement implements IRegisterActor{

	//to avoid compilation errors
	@Override
	public void performRegisterAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getActorClassID() {
		return "reversal_panel";
	}

	/*implemented based on these assumptions 
	* - Robot has an attribute Program 
	* - Program is also a class
	*/
	/*Other comments:
	* - Checks if there is a robot, then iterates through the program, makes a new program with the
	*   reversed moves and sets that as the robots program
	* - How do we handle the U-Turn? We can either ignore it or make a new class fullTurn that does
	*   two U-Turns.
	*/
	
/*	public Program[] newProg;
=======
	ArrayList<Card> newProg = new ArrayList<Card>();
>>>>>>> refs/heads/main
	
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
<<<<<<< HEAD
	}*/

}
