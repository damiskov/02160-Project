package view;

import java.awt.Image;

// A Sprite implementation for sprites that keep the same image for their entire lifetime
public class SingleImageSprite extends Sprite {

	public SingleImageSprite(Image image, int x, int y, int degrees, BoardPanel canvas) {
		super(image, x, y, degrees, canvas);
	}

	// Empty override, since the image does not need to change
	@Override
	public void nextImage() {}

}
