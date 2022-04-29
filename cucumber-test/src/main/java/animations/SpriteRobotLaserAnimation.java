package animations;

import java.awt.Color;
//import java.util.ArrayList;
import java.util.List;

import view.ChainPair;
import view.Sprite;
import view.Triplet;

public class SpriteRobotLaserAnimation extends Animation {
	
	private List<ChainPair<Sprite,Sprite,Color,Color>> laserSpriteList;
	private Sprite robot1;
	private Sprite robot2;
	//private BoardPanel boardPanel;
	Triplet<Integer> color1start;
	Triplet<Integer> color2start;
	Triplet<Integer> color1final;
	Triplet<Integer> color2final;
	Triplet<Integer> color1shift;
	Triplet<Integer> color2shift;
	private Color color1;
	private Color color2;
	

	public SpriteRobotLaserAnimation(int durationMs, List<ChainPair<Sprite,Sprite,Color,Color>> laserSpriteList,Sprite robot1, Sprite robot2) {
		super(durationMs);
		this.laserSpriteList = laserSpriteList;
		//this.boardPanel = boardPanel;
		this.robot1 = robot1;
		this.robot2 = robot2;

	}
	
	// Might be needed for use with colors that have range, but for now its not used
			/**
			public void incR(int i) { setRed(this.getRed()+i); }
			public void incG(int i) { setGreen(this.getGreen()+i); }
			public void incB(int i) { setBlue(this.getBlue()+i); }
			
			public void increment(int i) {
				setRed(this.getRed()+i);
				setBlue(this.getBlue()+i);
				setGreen(this.getGreen()+i);
			}
			
			public boolean regionCheck(int i) {
				if(i<0 || i>255) {
					System.out.println("Triplets for color only use range [0,255]");
					return false;
				} else {
					return true;
				}
			}
			**/
	
	
	
	Triplet<Integer> colour = new Triplet<Integer>(1,1,1);

	
	
	@Override
	public void initializeAnimation() {
		color2final = new Triplet(195,59,59);
		color1final = new Triplet(152,32,32);
		
		color2start = new Triplet(255,140,120);
		color1start = new Triplet(255,140,120);
		
		color1shift = color1final.subtract(color1start);
		color1shift.divide(getNumFrames());
		
		color2shift = color2final.subtract(color2start);
		color2shift.divide(getNumFrames());
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		System.out.println("adding to laser list");
		laserSpriteList.add(new ChainPair<Sprite,Sprite,Color,Color>(robot1,robot2,color1,color2));
		
	}

	@Override
	public void establishNextFrame() {
		
		color1start.increment(color1shift);
		color2start.increment(color2shift);
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		for(ChainPair<Sprite,Sprite,Color,Color> spritePair : laserSpriteList) {
			if(spritePair.getL().equals(robot1) || spritePair.getR().equals(robot1) ||
			   spritePair.getL().equals(robot2) || spritePair.getR().equals(robot2)) {
				spritePair.setC1(color1);
				spritePair.setC2(color2);
				break;
			} 
		}
		
		/**
 		int incRed = (int) Math.floor((0-255)/getNumFrames());
		color1start.incR((int) Math.floor((color1final.getRed()-color1start.getRed())/getNumFrames()));
		color1start.incG((int) Math.floor((color1final.getGreen()-color1start.getGreen())/getNumFrames()));
		color1start.incB((int) Math.floor((color1final.getBlue()-color1start.getBlue())/getNumFrames()));
		
		color2start.incR((int) Math.floor((color2final.getRed()-color2start.getRed())/getNumFrames()));
		color2start.incG((int) Math.floor((color2final.getGreen()-color2start.getGreen())/getNumFrames()));
		color2start.incB((int) Math.floor((color2final.getBlue()-color2start.getBlue())/getNumFrames()));
		
		color2RGB.increment((int) Math.floor((0-255)/getNumFrames()));
		**/
	}

	@Override
	public void finalizeAnimation() {
		
		for(ChainPair<Sprite,Sprite,Color,Color> spritePair : laserSpriteList) {
			if(spritePair.getL().equals(robot1) || spritePair.getR().equals(robot1) ||
			   spritePair.getL().equals(robot2) || spritePair.getR().equals(robot2)) {
				laserSpriteList.remove(spritePair);
				System.out.println("match found! removing from laser list");
				break;
			} 
		}
		
		for(ChainPair<Sprite,Sprite,Color,Color> spritePair2 : laserSpriteList) {
			if(laserSpriteList!=null) {
				System.out.println(spritePair2.getL());
				System.out.println(spritePair2.getR());
			} else {
				System.out.println("laser list was empty");
			}
		}
	}
	
}



