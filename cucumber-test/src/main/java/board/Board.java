package board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.PlacementEvent;
import property_changes.PropertyChangeSupport;
import property_changes.RemovalEvent;

// utility class for Board with public attributes. Encapsulation is still respected as this class is fully encapsulated by the Board class
class Cell {
	public Robot robot;
	public EnvironmentElement eElement;
}

public class Board implements IBoard {

	private Cell[][] matrix;
	private int numColumns;
	private int numRows;
	private int numObstacles;
	private Difficulty difficulty;
	private String name;
	private Map<String, List<Piece>> pieceLists = new HashMap<>();
	private PropertyChangeSupport propertyChangeSupport;
	
	// initialise an empty board with a set number of columns and rows
	public Board(int numColumns, int numRows) {
		this.matrix = new Cell[numColumns][numRows];
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				matrix[i][j] = new Cell();
			}
		}
		this.numColumns = numColumns;
		this.numRows = numRows;
	}
	
	public Board(int numColumns, int numRows, PropertyChangeSupport propertyChangeSupport) {
		this(numColumns, numRows);
		this.propertyChangeSupport = propertyChangeSupport;
	}
	
	
	@Override
	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

	private Cell getCell(Position p) {
		int x = p.getX();
		int y = p.getY();
		return matrix[numColumns - y - 1][x];
	}
	private Cell getCell(int x, int y) {
		return matrix[numColumns - y - 1][x];
	}
	
	
	
	@Override
	public void initialPlacement(Robot r, int x, int y) {
		addToExecutionLists(r);
		r.setBoard(this);
		System.out.println("Placing robot " + r.getRobotNumber() + " at " + x + ", " + y);
		getCell(x, y).robot = r;
		getPropertyChangeSupport().firePropertyChange(new PlacementEvent(r, new Position(x, y)));
	}
	@Override
	public void initialPlacement(Robot r, Position p) {
		initialPlacement(r, p.getX(), p.getY());
	}
	@Override
	public void initialPlacement(EnvironmentElement e, int x, int y) {
		addToExecutionLists(e);
		e.setBoard(this);
		getCell(x, y).eElement = e;
		getPropertyChangeSupport().firePropertyChange(new PlacementEvent(e, new Position(x, y)));
	}
	@Override
	public void initialPlacement(EnvironmentElement e, Position p) {
		initialPlacement(e, p.getX(), p.getY());
	}
	
	private void addToExecutionLists(Piece piece) {
		if (piece != null)
		{
			String id = piece.getPieceID();
			pieceLists.computeIfAbsent(id, k -> new ArrayList<Piece>());
			pieceLists.get(id).add(piece);
		}
	}

	@Override
	public Position calculatePosition(Robot r) {
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				var pr = getCell(i, j).robot;
				if (r == pr) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}

	@Override
	public Position calculatePosition(EnvironmentElement e) {
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				var pe = getCell(i, j).eElement;
				if (e == pe) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	@Override
	public void moveRobotFromTo(Position oldPos, Position newPos) {
		if (!oldPos.equals(newPos)) {
			Cell oldCell = getCell(oldPos);
			Robot r = oldCell.robot;
			getCell(newPos).robot = r;
			oldCell.robot = null;
			if (hasEElementAt(newPos)) {
				getEElementAt(newPos).performImmediateAction(r);
			}
		}
	}
	
	@Override
	public void setPosition(Robot r, Position p) {
		moveRobotFromTo(calculatePosition(r), p);
	}
	

	@Override
	public boolean hasRobotAt(Position p) {
		return getCell(p).robot != null;
	}

	@Override
	public boolean hasEElementAt(Position p) {
		return getCell(p).eElement != null;
	}

	@Override
	public Robot getRobotAt(Position p) {
		return getCell(p).robot;
	}

	@Override
	public EnvironmentElement getEElementAt(Position p) {
		return getCell(p).eElement;
	}
	
//	@Override
//	public void removeRobot(Position p) {
//		getCell(p).robot = null;
//	}
	
	@Override
	public void removeEElement(Position p) {
		getCell(p).eElement = null;
		getPropertyChangeSupport().firePropertyChange(new RemovalEvent(p));
	}
	
	@Override
	public boolean coordinateWithinBounds(Position p) {
		int x = p.getX();
		int y = p.getY();
		return coordinateWithinBounds(x, y);
	}
	@Override
	public boolean coordinateWithinBounds(int x, int y) {
		return
				0 <= x && x < numColumns
				&& 0 <= y && y < numRows;
	}

	public Map<String, List<Piece>> getPieceLists() {
		return pieceLists;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getNumRows() {
		return numRows;
	}

	@Override
	public int getNumColumns() {
		return numColumns;
	}

}
