package view;

import java.awt.Graphics2D;

public interface ISprite {

	void drawUsing(Graphics2D g2);
	
	String getID();
	
	int getY();
	int getX();
}
