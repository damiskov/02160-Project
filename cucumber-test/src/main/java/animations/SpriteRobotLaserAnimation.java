package animations;

import java.awt.Canvas;
import java.util.List;

import board.Position;
import piece_basics.Orientation;
import utils.ImageUtils;
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
		
		
		if(startingPosition.getY()==finishPosition.getY()) {	
			//going right
			if(startingPosition.getX()<finishPosition.getX()) {
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.RIGHT, startingPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
				while (rollingPosition.getX()<finishPosition.getX()-1){
					rollingPosition.incrX(1);
					robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.RIGHT, rollingPosition, cellWidth, canvasBP, false));
					//System.out.println(orientation + " " + p);
					canvasBP.repaint();
				}
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.LEFT, finishPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
			//going left
			} else {
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.LEFT, startingPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
				while (rollingPosition.getX()>finishPosition.getX()+1){
					rollingPosition.incrX(-1);
					robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.LEFT, rollingPosition, cellWidth, canvasBP, false));
					//System.out.println(orientation + " " + p);
					canvasBP.repaint();
				}
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.RIGHT, finishPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
			}
			
		//vertical laser
		} else if(startingPosition.getX()==finishPosition.getX()) {
			//going up
			if(startingPosition.getY()-finishPosition.getY()<0) {
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.UP, startingPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
				while (rollingPosition.getY()<finishPosition.getY()-1){
					rollingPosition.incrY(1);
					robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.UP, rollingPosition, cellWidth, canvasBP, false));
					//System.out.println(orientation + " " + p);
					canvasBP.repaint();
				}
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.DOWN, finishPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
			//going down
			} else {
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.DOWN, startingPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
				while (rollingPosition.getY()>finishPosition.getY()+1){
					rollingPosition.incrY(-1);
					robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.DOWN, rollingPosition, cellWidth, canvasBP, false));
					//System.out.println(orientation + " " + p);
					canvasBP.repaint();
				}
				robotLaserSpriteList.add(SpriteFactory.getLaserSprite(Orientation.UP, finishPosition, cellWidth, canvasBP, true));
				//System.out.println(orientation + " " + p);
				canvasBP.repaint();
			}
		} 
		
		
		for(ImageToggleSprite toggleSprite : robotLaserSpriteList) {
			toggleSprite.activate();
		}
	

	}

	@Override
	public void establishNextFrame() {
		
		//do nothing
		
	}

	@Override
	public void finalizeAnimation() {
		for(ImageToggleSprite toggleSprite : robotLaserSpriteList) {
			toggleSprite.activate();
			
			
		}
		robotLaserSpriteList.clear();
		
	}

}
