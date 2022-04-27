package view;

import java.awt.Image;
import board.Position;
import environment_elements.ChainingPanel;
import environment_elements.ConveyorBelt;
import environment_elements.Gear;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
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
	
	public static ImageToggleSprite getLaserSprite(Orientation orientation, Position position, int cellSize, BoardPanel canvas, boolean endCap) {
		int x = position.getX()*cellSize;
		int y = position.getY()*cellSize;
		
		Image defaultImageMid = ImageUtils.scaledImage("images/empty_1.png", cellSize, cellSize);
		Image activeImageMid = ImageUtils.scaledImage("images/laser_mid.png", cellSize, cellSize);
		Image defaultImageEnd = ImageUtils.scaledImage("images/empty_2.png", cellSize, cellSize);
		Image activeImageEnd = ImageUtils.scaledImage("images/laser_end.png", cellSize, cellSize);
		
		
		if(endCap) {
			return new ImageToggleSprite(defaultImageEnd, activeImageEnd, x, y, orientation.getDegrees(), canvas);
		} else {
			return new ImageToggleSprite(defaultImageMid, activeImageMid, x, y, orientation.getDegrees(), canvas);
		}
		
	}
	
	
}
