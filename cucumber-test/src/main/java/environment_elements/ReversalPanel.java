package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class ReversalPanel extends EnvironmentElement implements IRegisterActor{

	
	
	public ReversalPanel(int x, int y) {
		super(x, y);
	}

	@Override
	public void performRegisterAction() { //some stuff still needs to be implemented before this can be used
//		if(board.hasRobotAt(this.getX(), this.getY())) {
//			String[] pg = board.getRobotAt(getX(), getY()).Program();
//			for (int i = 0; pg.length; i++) {
//				if (pg[i] == "move1") {
//					pg[i] = "backUp";
//				}
//				else if (pg[i] == "move2") {
//					pg[i] = "backUp2";
//				}
//			}
//		}
	}

}
