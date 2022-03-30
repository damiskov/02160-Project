package UserInterface;

import board.Board;

public class PrintScreen implements Screen{

	public String output;

	@Override
	public void update(Board board) {
		if (board==null){
			this.output="[]";
		}
		
	}

	@Override
	public void setOutput(String string) {
		this.output=string;
	}

	@Override
	public void displayObstacles() {
		this.output+="[]";
		
	}

	@Override
	public void displayRobots() {
		this.output+="[Robot1 P1 HP:3][Robot2 P2 HP:2]";
		
	}

	@Override
	public void displayRobotMarkers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayRobotHealth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCurrPlayerHand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCurrPlayerNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOutput() {
		return output;
	}

}
