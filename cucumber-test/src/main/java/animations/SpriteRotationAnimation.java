package animations;

import view.Sprite;

public class SpriteRotationAnimation extends Animation {
	
	private Sprite sprite;
	
	private int diffAngle;
	
	private double angleShift;
	private double smoothAngle;
	private int finalAngle;

	public SpriteRotationAnimation(int durationMs, Sprite sprite, int diffAngle) {
		super(durationMs);
		this.sprite = sprite;
		
		this.diffAngle = diffAngle;
		this.angleShift = (double) diffAngle / getNumFrames();
		
	}

	@Override
	public void initializeAnimation() {
		int startingAngle = sprite.getRotation();
		
		smoothAngle = (double) startingAngle;
		
		finalAngle = startingAngle + diffAngle;

	}

	@Override
	public void establishNextFrame() {
		smoothAngle += angleShift;
		sprite.setRotation((int) smoothAngle);
	}

	@Override
	public void finalizeAnimation() {
		sprite.setRotation(finalAngle);
	}

}
