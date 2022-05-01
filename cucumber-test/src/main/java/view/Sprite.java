package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/*
 * Sprites are the visual representations of the pieces (Piece subclasses) in the model. BoardPanel has two lists of these,
 * one for sprites representing Robots and one for sprites representing EnvironmentElements. When BoardPanel is repainted,
 * it iterates through these lists and calls the paintUsing method on each Sprite to tell them to paint themselves on the
 * canvas "using" the graphics object.
 * 
 * Each Sprite contains all the information it needs to display itself graphically on the BoardPanel canvas, i.e. image,
 * x and y coordinates, orientation in degrees, width, and height. It uses an AffineTransform object to perform all the linear
 * algebra transformations needed for this rendering. AffineTransforms were not needed for displaying the sprite at a certain
 * position, but they were needed for rotating it.
 * 
 * This is an abstract class with a single abstract method called nextImage. In connection with this, it has two implementing
 * subclasses: SingleImageSprite for sprites that keep the same image for their entire lifetime, and ImageToggleSprite,
 * which can toggle between two images
 */
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

	// This method updates the affine transform matrix after a change in position or orientation
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

	protected Image getImage() {
		return imageDisplayed;
	}

	protected void setImage(Image image) {
		this.imageDisplayed = image;
	}
	
	public abstract void nextImage();

}