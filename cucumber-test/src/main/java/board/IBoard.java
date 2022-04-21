package board;

import java.util.List;
import java.util.Map;

import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.PropertyChangeSupport;

public interface IBoard {
	void initialPlacement(Robot r, int x, int y);
	void initialPlacement(Robot r, Position p);
	void initialPlacement(EnvironmentElement e, int x, int y);
	void initialPlacement(EnvironmentElement e, Position p);
	
	Position calculatePosition(Robot r);
	Position calculatePosition(EnvironmentElement e);
	
	void moveRobotFromTo(Position oldPos, Position newPos);
	
	void setPosition(Robot r, Position p);
	
//	void removeRobot(Position p);
	void removeEElement(Position p);
	
	boolean hasRobotAt(Position p);
	boolean hasEElementAt(Position p);
	
	Robot getRobotAt(Position p);
	EnvironmentElement getEElementAt(Position p);
	
	boolean coordinateWithinBounds(Position p);
	boolean coordinateWithinBounds(int x, int y);
	
	Map<String, List<Piece>> getPieceLists();
	PropertyChangeSupport getPropertyChangeSupport();
	
	int getNumRows();
	int getNumColumns();
}
