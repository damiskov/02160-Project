package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import board.Position;

public class CellButton extends JButton {

	private Position position;
	
	
	CellButton(Position p){
		position = p;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public void setPosition(Position p1) {
		position = p1;
	}
	
	
	
}
