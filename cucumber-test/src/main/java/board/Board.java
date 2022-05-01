package board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.IPropertyChangeEvent;
import property_changes.PlacementEvent;
import property_changes.RemovalEvent;

public class Board {
	
	// Utility class for Board with public attributes. Encapsulation is still respected as this class is fully encapsulated by the Board class
	private class Cell {
		public Robot robot;
		public EnvironmentElement eElement;
	}

	private Cell[][] matrix;
	private int numColumns;
	private int numRows;
	private Difficulty difficulty;
	private String name;
	// A Map which maps from piece class IDs to lists of all the pieces on the board having that ID
	private Map<String, List<Piece>> pieceLists = new HashMap<>();
	private Game game;
	
	
	public Board(int numColumns, int numRows)
	{
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.matrix = new Cell[numColumns][numRows];
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				matrix[i][j] = new Cell();
			}
		}
	}
	
	
	public Board(int numColumns, int numRows, Game game) {
		this(numColumns, numRows);
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void firePropertyChange(IPropertyChangeEvent event) {
		game.firePropertyChange(event);
	}

	// Utility method for indexing the matrix field using standard cartesian-style coordinate axes instead of matrix-style axes
	private Cell getCell(int x, int y) {
		return matrix[numColumns - y - 1][x];
	}
	// (Overloading to allow for the use of Position type)
	private Cell getCell(Position p) {
		int x = p.getX();
		int y = p.getY();
		return matrix[numColumns - y - 1][x];
	}
	
	
	public void initialPlacement(Robot r, int x, int y) {
		// Exception thrown if robot is placed on top of another robot
		if (hasRobotAt(new Position(x, y))) throw new PieceAlreadyPresentException("Attempted to place a Robot on a cell where one already exists");
		addToPieceLists(r);
		r.setBoard(this);
		System.out.println("Placing robot " + r.getRobotNumber() + " at " + x + ", " + y);
		getCell(x, y).robot = r;
		firePropertyChange(new PlacementEvent(r, new Position(x, y)));
	}
	public void initialPlacement(Robot r, Position p) {
		initialPlacement(r, p.getX(), p.getY());
	}
	
	public void initialPlacement(EnvironmentElement e, int x, int y) {
		if (hasEElementAt(new Position(x, y))) throw new PieceAlreadyPresentException("Attempted to place an EnvironmentElement on a cell where one already exists");

		addToPieceLists(e);
		e.setBoard(this);
		getCell(x, y).eElement = e;
		firePropertyChange(new PlacementEvent(e, new Position(x, y)));
	}
	// Overloading initialPlacement to allow for the use of Position type
	public void initialPlacement(EnvironmentElement e, Position p) {
		initialPlacement(e, p.getX(), p.getY());
	}
	
	private void addToPieceLists(Piece piece) {
		String id = piece.getPieceID();
		// If piece does not exist in pieceLists -> create new ArrayList in pieceList
		pieceLists.computeIfAbsent(id, k -> new ArrayList<Piece>());
		// adding piece to pieceList
		pieceLists.get(id).add(piece);
	}

	public Position calculatePosition(Robot r) {
		if (r == null) throw new NullPointerException("Attempted to find null Robot");
		// Iterating over entire board
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				Robot pr = getCell(i, j).robot;
				// If the desired robot is on current cell
				if (r == pr) {
					// return robot
					return new Position(i, j);
				}
			}
		}
		// Exception thrown if whole board is scanned and robot is not found
		throw new PieceNotFoundException("Could not find Robot");
	}
	
	public Position calculatePosition(EnvironmentElement e) {
		if (e == null) throw new NullPointerException("Attempted to find null EnvironmentElement");
		// Iterating over entire board 
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				EnvironmentElement pe = getCell(i, j).eElement;
				// if current position contains desired element
				if (e == pe) {
					// return current position
					return new Position(i, j);
				}
			}
		}
		throw new PieceNotFoundException("Could not find EnvironmentElement");
	}
	
	public void moveRobotFromTo(Position oldPos, Position newPos) {
		// Checking if old position is equal to new position 
		if (!oldPos.equals(newPos)) {
			// Exception thrown if attempting to move a robot into another robot
			if (hasRobotAt(newPos)) throw new PieceAlreadyPresentException("Attempting to move a robot where another is already present");
			Cell oldCell = getCell(oldPos);
			Robot r = oldCell.robot;
			System.out.println("Moving robot " + r.getRobotNumber() + " from " + oldPos + " to " + newPos);
			// Moving robot to new cell
			getCell(newPos).robot = r;
			// removing robot from old cell
			oldCell.robot = null;
			if (hasEElementAt(newPos)) {
				// If there is some obstacle at the new position, obstacle performs some action on the robot
				getEElementAt(newPos).performImmediateAction(r);
			}
		}
	}
	
	
	public void setPosition(Robot r, Position p) {
		moveRobotFromTo(calculatePosition(r), p);
	}
	

	public boolean hasRobotAt(Position p) {
		return getCell(p).robot != null;
	}

	public boolean hasEElementAt(Position p) {
		return getCell(p).eElement != null;
	}

	public Robot getRobotAt(Position p) {
		Robot ret = getCell(p).robot;
		if (ret == null) throw new NoSuchPieceException("Attempted to get Robot at " + p + " when no Robot exists there");
		return ret;
	}

	public EnvironmentElement getEElementAt(Position p) {
		EnvironmentElement ret = getCell(p).eElement;
		if (ret == null) throw new NoSuchPieceException("Attempted to get EElement at " + p + " when no EElement exists there");
		return ret;
	}
	
	public void removeEElement(Position p) {
		if (!hasEElementAt(p)) throw new NoSuchPieceException("Attempted to remove EElement at " + p + " when no EElement exists there");
		// Accessing environment element on certain cell
		EnvironmentElement eElement = getEElementAt(p);
		// removing environment element from piece lists
		pieceLists.get(eElement.getPieceID()).remove(eElement);
		getCell(p).eElement = null;
		// Sending model change to view 
		firePropertyChange(new RemovalEvent(p));
	}
	
	
	
	public boolean coordinateWithinBounds(int x, int y) {
		return
				0 <= x && x < numColumns
				&& 0 <= y && y < numRows;
	}
	
	
	public boolean coordinateWithinBounds(Position p) {
		int x = p.getX();
		int y = p.getY();
		return coordinateWithinBounds(x, y);
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

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

}
