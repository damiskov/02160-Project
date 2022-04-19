package view;

import utils.ImageUtils;

public class SpriteFactory {

	public static Sprite getFromPieceID(String pieceID, int size, int x, int y, int degrees, int canvasHeight) {
		String filepath = "images/" + pieceID + ".png";
		return new Sprite(ImageUtils.scaledImage(filepath, size, size), x, y, degrees, canvasHeight);
	}
}
