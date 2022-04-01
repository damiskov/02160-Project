package board;

import piece_basics.EnvironmentElement;
import piece_basics.Robot;

public interface IBoard {
	void initialPlacement(Robot r, int x, int y);
	void initialPlacement(Robot r, Position p);
	void initialPlacement(EnvironmentElement e, int x, int y);
	void initialPlacement(EnvironmentElement e, Position p);
	
	Position getPosition(Robot r);
	Position getPosition(EnvironmentElement e);
	void removeRobot(int x, int y);
	
	void moveRobotFromTo(Position oldPos, Position newPos);
	void moveEElementFromTo(Position oldPos, Position newPos);
	void removeEElement(int x, int y);
	
	void setPosition(Robot r, Position p);
	void setPosition(EnvironmentElement e, Position p);
	
	boolean hasRobotAt(Position p);
	boolean hasEElementAt(Position p);
	
	Robot getRobotAt(Position p);
	EnvironmentElement getEElementAt(Position p);
	
	boolean coordinateWithinBounds(Position p);
	boolean coordinateWithinBounds(int x, int y);
}
