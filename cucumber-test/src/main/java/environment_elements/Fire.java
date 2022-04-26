package environment_elements;

import board.Position;
import piece_basics.EnvironmentElement;

public class Fire extends EnvironmentElement{
	private Position p;	
	public static final String ID = "fire";
	private int spreadCounter = 0;
	
	@Override
	public void performRegisterAction() {
		setP(calculatePosition());
		if(board.hasRobotAt(getP())) {
			System.out.println(board.getRobotAt(getP()) + " got damaged by the fire");
			board.getRobotAt(getP()).takeDamage();
		}
		
		if(getSpreadCounter() <= 4 ) {

			int x_c = getP().getX();
			int y_c = getP().getY();
			int newX = x_c + (int)(Math.random() * 3) -1;
			int newY = y_c + (int)(Math.random() * 3) -1;
	
			
			getP().setX(newX); 
			getP().setY(newY);
	
			if(!(board.hasEElementAt(getP()))) {
				Fire newFire = new Fire();
				newFire.setSpreadCounter(5);
				board.initialPlacement(newFire, getP());
				incrementSpreadCounter();
			}

			
		}
		

	}

	public void setP(Position pos) {
		this.p = pos;
	}
	
	public Position getP() {
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
