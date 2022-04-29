package animations;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import view.BoardPanel;
import view.BoardPanel.chainPair;
import view.Sprite;

public class ChainActivationAnimation extends Animation {
	
	private boolean process;
	private List<chainPair<Sprite,Sprite,Color,Color>> chainSpriteList;
	private Sprite robot1;
	private Sprite robot2;
	private BoardPanel boardPanel;
	Triplet<Integer> color1RGB;
	Triplet<Integer> color2RGB;
	private Color color1;
	private Color color2;
	

	public ChainActivationAnimation(int durationMs, List<chainPair<Sprite,Sprite,Color,Color>> chainSpriteList,Sprite robot1, Sprite robot2, boolean process, BoardPanel boardPanel) {
		super(durationMs);
		this.chainSpriteList = chainSpriteList;
		this.boardPanel = boardPanel;
		this.process = process;
		this.robot1 = robot1;
		this.robot2 = robot2;

	}
	
	@SuppressWarnings("hiding")
	private static class Triplet<Integer>{
		private int red;
		private int blue;
		private int green;
		public Triplet(int red,int blue,int green) {
			this.red = red;
			this.blue = blue;
			this.green = green;
		}
		public int getRed() { return red; }
		public int getBlue() { return blue; }
		public int getGreen() { return green; }
		
		public void setRed(int red)     { if(regionCheck(red))   { this.red = red; } }
		public void setBlue(int blue)   { if(regionCheck(blue))  { this.blue = blue; } }
		public void setGreen(int green) { if(regionCheck(green)) { this.green = green; } }
		
		public void increment(int i) {
			setRed(this.getRed()+i);
			setBlue(this.getBlue()+i);
			setGreen(this.getGreen()+i);
		}
		
		public boolean regionCheck(int i) {
			if(i<0 || i>255) {
				System.out.println("Triplets only use range [0,255]");
				return false;
			} else {
				return true;
			}
		}
		
	}
	
	
	
	Triplet<Integer> colour = new Triplet<Integer>(1,1,1);

	
	@Override
	public void initializeAnimation() {
		color1RGB = new Triplet(255,255,255);
		color2RGB = new Triplet(255,255,255);
		color1 = new Color(color1RGB.getRed(),color1RGB.getBlue(),color1RGB.getGreen());
		color2 = new Color(color2RGB.getRed(),color2RGB.getBlue(),color2RGB.getGreen());
		
		System.out.println((int) Math.floor((0-255)/getNumFrames()));
		System.out.println((int) Math.floor((155-255)/getNumFrames()));
		
		if(process) {
			System.out.println("adding to chain list");
			chainSpriteList.add(new chainPair<Sprite,Sprite,Color,Color>(robot1,robot2,color1,color2));
			
		}
	}

	@Override
	public void establishNextFrame() {
		color1RGB.increment((int) Math.floor((0-255)/getNumFrames()));
		color2RGB.increment((int) Math.floor((155-255)/getNumFrames()));
		
		color1 = new Color(color1RGB.getRed(),color1RGB.getBlue(),color1RGB.getGreen());
		color2 = new Color(color2RGB.getRed(),color2RGB.getBlue(),color2RGB.getGreen());
		
		for(chainPair<Sprite,Sprite,Color,Color> spritePair : chainSpriteList) {
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
			for(chainPair<Sprite,Sprite,Color,Color> spritePair : chainSpriteList) {
				if(spritePair.getL().equals(robot1) || spritePair.getR().equals(robot1) ||
				   spritePair.getL().equals(robot2) || spritePair.getR().equals(robot2)) {
					chainSpriteList.remove(spritePair);
					System.out.println("match found! removing from chain list");
					break;
				} 
			}
			
			
			System.out.println("removing from list");
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
