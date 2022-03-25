package environment_elements;

import java.util.Arrays;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class Chaining_Panel extends EnvironmentElement implements IRegisterActor{

	public boolean active = true;
	
	public Chaining_Panel(IBoard board, int x, int y) {
		super(board, x, y);
	}
	
	public void chain1(Robot r) {
		r.chainable = true;
	}
	
	public void inactivate() {
		active = false;
	}
	
	public void activate() {
		active = true;
	}

	public boolean noChainable(Robot[] rs) {
		if(Arrays.asList(rs).contains(true)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void chainRobots(Robot r1, Robot r2) {
		if(r1.chainable == true && r2.chainable == true) {
			System.out.println(r1 + " has been chained to robot " + r2);
			r1.chainedTo = r2;
			r2.chainedTo = r1;
		}
	}
	
	public void unChain(Robot r1, Robot r2) {
		r1.chainable = false;
		r2.chainable = false;
		
		r1.chainedTo = r1; //these two are changed and the robot is chained to itself
		r2.chainedTo = r2; //it won't pull another robot, but it might cause problems, idk how to wipe the value in the variable
		}
	
	
	@Override
	public void performRegisterAction() {
	}

}
