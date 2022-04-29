package environment_elements;

import java.util.List;

import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.ChainingPanelActivationEvent;

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
		if (this.active != active) {
			firePropertyChange(new ChainingPanelActivationEvent(calculatePosition()));
		}
		this.active = active;
	}

	/*checks for chainable robots on the board, needed to know if the robot needs 
	to get chained to another one*/
	public boolean chainableRobots(List<Piece> rs) {
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
	
	//chains two robots together
	public void chainRobots(Robot r1, Robot r2) {
		if(r1.isChainable() && r2.isChainable()) {
			System.out.println(r1 + " is chained to " + r2);
			r1.setChainedTo(r2);
			r2.setChainedTo(r1);
			r1.setChainable(false);
			r2.setChainable(false);
		}
	}
	
	
	@Override
	public void performRegisterAction() {
		if (board.hasRobotAt(calculatePosition())) { 
			if(chainableRobots(board.getPieceLists().get(Robot.ID)) && isActive() && //if there are chainable robots on the board
				!(board.getRobotAt(calculatePosition()).isChainable())) { //and the robot is not chainbale, and is on an active panel
				
				//makes the robot chainable, chain the two robots, reactivate first chaining panel
				board.getRobotAt(calculatePosition()).setChainable(true);
				chainRobots(board.getRobotAt(calculatePosition()), toChain);
				toChain.getChainedFrom().setActive(true);
				
				
			}
			//if a not chainable robot steps on an active chaining panel
			else if (isActive() == true && board.getRobotAt(calculatePosition()).isChainable() == false){
				board.getRobotAt(calculatePosition()).setChainable(true); //make the robot chainable
				board.getRobotAt(calculatePosition()).setChainedFrom(this); //make the robot remember which panel it stepped on
				setActive(false); //inactivate the panel
			} 
		}
	}

	@Override
	public String getPieceID() {
		return ID;
	}

}


