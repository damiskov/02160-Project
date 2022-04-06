package UserInterface;

import board.Board;

public interface Screen {
	

	void update(Board board);
	
	Object output();

	void setOutput(String string);

	void displayObstacles();

	void displayRobots();

	void displayRobotMarkers();

	void displayRobotHealth();

	void showCurrPlayerHand();

	void showCurrPlayerNumber();

	


}
