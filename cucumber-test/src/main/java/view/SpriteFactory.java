package view;

import java.awt.Image;

import environment_elements.ChainingPanel;
import environment_elements.ConveyorBelt;
import environment_elements.Gear;
import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import utils.ImageUtils;

public class SpriteFactory {

	public static Sprite getFromPiece(Piece piece, int cellSize, BoardPanel canvas) {
		if (piece instanceof EnvironmentElement) {
			EnvironmentElement eElement = (EnvironmentElement) piece;
			int x = eElement.getX()*cellSize;
			int y = eElement.getY()*cellSize;
			
			if (eElement instanceof Gear) {
				Gear gear = (Gear) eElement;
				String filepath = "images/gear" + (gear.isCounterClockwise() ? "_left" : "_right") + ".png";
				return new Sprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			} else if (eElement instanceof ConveyorBelt) {
				ConveyorBelt conveyorBelt = (ConveyorBelt) eElement;
				return new Sprite(ImageUtils.scaledImage("images/conveyor_belt.png", cellSize, cellSize), x, y, conveyorBelt.getOrientation().getDegrees(), canvas);
			} else if (eElement instanceof ChainingPanel){
				Image defaultImage = ImageUtils.scaledImage("images/chaining_panel.png", cellSize, cellSize);
				Image emptyImage = ImageUtils.scaledImage("images/chaining_panel_empty.png", cellSize, cellSize);
				return new ImageToggleSprite(defaultImage, emptyImage, x, y, 0, canvas);
			} else {
				String filepath = "images/" + eElement.getPieceID() + ".png";
				return new Sprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			}
		} else if (piece instanceof Robot) {
			Robot robot = (Robot) piece;
			int x = robot.getX()*cellSize;
			int y = robot.getY()*cellSize;
			
			String filepath = "images/robot" + robot.getRobotNumber() + ".png";
			
			return new Sprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, robot.getOrientation().getDegrees(), canvas);
		} else {
			throw new IllegalArgumentException("Piece must be either a Robot or an EnvironmentElement");
		}
	}
}
