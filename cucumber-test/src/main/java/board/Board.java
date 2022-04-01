package board;
import environment_elements.EnvironmentElement;
import piece_basics.Robot;

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
	
	// initialize an empty board with a set number of columns and rows
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
	
	// probably not a good idea to have this, only for compatibility with StepsDefinitionBoardGeneration
	public Board() {}
	
	public void setNumberOfObstacles(int n) {
		
		this.numObstacles = n;
		
	}
	
	public int getNumberObstacles() {
		
		return numObstacles;
		
	}
	
	public void setMatrix(Cell[][] m) {
		this.matrix = m;
		this.numRows = matrix.length;
		this.numColumns = matrix[0].length;
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
		r.setBoard(this);
		getCell(x, y).robot = r;
	}
	@Override
	public void initialPlacement(Robot r, Position p) {
		initialPlacement(r, p.getX(), p.getY());
	}
	@Override
	public void initialPlacement(EnvironmentElement e, int x, int y) {
		e.setBoard(this);
		getCell(x, y).eElement = e;
	}
	@Override
	public void initialPlacement(EnvironmentElement e, Position p) {
		initialPlacement(e, p.getX(), p.getY());
	}

	@Override
	public Position getPosition(Robot r) {
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
	public Position getPosition(EnvironmentElement e) {
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
		Cell oldCell = getCell(oldPos);
		getCell(newPos).robot = oldCell.robot;
		oldCell.robot = null;
	}
	
	public void moveEElementFromTo(Position oldPos, Position newPos) {
		Cell oldCell = getCell(oldPos);
		getCell(newPos).eElement = oldCell.eElement;
		oldCell.eElement = null;
	}
	
	@Override
	public void setPosition(Robot r, Position p) {
		moveRobotFromTo(getPosition(r), p);
	}

	@Override
	public void setPosition(EnvironmentElement e, Position p) {
		moveEElementFromTo(getPosition(e), p);
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

	public void removeEElement(int x, int y) {
		getCell(x, y).eElement = null;
	}
	
	@Override
	public void removeRobot(int x, int y) {
		getCell(x, y).robot = null;
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
				0 <= x && x <= numColumns
				&& 0 <= y && y <= numRows;
	}

}
