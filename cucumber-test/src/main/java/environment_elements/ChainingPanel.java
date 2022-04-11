package environment_elements;

import java.util.Arrays;
import java.util.List;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import player.Player;

public class ChainingPanel extends EnvironmentElement {

	private boolean active = true;
	int i;
	private boolean chainableOnBoard; 
	public Robot toChain;

	
	public static final String ID = "chaining_panel";

	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	 
	public boolean noChainable(List<Piece> rs) {
		chainableOnBoard = false;
		for (Piece p : rs) { 
			if (p instanceof Robot) {
				Robot r = (Robot) p;
				if(r.isChainable() == true) { 
					chainableOnBoard = true;
					this.toChain = r;
					break;
				} 
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
		if(noChainable(board.getPieceLists().get(Robot.ID)) == false && isActive() == true &&
			board.getRobotAt(getPosition()).isChainable()) {
		//	board.getRobotAt(getPosition()).setChainable(true);
		//	noChainable(board.getPieceLists().get(Robot.ID));
		//	toChain = getChainableRobot(board.getPieceLists().get(Robot.ID));
			noChainable(board.getPieceLists().get(Robot.ID));
			System.out.println(this.toChain);
			chainRobots(board.getRobotAt(getPosition()), toChain);
			setActive(true);
		}
		else {
			board.getRobotAt(getPosition()).setChainable(true);
			setActive(false);
		} 
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}


