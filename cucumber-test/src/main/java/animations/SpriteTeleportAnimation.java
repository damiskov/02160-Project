package animations;

import view.Sprite;

// An animation for sprites teleporting from one position to another
public class SpriteTeleportAnimation extends Animation {
	
	private Sprite sprite;
	private int screenNewX;
	private int screenNewY;
	private int orientationDeg;

	public SpriteTeleportAnimation(Sprite sprite, int screenNewX, int screenNewY, int orientationDeg) {
		super(0);
		this.sprite = sprite;
		this.screenNewX = screenNewX;
		this.screenNewY = screenNewY;
		this.orientationDeg = orientationDeg;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		sprite.setX(screenNewX);
		sprite.setY(screenNewY);
		sprite.setRotation(orientationDeg);
	}

}
