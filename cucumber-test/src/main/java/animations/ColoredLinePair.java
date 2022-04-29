package animations;

import java.awt.Color;

import view.Sprite;

//Used as pair of sprites and inner+outer colour
public class ColoredLinePair {
	    private Sprite sprite1;
		private Sprite sprite2;
	    private Color innerColor;
	    private Color outerColor;
	    public ColoredLinePair(Sprite sprite1, Sprite sprite2, Color outerColor, Color innerColor){
	        this.sprite1 = sprite1;
	        this.sprite2 = sprite2;
	        this.outerColor = outerColor;
	        this.innerColor = innerColor;
	    }
	    
	    public Sprite getSprite1() { return sprite1; }
		public void setSprite1(Sprite sprite1) { this.sprite1 = sprite1; }
		
		public Sprite getSprite2() { return sprite2; }
		public void setSprite2(Sprite sprite2) { this.sprite2 = sprite2; }
		
		public Color getInnerColor() { return innerColor; }
		public void setInnerColor(Color innerColor) { this.innerColor = innerColor; }
		
		public Color getOuterColor() { return outerColor; }
		public void setOuterColor(Color outerColor) { this.outerColor = outerColor; }
	    
	}
