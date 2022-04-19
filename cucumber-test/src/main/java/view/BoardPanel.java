package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import utils.ImageUtils;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 600;
	
	private Image backgroundTile;
	
	private int rows;
	private int cols;
	private int pixelsPerCell;
	private int width;
	private int height;
	
	private List<ISprite> spriteList = new ArrayList<>();

	public BoardPanel(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		if (rows >= cols) {
			pixelsPerCell = maxDimension/rows;
		} else {
			pixelsPerCell = maxDimension/cols;
		}
		
		width = cols*pixelsPerCell;
		height = rows*pixelsPerCell;
		
		setPreferredSize(new Dimension(width, height));
		
		backgroundTile = ImageUtils.scaledImage("images/tile.png", pixelsPerCell, pixelsPerCell);
		
		// temporary, for testing
		spriteList.add(SpriteFactory.getFromPieceID("arrow", pixelsPerCell, pixelsPerCell, pixelsPerCell, 0, height));
		spriteList.add(SpriteFactory.getFromPieceID("arrow", pixelsPerCell, pixelsPerCell*2, pixelsPerCell*4, 90, height));
		spriteList.add(SpriteFactory.getFromPieceID("circle", pixelsPerCell, pixelsPerCell*6, pixelsPerCell*4, 0, height));
		spriteList.add(SpriteFactory.getFromPieceID("arrow", pixelsPerCell, pixelsPerCell*6, pixelsPerCell*4, 0, height));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				g2.drawImage(backgroundTile, col*pixelsPerCell, row*pixelsPerCell, null);
			}
		}
		
		for (ISprite sprite: spriteList) {
			sprite.drawUsing(g2);
		}
	}
}
