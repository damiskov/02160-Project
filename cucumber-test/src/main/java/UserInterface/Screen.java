package UserInterface;

import board.Board;

public interface Screen {
	
	Object output();

	void update(Board board);

	void setOutput(String string);

	void displayObstacles();

	void displayRobots();

	void displayRobotMarkers();

	void displayRobotHealth();

	void showCurrPlayerHand();

	void showCurrPlayerNumber();

}
