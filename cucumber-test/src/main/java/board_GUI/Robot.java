package board_GUI;



import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;



public class Robot {
	int x;
	int y;
	Orientation orientation;
	Image img;
	
	Robot (int i, int j){
		
		x = i;
		y = j;
		
	}
	
	void setImage(Image image) {
		
		img = image;
		
	}
	
	Image getImage() {
		
		return img;
		
	}
	
	void setPosition( int i, int j) {
		
		x = i;
		x = j;
		
	}
	
	
	int getY() {
		return y;
	}
	
	int getX() {
		
		return x;
	}
	
	void setX(int i) {
		
		x = i;
	}

	void setY(int j) {
	
		y = j;
	}
	
	void setOrientation(Orientation o){
		
		orientation = o;
	}
	
	Orientation getOrientation(){
		
		return orientation;
	}
	
	void rotate(String s) {
		
		if (s == "right"){
			switch(orientation) {
			case UP:
				setOrientation(Orientation.RIGHT);
				break;
			case RIGHT:
				setOrientation(Orientation.DOWN);
				break;
			case DOWN:
				setOrientation(Orientation.LEFT);
				break;
			case LEFT:
				setOrientation(Orientation.UP);
				break;
		}
				
		} else if (s == "left") {
			switch(orientation) {
			case UP:
				setOrientation(Orientation.LEFT);
				break;
			case RIGHT:
				setOrientation(Orientation.UP);
				break;
			case DOWN:
				setOrientation(Orientation.RIGHT);
				break;
			case LEFT:
				setOrientation(Orientation.DOWN);
				break;
		}
			
		}
		
	}
	
	void moveForward(){
		
		switch(orientation) {
		case UP:
			setY(getY()  -64);
			break;
		case RIGHT:
			setX(getX() + 64);
			break;
		case DOWN:
			setY(getY() + 64);
			break;
		case LEFT:
			setX(getX() - 64);
			break;
		}
		
	}
	
	void moveBackward(){
		
		switch(orientation) {
		case UP:
			setY(getY() + 64);
			break;
		case RIGHT:
			setX(getX() - 64);
			break;
		case DOWN:
			setY(getY() - 64);
			break;
		case LEFT:
			setX(getX() + 64);
			break;
		}
		
	}
	
	
	
//	public void rotateImage(double degrees, ImageObserver o) {
//		
//		ImageIcon icon = new ImageIcon(this.img);
//		BufferedImage blankCanvas = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2 = (Graphics2D)blankCanvas.getGraphics();
//		g2.rotate(Math.toRadians(degrees), icon.getIconWidth() / 2, icon.getIconHeight());
//		g2.drawImage(this.img, 0, 0, o);
//		
//		
//	}
	
	
	
}
