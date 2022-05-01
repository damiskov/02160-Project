package animations;

import piece_basics.Orientation;
import view.Sprite;

// An animation for smooth sprite rotation
public class SpriteRotationAnimation extends Animation {
	
	private Sprite sprite;
	
	private int diffAngle;
	private Orientation oldOrientation;
	private Orientation newOrientation;
	private double angleShift;
	private double smoothAngle;
	private int degOld;
	private int degNew;

	public SpriteRotationAnimation(int durationMs, Sprite sprite, Orientation oldOrientation, Orientation newOrientation) {
		super(durationMs);
		this.sprite = sprite;
		this.oldOrientation = oldOrientation;
		this.newOrientation = newOrientation;
		
		
	}

	@Override
	public void initializeAnimation() {
		degOld = oldOrientation.getDegrees();
		degNew = newOrientation.getDegrees();
		
		if(((degOld < degNew) || ((degNew==0) && (degOld==270))) && !(degOld == 0 && degNew == 270)) {
			diffAngle = 90;
		} else {
			diffAngle = -90;
		}
		
		angleShift = diffAngle / getNumFrames();
		smoothAngle = degOld;

	}

	@Override
	public void establishNextFrame() {
		smoothAngle += angleShift;
		sprite.setRotation((int) smoothAngle);
	}

	@Override
	public void finalizeAnimation() {
		sprite.setRotation(degNew);
	}

}
