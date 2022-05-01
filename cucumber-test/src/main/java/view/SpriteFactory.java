package view;

import java.awt.Image;
import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;
import environment_elements.ConveyorBelt;
import environment_elements.Gear;
import environment_elements.Teleporter;
import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import utils.ImageUtils;

/*
 * A simple factory class defining a single static method getFromPiece. This method is used by BoardPanel to convert from Pieces
 * from the model into Sprites visually representing those Pieces. The method uses instanceof and downcasting to extract
 * subclass-specific information from Pieces given to it and return corresponding Sprites. ImageToggleSprites are used for
 * ChainingPanels, and SingleImageSprites are used for all other Pieces
 */
public class SpriteFactory {
	
	private SpriteFactory() {}

	public static Sprite getFromPiece(Piece piece, int cellSize, BoardPanel canvas) {
		if (piece instanceof EnvironmentElement) {
			EnvironmentElement eElement = (EnvironmentElement) piece;
			int x = eElement.getX()*cellSize;
			int y = eElement.getY()*cellSize;
			
			if (eElement instanceof Gear) {
				Gear gear = (Gear) eElement;
				String filepath = "/gear" + (gear.isCounterClockwise() ? "_left" : "_right") + ".png";
				return new SingleImageSprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			} else if (eElement instanceof ConveyorBelt) {
				ConveyorBelt conveyorBelt = (ConveyorBelt) eElement;
				return new SingleImageSprite(ImageUtils.scaledImage("/conveyor_belt.png", cellSize, cellSize), x, y, conveyorBelt.getOrientation().getDegrees(), canvas);
			} else if (eElement instanceof ChainingPanel){
				Image defaultImage = ImageUtils.scaledImage("/chaining_panel.png", cellSize, cellSize);
				Image emptyImage = ImageUtils.scaledImage("/chaining_panel_empty.png", cellSize, cellSize);
				return new ImageToggleSprite(defaultImage, emptyImage, x, y, 0, canvas);
			} else if (eElement instanceof Teleporter) {
				Teleporter teleporter = (Teleporter) eElement;
				String filepath = "/teleporter" + (teleporter.isSending() ? "_orange" : "_blue") + ".png";
				return new SingleImageSprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			} else if (eElement instanceof Checkpoint) {
					Checkpoint checkpoint = (Checkpoint) eElement;
					String filepath = "/checkpoint" + checkpoint.getNumber() + ".png";
					return new SingleImageSprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			} else {
				String filepath = "/" + eElement.getPieceID() + ".png";
				return new SingleImageSprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, 0, canvas);
			}
		} else if (piece instanceof Robot) {
			Robot robot = (Robot) piece;
			int x = robot.getX()*cellSize;
			int y = robot.getY()*cellSize;
			
			String filepath = "/robot" + robot.getRobotNumber() + ".png";
			
			return new SingleImageSprite(ImageUtils.scaledImage(filepath, cellSize, cellSize), x, y, robot.getOrientation().getDegrees(), canvas);
		} else {
			throw new IllegalArgumentException("Piece must be either a Robot or an EnvironmentElement");
		}
	}
	
}
