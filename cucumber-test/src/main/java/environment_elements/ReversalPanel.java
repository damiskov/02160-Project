package environment_elements;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class ReversalPanel extends EnvironmentElement implements IRegisterActor{

	//to avoid compilation errors
	@Override
	public void performRegisterAction() {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(getPosition())) {
			Card[] program = board.getRobotAt(getPosition()).getProgram();
			int programLength = program.length;
			
			for (int i = 0; i < programLength; i++) {
				if (program[i] instanceof Move1) {
					backUp back1 = new backUp;
					newProg.add(back1);
				}
				else if (program[i] instanceof Move2) {
					backUp2 back2 = new backUp2;
					newProg.add(back2);
				}
				else if (program[i] instanceof Move3) {
					backUp3 back3 = new backUp3;
					newProg.add(back3);
				}
				else if (program[i] instanceof backUp) {
					Move1 forward1 = new Move1;
					newProg.add(Move1);
				}
				else if (program[i] instanceof turnLeft) {
					turnRight right = new turnRight;
					newProg.add(right1);
				}
				else if (program[i] instanceof turnRight) {
					turnLeft left1 = new turnLeft;
					newProg.add(left1);
				}
				else if (program[i] instanceof uTurn) {
					backUp back1 = new backUp;
					newProg.add(back1);
				}
			}
			board.getRobotAt(getPosition()).program = newProg;
		}
	}*/

}
