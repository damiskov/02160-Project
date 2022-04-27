package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	private Position p;	
	public static final String ID = "fire";
	private int spreadCounter = 0;
	
	//performRegisterAction implements the game functionality of the obstacle
	@Override
	public void performRegisterAction() {
		setP(calculatePosition());
		//if there is a robot on the board, damage it
		if(board.hasRobotAt(getP())) {
			System.out.println(board.getRobotAt(getP()) + " got damaged by the fire");
			board.getRobotAt(getP()).takeDamage();
		}
		
		//if the fire is still in it's spreading phase
		if(getSpreadCounter() <= 4 ) {

			//generate random adjacent position and set it to p
			int x_c = getP().getX();
			int y_c = getP().getY();
			int newX = x_c + (int)(Math.random() * 3) -1;
			int newY = y_c + (int)(Math.random() * 3) -1;
	
			
			getP().setX(newX); 
			getP().setY(newY);
	
			//if the new position does not have an environment element on it
			if(!(board.hasEElementAt(getP()))) {
				Fire newFire = new Fire(); //create new fire, 
				newFire.setSpreadCounter(5); //make the new fire unable to spread
				board.initialPlacement(newFire, getP()); //place the fire
				incrementSpreadCounter(); //increment the spread counter of the old fire
			}

			
		}
		

	}

	//setter and getter for p
	public void setP(Position pos) {
		this.p = pos;
	}
	
	public Position getP() {
		return this.p;
	}
	
	//increments the spread counter
	public void incrementSpreadCounter() {
		spreadCounter ++;
	}

	//setter and getter for spread counter
	public void setSpreadCounter(int spreadCounter) {
		this.spreadCounter = spreadCounter;
	}
	
	public int getSpreadCounter() {
		return this.spreadCounter;
	}

	
	@Override
	public String getPieceID() {
		return ID;
	}

}
