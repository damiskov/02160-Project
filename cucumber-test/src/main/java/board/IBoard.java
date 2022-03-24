package board;

import environment_elements.EnvironmentElement;
import piece_basics.Robot;

public interface IBoard {
	boolean hasRobotAt(int x, int y);
	Robot getRobotAt(int x, int y);
	
	boolean hasEElementAt(int x, int y);
	EnvironmentElement getEElementAt(int x, int y);
	
	boolean coordinateWithinBounds(int x, int y);
}
