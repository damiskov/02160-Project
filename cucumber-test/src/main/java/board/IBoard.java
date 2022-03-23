package board;

import piece_basics.Robot;

public interface IBoard {

	Cell index(int x, int y);
	boolean hasRobotAt(int x, int y);
	Robot getRobotAt(int x, int y); 
	
}
