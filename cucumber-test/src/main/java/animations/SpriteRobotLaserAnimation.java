package animations;

import java.util.List;

import board.Position;
import piece_basics.Orientation;
import view.BoardPanel;
import view.ImageToggleSprite;
import view.SpriteFactory;

public class SpriteRobotLaserAnimation extends Animation {
	
	private List<ImageToggleSprite> robotLaserSpriteList;
	private int cellWidth;
	private BoardPanel canvasBP;
	private Position startingPosition;
	private Position finishPosition;
	private Position rollingPosition;
	

	public SpriteRobotLaserAnimation(int durationMs, Position startingPosition, Position finishPosition, BoardPanel canvasBP, List<ImageToggleSprite> robotLaserSpriteList, int cellWidth) {
		super(durationMs);
		this.cellWidth = cellWidth;
		this.startingPosition = startingPosition;
		this.finishPosition = finishPosition;
		this.canvasBP = canvasBP;
		this.rollingPosition = startingPosition;
		this.robotLaserSpriteList = robotLaserSpriteList;
	}

	@Override
	public void initializeAnimation() {
		
		// make list of sprites for the laser
		constructLaserSpriteList(); 
		
		// make them visible
		for(ImageToggleSprite toggleSprite : robotLaserSpriteList) {
			toggleSprite.activate();
		}
	}
	
	@Override
	public void establishNextFrame() {
		
		// display the laser on screen for a while
		
	}

	@Override
	public void finalizeAnimation() {
		// make them invisible
		for(ImageToggleSprite toggleSprite : robotLaserSpriteList) {
			toggleSprite.activate();
		}
		// clear our list
		robotLaserSpriteList.clear();
	}

	private void constructLaserSpriteList() {
		// This method gets fed two positions [Pos1] -> [Pos2] and makes a laser beam between them
		//
		// [laser end at Pos1] [laser mid-section] ... [laser mid-section] [laser end at Pos2]
		//  make laser start          while loop makes mid sections           make laser end
		//
		// There is also a fair bit of logic needed to figure out how to rotate each image so they line up 
		
		//horizontal laser
		if(startingPosition.getY()==finishPosition.getY()) {	
			
			//going right
			if(startingPosition.getX()<finishPosition.getX()) {
				addLaser(Orientation.RIGHT, startingPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
				while (rollingPosition.getX()<finishPosition.getX()-1){
					rollingPosition.incrX(1);
					addLaser(Orientation.RIGHT, rollingPosition, cellWidth, canvasBP, false);
					canvasBP.repaint();
				}
				addLaser(Orientation.LEFT, finishPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
			//going left
			} else {
				addLaser(Orientation.LEFT, startingPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
				while (rollingPosition.getX()>finishPosition.getX()+1){
					rollingPosition.incrX(-1);
					addLaser(Orientation.LEFT, rollingPosition, cellWidth, canvasBP, false);
					canvasBP.repaint();
				}
				addLaser(Orientation.RIGHT, finishPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
			}
			
		//vertical laser
		} else if(startingPosition.getX()==finishPosition.getX()) {
			
			//going up
			if(startingPosition.getY()-finishPosition.getY()<0) {
				addLaser(Orientation.UP, startingPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
				while (rollingPosition.getY()<finishPosition.getY()-1){
					rollingPosition.incrY(1);
					addLaser(Orientation.UP, rollingPosition, cellWidth, canvasBP, false);
					canvasBP.repaint();
				}
				addLaser(Orientation.DOWN, finishPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
			//going down
			} else {
				addLaser(Orientation.DOWN, startingPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
				
				while (rollingPosition.getY()>finishPosition.getY()+1){
					rollingPosition.incrY(-1);
					addLaser(Orientation.DOWN, rollingPosition, cellWidth, canvasBP, false);
					canvasBP.repaint();
				}
				addLaser(Orientation.UP, finishPosition, cellWidth, canvasBP, true);
				canvasBP.repaint();
			}
		}
	}
	
	private void addLaser(Orientation orientation, Position position, int cellWidth, BoardPanel canvasBP, boolean horizontal) {
		robotLaserSpriteList.add(SpriteFactory.getLaserSprite(orientation, position, cellWidth, canvasBP, horizontal));
	}

}
