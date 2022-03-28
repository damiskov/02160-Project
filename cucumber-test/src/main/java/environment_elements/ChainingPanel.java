package environment_elements;

import java.util.Arrays;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class ChainingPanel extends EnvironmentElement implements IRegisterActor{

	private boolean active = true;
	int i;
	private boolean chainableOnBoard = false; //used for noChainable()
	
	public ChainingPanel(int x, int y) {
		super(x, y);
	}
	
	public void chain1(Robot r) {
		r.setChainable(true);
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public boolean noChainable(Robot[] rs) {
		for (i = 0; i <= rs.length; i++); {
			if(rs[i].getChainable() == true) {
				chainableOnBoard = chainableOnBoard || true;
			
			} else {
				chainableOnBoard = chainableOnBoard || false;
			}
		}
		return chainableOnBoard;
	}
	
	
	public void chainRobots(Robot r1, Robot r2) {
		if(r1.getChainable() == true && r2.getChainable() == true) {
			System.out.println(r1 + " has been chained to robot " + r2);
			r1.setChainedTo(r2);
			r2.setChainedTo(r1);
		}
	}
	
	public void unChain(Robot r1, Robot r2) {
		r1.setChainable(false);
		r2.setChainable(false);
		
		r1.setChainedTo(r1); //these two are changed and the robot is chained to itself
		r2.setChainedTo(r2); //it won't pull another robot, but it might cause problems, idk how to wipe the value in the variable
		}
	
	
	@Override
	public void performRegisterAction() {
	}

}
