package animations;

import view.Sprite;

// An animation for calling nextImage on an ImageToggleSprite. Used for visualizing ChainingPanel activation
public class SpriteImageChangeAnimation extends Animation {
	
	private Sprite sprite;

	public SpriteImageChangeAnimation(Sprite sprite) {
		super(0);
		this.sprite = sprite;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		sprite.nextImage();
	}
	


}
