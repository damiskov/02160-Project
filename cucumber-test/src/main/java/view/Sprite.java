package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public abstract class Sprite {

	private int x;
	private int y;
	private int degrees;
	
	private Image imageDisplayed;
	private int width;
	private int height;
	
	private AffineTransform affineTransform = new AffineTransform();
	private BoardPanel canvas;

	public Sprite(Image image, int x, int y, int degrees, BoardPanel canvas) {
		this.imageDisplayed = image;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.canvas = canvas;
		
		setX(x);
		setY(y);
		setRotation(degrees);
	}

	private void updateAffineTransform() {
		affineTransform.setToTranslation(x, canvas.getHeight() - y - height);
		affineTransform.rotate((Math.PI/180)*degrees, width/2, height/2);
	
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		updateAffineTransform();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		updateAffineTransform();
	}

	public int getRotation() {
		return degrees;
	}

	public void setRotation(int degrees) {
		this.degrees = degrees;
		updateAffineTransform();
	}

	public void drawUsing(Graphics2D g2) {
		g2.drawImage(imageDisplayed, affineTransform, null);
	}

	public Image getImage() {
		return imageDisplayed;
	}

	public void setImage(Image image) {
		this.imageDisplayed = image;
	}
	
	public abstract void nextImage();

}