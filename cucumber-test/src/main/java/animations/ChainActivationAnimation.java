package animations;

import java.awt.Color;
//import java.util.ArrayList;
import java.util.List;

import view.ChainPair;
import view.Sprite;
import view.Triplet;

public class ChainActivationAnimation extends Animation {
	
	private boolean process;
	private List<ChainPair<Sprite,Sprite,Color,Color>> chainSpriteList;
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
	

	public ChainActivationAnimation(int durationMs, List<ChainPair<Sprite,Sprite,Color,Color>> chainSpriteList,Sprite robot1, Sprite robot2, boolean process) {
		super(durationMs);
		this.chainSpriteList = chainSpriteList;
		//this.boardPanel = boardPanel;
		this.process = process;
		this.robot1 = robot1;
		this.robot2 = robot2;

	}	
	
	Triplet<Integer> colour = new Triplet<Integer>(1,1,1);

	
	@Override
	public void initializeAnimation() {
		color1final = new Triplet(0,0,0);
		color2final = new Triplet(155,155,155);
		
		color1start = new Triplet(255,255,255);
		color2start = new Triplet(255,255,255);
		
		color1shift = color1final.subtract(color1start);
		color1shift.divide(getNumFrames());
		
		color2shift = color2final.subtract(color2start);
		color2shift.divide(getNumFrames());
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		if(process) {
			System.out.println("adding to chain list");
			chainSpriteList.add(new ChainPair<Sprite,Sprite,Color,Color>(robot1,robot2,color1,color2));
			
		}
	}

	@Override
	public void establishNextFrame() {
		color1start.increment(color1shift);
		color2start.increment(color2shift);
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		for(ChainPair<Sprite,Sprite,Color,Color> spritePair : chainSpriteList) {
			if(spritePair.getL().equals(robot1) || spritePair.getR().equals(robot1) ||
			   spritePair.getL().equals(robot2) || spritePair.getR().equals(robot2)) {
				spritePair.setC1(color1);
				spritePair.setC2(color2);
				break;
			} 
		}
	}

	@Override
	public void finalizeAnimation() {
		
		if(!process) {
			System.out.println("removing from list...");
			for(ChainPair<Sprite,Sprite,Color,Color> spritePair : chainSpriteList) {
				if(spritePair.getL().equals(robot1) || spritePair.getR().equals(robot1) ||
				   spritePair.getL().equals(robot2) || spritePair.getR().equals(robot2)) {
					chainSpriteList.remove(spritePair);
					System.out.println("match found! removing from chain list");
					break;
				} 
			}
			
			
			
		}
				
		/**
		for(chainPair<Sprite,Sprite,Color,Color> spritePair2 : chainSpriteList) {
			if(chainSpriteList!=null) {
				System.out.println(spritePair2.getL());
				System.out.println(spritePair2.getR());
			} else {
				System.out.println("list was empty");
			}
		}
		**/
		
	}
	
	

}
