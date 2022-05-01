package animations;

import board.Position;
import view.Sprite;

public class SpriteMovementAnimation extends Animation {
	
	private Sprite sprite;
	private int cellWidth;
	private Position oldPos;
	private Position newPos;
	
	private int screenDiffX;
	private int screenDiffY;
	
	private double screenSmoothX;
	private double screenSmoothY;
	private double screenShiftX;
	private double screenShiftY;

	public SpriteMovementAnimation(int durationMs, Sprite sprite, Position oldPos, Position newPos, int cellWidth) {
		super(durationMs);
		this.sprite = sprite;
		this.oldPos = oldPos;
		this.newPos = newPos;
		this.cellWidth = cellWidth;
	}

	@Override
	public void initializeAnimation() {
		//total distance the sprite has to be moved
		screenDiffX = (newPos.getX()-oldPos.getX())*cellWidth;
		screenDiffY = (newPos.getY()-oldPos.getY())*cellWidth;
		
		screenShiftX = (double) screenDiffX / getNumFrames();
		screenShiftY = (double) screenDiffY / getNumFrames();
		
		//Value we will increment the position by each frame for smooth animation
		screenSmoothX = sprite.getX();
		screenSmoothY = sprite.getY();
	}

	@Override
	public void establishNextFrame() {
		screenSmoothX += screenShiftX;
		screenSmoothY += screenShiftY;
		sprite.setX((int) screenSmoothX);
		sprite.setY((int) screenSmoothY);
	}

	@Override
	public void finalizeAnimation() {
		//set new position of sprite directly coming from position to avoid drifting issues from rounding errors etc
		sprite.setX(newPos.getX()*cellWidth);
		sprite.setY(newPos.getY()*cellWidth);
	}

}
