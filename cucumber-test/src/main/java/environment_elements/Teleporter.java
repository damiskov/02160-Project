package environment_elements;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class Teleporter extends EnvironmentElement implements IRegisterActor{

	public void interact(Robot r, Teleporter t ) {
		r.setPosition(t.getPosition());
	}
	
	// needs changing, you need to first check if a robot exists at your position, and then interact with it. Same issue in Laser
//	public void activate(Robot r, Teleporter t) {
//		if(this.getX() == r.getX() && this.getY() == r.getY()) {
//			this.interact(r,t);
//		}
//			
//	}
	
<<<<<<< HEAD
	@Override //Check if it works, not sure if updatePosition is used properly
=======
	@Override
>>>>>>> refs/heads/main
	public void performRegisterAction() {
<<<<<<< HEAD
//		if(board.hasRobotAt(this.getX(), this.getY())) {
//			board.removeRobot(this.getX(), this.getY());
//		}
//		else{
//			board.place(new Robot(this.getX(), this.getY()));
//		}
		if(board.hasRobotAt(this.getX(), this.getY())) {
			board.updatePosition(this.getX(), this.getY(), board.getRobotAt(this.getX(), this.getY()));
		}
=======
		
>>>>>>> refs/heads/main
	}
}
