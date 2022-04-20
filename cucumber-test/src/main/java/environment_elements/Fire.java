package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	private Position p;	//the public position is declared here
	public static final String ID = "fire";
	private int spreadCounter = 0;
	
	@Override
	public void performRegisterAction() {
		setPosition(calculatePosition());
		//robot gets damaged by fire
		if(board.hasRobotAt(getPosition())) {
			System.out.println(board.getRobotAt(getPosition()) + " got damaged by the fire");
			board.getRobotAt(getPosition()).takeDamage();
		}
		
		if(getSpreadCounter() <= 4 ) {
			//p = calculatePosition(); //calculates old position
	
			//randomly generates new position for the fire to spread to
			int x_c = getPosition().getX();
			int y_c = getPosition().getY();
			int newX = x_c + (int)(Math.random() * 3) -1;
			int newY = y_c + (int)(Math.random() * 3) -1;
	
			
			getPosition().setX(newX); //the position is initiated here to have the position of the new fire
			getPosition().setY(newY);
	
			board.initialPlacement(new Fire(), getPosition()); //places the fire
			
			//sets the spread counter on the new fire so it does not spread
			((Fire) board.getEElementAt(getPosition())).setSpreadCounter(5);
			
			
			//increments spread counter on the original fire
			incrementSpreadCounter();
		}
		

	}

	public void setPosition(Position pos) {
		this.p = pos;
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public void incrementSpreadCounter() {
		spreadCounter ++;
	}

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
