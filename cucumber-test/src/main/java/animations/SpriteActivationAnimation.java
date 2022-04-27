package animations;

import view.Sprite;

public class SpriteActivationAnimation extends Animation {
	
	private Sprite sprite;

	public SpriteActivationAnimation(Sprite sprite) {
		super(0);
		this.sprite = sprite;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		sprite.activate();
	}
	


}
