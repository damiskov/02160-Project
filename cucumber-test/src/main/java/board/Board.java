package board;
import environment_elements.EnvironmentElement;
import piece_basics.Piece;
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

	private Cell index(int x, int y) {
		return matrix[numColumns - y - 1][x];
	}
	
	@Override
	public void placeRobot(Robot r) {
		index(r.getX(), r.getY()).robot = r;
	}
	@Override
	public void placeEElement(EnvironmentElement e) {
		index(e.getX(), e.getY()).eElement = e;
	}
	@Override
	public void updatePiecePosition(int oldXPos, int oldYPos, Piece p) {
		if (p instanceof Robot) {
			var r = (Robot) p;
			index(oldXPos, oldYPos).robot = null;
			index(r.getX(), r.getY()).robot = r;
		} else if (p instanceof EnvironmentElement) {
			var e = (EnvironmentElement) p;
			index(oldXPos, oldYPos).eElement = null;
			index(e.getX(), e.getY()).eElement = e;
		}
	}
	
	@Override
	public boolean hasRobotAt(int x, int y) {
		return index(x, y).robot != null;
	}
	@Override
	public Robot getRobotAt(int x, int y) {
		return index(x, y).robot;
	}
	@Override
	public boolean hasEElementAt(int x, int y) {
		return index(x, y).eElement != null;
	}
	@Override
	public EnvironmentElement getEElementAt(int x, int y) {
		return index(x, y).eElement;
	}
	
	@Override
	public boolean coordinateWithinBounds(int x, int y) {
		return
				0 <= x && x <= numColumns
				&& 0 <= y && y <= numRows;
	}

	

}
