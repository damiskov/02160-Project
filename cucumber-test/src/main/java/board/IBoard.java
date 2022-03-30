package board;

import environment_elements.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;

public interface IBoard {
	void place(Robot r, int x, int y);
	void place(EnvironmentElement e, int x, int y);
	
	Position getPosition(Robot r);
	Position getPosition(EnvironmentElement e);
	
	void moveRobotFromTo(Position oldPos, Position newPos);
	void moveEElementFromTo(Position oldPos, Position newPos);
	
	void setPosition(Robot r, Position p);
	void setPosition(EnvironmentElement e, Position p);
	
	boolean hasRobotAt(Position p);
	boolean hasEElementAt(Position p);
	
	Robot getRobotAt(Position p);
	EnvironmentElement getEElementAt(Position p);
	
	boolean coordinateWithinBounds(Position p);
}
