package animations;

import java.awt.Color;
import java.util.List;

import view.ColoredLinePair;
import view.Sprite;
import view.Triplet;

public class ChainActivationAnimation extends Animation {
	
	private boolean process;
	private List<ColoredLinePair<Sprite,Color>> chainSpriteList;
	private Sprite robot1;
	private Sprite robot2;
	Triplet<Integer> color1start;
	Triplet<Integer> color2start;
	Triplet<Integer> color1final;
	Triplet<Integer> color2final;
	Triplet<Integer> color1shift;
	Triplet<Integer> color2shift;
	private Color color1;
	private Color color2;
	

	public ChainActivationAnimation(int durationMs, List<ColoredLinePair<Sprite,Color>> chainSpriteList,Sprite robot1, Sprite robot2, boolean process) {
		super(durationMs);
		this.chainSpriteList = chainSpriteList;
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
			chainSpriteList.add(new ColoredLinePair<Sprite,Color>(robot1,robot2,color1,color2));
			
		}
	}

	@Override
	public void establishNextFrame() {
		color1start.increment(color1shift);
		color2start.increment(color2shift);
		
		color1 = new Color(color1start.getRed(),color1start.getBlue(),color1start.getGreen());
		color2 = new Color(color2start.getRed(),color2start.getBlue(),color2start.getGreen());
		
		for(ColoredLinePair<Sprite,Color> spritePair : chainSpriteList) {
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
		
		if(!process) {
			System.out.println("removing from list...");
			for(ColoredLinePair<Sprite,Color> spritePair : chainSpriteList) {
				if(spritePair.getSprite1().equals(robot1) || spritePair.getSprite2().equals(robot1) ||
				   spritePair.getSprite1().equals(robot2) || spritePair.getSprite2().equals(robot2)) {
					chainSpriteList.remove(spritePair);
					System.out.println("match found! removing from chain list");
					break;
				} 
			}
		}		
	}
}
