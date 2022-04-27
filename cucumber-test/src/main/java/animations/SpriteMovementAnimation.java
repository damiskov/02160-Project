package animations;

import view.Sprite;

public class SpriteMovementAnimation extends Animation {
	
	private Sprite sprite;
	
	private int screenDiffX;
	private int screenDiffY;
	
	private double screenSmoothX;
	private double screenSmoothY;
	private double screenShiftX;
	private double screenShiftY;
	private int screenFinalX;
	private int screenFinalY;

	public SpriteMovementAnimation(int durationMs, Sprite sprite, int screenDiffX, int screenDiffY) {
		super(durationMs);
		this.sprite = sprite;
		
		this.screenDiffX = screenDiffX;
		this.screenDiffY = screenDiffY;
		this.screenShiftX = (double) screenDiffX / getNumFrames();
		this.screenShiftY = (double) screenDiffY / getNumFrames();
	}

	@Override
	public void initializeAnimation() {
		int screenX = sprite.getX();
		int screenY = sprite.getY();
		
		screenSmoothX = (double) screenX;
		screenSmoothY = (double) screenY;
		
		screenFinalX = screenX + screenDiffX;
		screenFinalY = screenY + screenDiffY;
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
		sprite.setX(screenFinalX);
		sprite.setY(screenFinalY);
	}

}
