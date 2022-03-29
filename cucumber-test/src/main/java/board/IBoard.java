package board;

import environment_elements.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;

public interface IBoard {
	void place(Robot r);
	void place(EnvironmentElement e);
	void updatePosition(int oldXPos, int oldYPos, Piece p);
	
	boolean hasRobotAt(int x, int y);
	Robot getRobotAt(int x, int y);
	
	boolean hasEElementAt(int x, int y);
	EnvironmentElement getEElementAt(int x, int y);
	
	boolean coordinateWithinBounds(int x, int y);
}
