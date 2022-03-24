package board;

import environment_elements.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;

public interface IBoard {
	void placeRobot(Robot r);
	void placeEElement(EnvironmentElement e);
	void updatePiecePosition(int oldXPos, int oldYPos, Piece p);
	
	boolean hasRobotAt(int x, int y);
	Robot getRobotAt(int x, int y);
	
	boolean hasEElementAt(int x, int y);
	EnvironmentElement getEElementAt(int x, int y);
	
	boolean coordinateWithinBounds(int x, int y);
}
