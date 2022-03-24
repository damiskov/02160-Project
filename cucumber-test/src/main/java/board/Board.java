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
	public void setNumberOfObstacles(int n) {
		
		this.numObstacles = n;
		
	}
	public void setMatrix(Cell[][] m) {
		this.matrix = m;
		this.numRows = matrix.length;
		this.numColumns = matrix[0].length;
	}
	@Override
	public Cell index(int x, int y) {
		return matrix[numColumns - y - 1][x];
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
