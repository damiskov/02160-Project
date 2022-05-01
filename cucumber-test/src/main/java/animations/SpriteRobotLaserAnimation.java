package animations;

import java.awt.Color;
import java.util.List;

import view.Sprite;

public class SpriteRobotLaserAnimation extends Animation {
	
	private List<ColoredLinePair> laserSpriteList;
	private Sprite robot1;
	private Sprite robot2;
	Triplet color1start;
	Triplet color2start;
	Triplet color1final;
	Triplet color2final;
	Triplet color1shift;
	Triplet color2shift;
	private Color color1;
	private Color color2;

	public SpriteRobotLaserAnimation(int durationMs, List<ColoredLinePair> laserSpriteList,Sprite robot1, Sprite robot2) {
		super(durationMs);
		this.laserSpriteList = laserSpriteList;
		this.robot1 = robot1;
		this.robot2 = robot2;

	}
	
	@Override
	public void initializeAnimation() {
		
		//set up starting and final colors of the lines drawing the laser
		color2final = new Triplet(195,59,59);
		color1final = new Triplet(152,32,32);
		
		color2start = new Triplet(255,140,120);
		color1start = new Triplet(255,140,120);
		
		//this is the steps of how much the color changes each frame of the animation
		color1shift = color1final.subtract(color1start);
		color1shift.divide(getNumFrames());
		
		color2shift = color2final.subtract(color2start);
		color2shift.divide(getNumFrames());
		
		//this is the actual used color, which gets changed during animation
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		System.out.println("adding to laser list");
		laserSpriteList.add(new ColoredLinePair(robot1,robot2,color1,color2));
	}

	@Override
	public void establishNextFrame() {
		
		color1start.increment(color1shift);
		color2start.increment(color2shift);
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		//find our laser sprites and change only them
		for(ColoredLinePair spritePair : laserSpriteList) {
			if(spritePair.getSprite1().equals(robot1) || spritePair.getSprite2().equals(robot1) ||
			   spritePair.getSprite1().equals(robot2) || spritePair.getSprite2().equals(robot2)) {
				spritePair.setOuterColor(color1);
				spritePair.setInnerColor(color2);
				break;
			} 
		}
	}

	@Override
	public void finalizeAnimation() {
		
		//delete our laser sprite after the animation is done
		for(ColoredLinePair spritePair : laserSpriteList) {
			if(spritePair.getSprite1().equals(robot1) || spritePair.getSprite2().equals(robot1) ||
			   spritePair.getSprite1().equals(robot2) || spritePair.getSprite2().equals(robot2)) {
				laserSpriteList.remove(spritePair);
				System.out.println("match found! removing from laser list");
				break;
			} 
		}
	}
}