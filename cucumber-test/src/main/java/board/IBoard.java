package board;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;

public interface IBoard {
	void initialPlacement(Robot r, int x, int y);
	void initialPlacement(Robot r, Position p);
	void initialPlacement(EnvironmentElement e, int x, int y);
	void initialPlacement(EnvironmentElement e, Position p);
	
	Position calculatePosition(Robot r);
	Position calculatePosition(EnvironmentElement e);
	
	void moveRobotFromTo(Position oldPos, Position newPos);
	void moveEElementFromTo(Position oldPos, Position newPos);
	
	void setPosition(Robot r, Position p);
	void setPosition(EnvironmentElement e, Position p);
	
	void removeRobot(Position p);
	void removeEElement(Position p);
	
	boolean hasRobotAt(Position p);
	boolean hasEElementAt(Position p);
	
	Robot getRobotAt(Position p);
	EnvironmentElement getEElementAt(Position p);
	
	boolean coordinateWithinBounds(Position p);
	boolean coordinateWithinBounds(int x, int y);
}
