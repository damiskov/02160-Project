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
	
// utility class for Board with public attributes. Encapsulation is still respected as this class is fully encapsulated by the Board class
	private class Cell {
		public Robot robot;
		public EnvironmentElement eElement;
	}

	private Cell[][] matrix;
	private int numColumns;
	private int numRows;
	private Difficulty difficulty;
	private String name;
	private Map<String, List<Piece>> pieceLists = new HashMap<>();
	private Game game;
	
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
	
	public Board(int numColumns, int numRows, Game game) {
		this(numColumns, numRows);
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void firePropertyChange(IPropertyChangeEvent event) {
		if (game != null) game.firePropertyChange(event);
	}

	private Cell getCell(Position p) {
		int x = p.getX();
		int y = p.getY();
		return matrix[numColumns - y - 1][x];
	}
	
	private Cell getCell(int x, int y) {
		return matrix[numColumns - y - 1][x];
	}
	
	
	
	public void initialPlacement(Robot r, int x, int y) {
		if (hasRobotAt(new Position(x, y))) throw new PieceAlreadyPresentException("Attempted to place a Robot on a cell where one already exists");
		addToExecutionLists(r);
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


		addToExecutionLists(e);
		e.setBoard(this);
		getCell(x, y).eElement = e;

		firePropertyChange(new PlacementEvent(e, new Position(x, y)));


	}
	public void initialPlacement(EnvironmentElement e, Position p) {
		initialPlacement(e, p.getX(), p.getY());
	}
	
	private void addToExecutionLists(Piece piece) {
		String id = piece.getPieceID();
		pieceLists.computeIfAbsent(id, k -> new ArrayList<Piece>());
		pieceLists.get(id).add(piece);
	}

	public Position calculatePosition(Robot r) {
		if (r == null) throw new NullPointerException("Attempted to find null Robot");
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				Robot pr = getCell(i, j).robot;
				if (r == pr) {
					return new Position(i, j);
				}
			}
		}
		throw new PieceNotFoundException("Could not find Robot");
	}

	public Position calculatePosition(EnvironmentElement e) {
		if (e == null) throw new NullPointerException("Attempted to find null EnvironmentElement");
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < numRows; j++) {
				EnvironmentElement pe = getCell(i, j).eElement;
				if (e == pe) {
					return new Position(i, j);
				}
			}
		}
		throw new PieceNotFoundException("Could not find EnvironmentElement");
	}
	
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
	
	public void setPosition(Robot r, Position p) {
		moveRobotFromTo(calculatePosition(r), p);
	}
	

	public boolean hasRobotAt(Position p) {
		return getCell(p).robot != null;
	}

	public boolean hasEElementAt(Position p) {
		System.out.println("checking for eelement at " + p);
		return getCell(p).eElement != null;
	}

	public Robot getRobotAt(Position p) {
		return getCell(p).robot;
	}

	public EnvironmentElement getEElementAt(Position p) {
		return getCell(p).eElement;
	}
	
	public void removeEElement(Position p) {
		if (!hasEElementAt(p)) throw new NoSuchElementException("Attempted to remove EElement at " + p + " when no such element exists");
		EnvironmentElement eElement = getEElementAt(p);
		pieceLists.get(eElement.getPieceID()).remove(eElement);
		getCell(p).eElement = null;
		firePropertyChange(new RemovalEvent(p));
	}
	
	public boolean coordinateWithinBounds(Position p) {
		int x = p.getX();
		int y = p.getY();
		return coordinateWithinBounds(x, y);
	}
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

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

}
