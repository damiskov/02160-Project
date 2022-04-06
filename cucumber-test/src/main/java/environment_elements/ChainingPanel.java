package environment_elements;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;
import player.Player;

public class ChainingPanel extends EnvironmentElement {

	private boolean active = true;
	int i;
	private boolean chainableOnBoard = false; //used for noChainable()
	
	public static final String ID = "conveyor_belt";
	
	public void chain1(Robot r) {
		r.setChainable(true);
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public boolean noChainable(Player[] rs) {
		for (i = 0; i <= rs.length; i++); {
			if(rs[i].getRobot().isChainable() == true) {
				chainableOnBoard = chainableOnBoard || true;
			
			} else {
				chainableOnBoard = chainableOnBoard || false;
			}
		}
		return chainableOnBoard;
	}
	
	
	public void chainRobots(Robot r1, Robot r2) {
		if(r1.isChainable() == true && r2.isChainable() == true) {
			System.out.println(r1 + " has been chained to robot " + r2);
			r1.setChainedTo(r2);
			r2.setChainedTo(r1);
		}
	}
	
	public void unChain(Robot r1, Robot r2) {
		r1.setChainable(false);
		r2.setChainable(false);
		
		r1.setChainedTo(null); 
		r2.setChainedTo(null); 
		}
	
	
	@Override
	public void performRegisterAction() {
//		if(noChainable() == false) {
//			board.getRobotAt(getPosition()).setChainable(true);
//		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}


