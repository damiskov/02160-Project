package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	public Position p;	//the public position is declared here
	public static final String ID = "fire";
	private int spreadCounter = 0;
	
	@Override
	public void performRegisterAction() {
		//robot gets damaged by fire
		if(board.hasRobotAt(calculatePosition())) {
			System.out.println(board.getRobotAt(calculatePosition()) + " got damaged by the fire");
			board.getRobotAt(calculatePosition()).takeDamage();
		}
		
		if(getSpreadCounter() <= 4 ) {
			p = calculatePosition(); //calculates old position
	
			//randomly generates new position for the fire to spread to
			int x_c = p.getX();
			int y_c = p.getY();
			int newX = x_c + (int)(Math.random() * 3) -1;
			int newY = y_c + (int)(Math.random() * 3) -1;
	
			
			p.setX(newX); //the position is initiated here to have the position of the new fire
			p.setY(newY);
	
			board.initialPlacement(new Fire(), p); //places the fire
			
			//sets the spread counter on the new fire so it does not spread
			((Fire) board.getEElementAt(p)).setSpreadCounter(5);
			
			
			//increments spread counter on the original fire
			incrementSpreadCounter();
		}
		

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
