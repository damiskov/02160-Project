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
	private boolean chainableOnBoard = false; //used for noChainable()
	Robot toChain;

	
	public static final String ID = "chaining_panel";

	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	 
	public boolean noChainable(List<Piece> rs) {
		for (Piece p : rs) { //for Piece p : rs then downcast and add an instanceof check
			if (p instanceof Robot) {
				Robot r = (Robot) p;
				if(r.isChainable() == true) { 
					chainableOnBoard = true;
					toChain = r;
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
		if(noChainable(board.getPieceLists().get(Robot.ID)) == false && isActive() == true) {
		//	board.getRobotAt(getPosition()).setChainable(true);
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


