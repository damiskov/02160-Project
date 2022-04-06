package environment_elements;

import java.util.Arrays;
import java.util.List;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import piece_basics.Robot;
import player.Player;
import board.Game;

public class ChainingPanel extends EnvironmentElement implements IRegisterActor{

	private boolean active = true;
	int i;
	private boolean chainableOnBoard = false; //used for noChainable()
	Robot toChain;
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	 
	public boolean noChainable(List<Robot> rs) {
		for (Robot r : rs) {
			if(r.isChainable() == true) {
				chainableOnBoard = true;
				toChain = r;
				break;
			} 
		}
		return chainableOnBoard;
	}
	
	
	public void chainRobots(Robot r1, Robot r2) {
		if(r1.isChainable() == true && r2.isChainable() == true) {
			System.out.println(r1 + " has been chained to robot " + r2);
			r1.setChainedTo(r2);
			r2.setChainedTo(r1);
			r1.setChainable(false);
			r2.setChainable(false);
		}
	}
	
	
	@Override
	public void performRegisterAction() {
		if(noChainable(board.getPieceList.get(Robot.ID)) == false && this.isActive() == true) {
			chainRobots(board.getRobotAt(getPosition()), toChain);
			this.setActive(true);
		}
		else {
			board.getRobotAt(getPosition()).setChainable(true);
			this.setActive(false);
		} 
	}

}


