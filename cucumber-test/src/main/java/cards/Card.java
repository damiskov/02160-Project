package cards;

import board.IBoard;
import piece_basics.IRegisterActor;
import piece_basics.Orientation;

public class Card implements IRegisterActor{
	
	private Orientation orientation;
	
	public Card (IBoard board, int x, int y, Orientation orientation) {
		this.setOrientation(orientation);
	}

	@Override
	public void performRegisterAction() {
		
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
