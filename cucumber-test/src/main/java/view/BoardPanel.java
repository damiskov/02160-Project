package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import board.*;
import environment_elements.Laser;
import environment_elements.Pit;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;
import utils.ImageUtils;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 500;
	
	private Image backgroundTile;
	
	private int rows;
	private int cols;
	private int pixelsPerCell;
	private int width;
	private int height;
	private Board board;
	
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
		
		backgroundTile = ImageUtils.scaledImage("images/panel.png", pixelsPerCell, pixelsPerCell);
		
		// temporary, for testing
		//spriteList.add(SpriteFactory.getFromPieceID("arrow", pixelsPerCell, pixelsPerCell, pixelsPerCell, 0, this));
		
		//spriteList.add(SpriteFactory.getFromPieceID("circle", pixelsPerCell, pixelsPerCell*6, pixelsPerCell*4, 0, this));
		//spriteList.add(SpriteFactory.getFromPieceID("arrow", pixelsPerCell, pixelsPerCell*6, pixelsPerCell*4, 0, this));
		
		//spriteList.add(SpriteFactory.getFromPieceID("ConvL", pixelsPerCell, pixelsPerCell*8, pixelsPerCell*8, 90, this));
		//spriteList.add(SpriteFactory.getFromPieceID("ConvS", pixelsPerCell, pixelsPerCell*9, pixelsPerCell*8, 0, this));
		//spriteList.add(SpriteFactory.getFromPieceID("ConvS", pixelsPerCell, pixelsPerCell*8, pixelsPerCell*9, 90, this));
		//spriteList.add(SpriteFactory.getFromPieceID("robot", pixelsPerCell, pixelsPerCell*8, pixelsPerCell*8, 0, this));
		//spriteList.add(SpriteFactory.getFromPieceID("NLaserOn", pixelsPerCell, pixelsPerCell*1, pixelsPerCell*0, 0, this));
		//spriteList.add(SpriteFactory.getFromPieceID("Laser", pixelsPerCell, pixelsPerCell*2, pixelsPerCell*0, 0, this));
		//spriteList.add(SpriteFactory.getFromPieceID("NLaserOn", pixelsPerCell, pixelsPerCell*3, pixelsPerCell*0, 180, this));
		
		//BoardPanel thisBoardPanel = this;
		
		
		//this.board = new Board(10,12);
		
		Robot r = new Robot();
		board.initialPlacement(r, 8, 0);
		r.setOrientation(Orientation.DOWN);
		
		Laser l = new Laser();
		board.initialPlacement(l, 1, 5);
		
		Pit p = new Pit();
		board.initialPlacement(p, 4, 3);
		Pit p1 = new Pit();
		board.initialPlacement(p1, 0, 0);
		Laser p2 = new Laser();
		board.initialPlacement(p2, 0, 9);
		Pit p3 = new Pit();
		board.initialPlacement(p3, 11, 0);
		Laser p4 = new Laser();
		board.initialPlacement(p4, 11, 9);
	
		
		
		
		
		
		System.out.println(r.getOrientation());
		
		
		//ConveyorBelt c = new EnvironmentElement();
		
		//addSprite(r.getPieceID(),r.calculatePosition.getX(),r.calculatePosition.getY())
		//System.out.println(this.cols+ "X" + this.rows);
		for (int i=0; i<this.cols; i++) {
			
			for (int j=0; j<this.rows; j++) {
				//System.out.println(i+ "x" + j);
				if(board.hasEElementAt(new Position(i,j))){
					//System.out.println(i + " " + j);
					addSprite(proxyE(i, j).getPieceID(),i,j, 0);
				}
				else if(board.hasRobotAt(new Position(i,j))){
					//System.out.println(i + " " + j);
					addSprite(proxyR(i, j).getPieceID(),i,j,orientationToDegrees(proxyR(i, j)));
				}
			}
		}
		
	}

	private int orientationToDegrees(Robot r) {
		switch(r.getOrientation()) {
		case UP:
			return 270;
		case RIGHT:
			return 0;
		case DOWN:
			return 90;
		case LEFT:
			return 180;
		}
		return 0;
			
	}	
	
	private EnvironmentElement proxyE(int cols, int rows) {
		//System.out.println(cols + "-" + rows);
		return board.getEElementAt(new Position(cols,rows));
	}
	private Robot proxyR(int cols, int rows) {
		//System.out.println(cols + "_" + rows);
		return board.getRobotAt(new Position(cols,rows));
	}
	
	public void addSprite(String ID, int x, int y, int a) {
		spriteList.add(SpriteFactory.getFromPieceID(ID, pixelsPerCell, pixelsPerCell*x, pixelsPerCell*y, a, this));
		repaint();
		
		//System.out.println("add_action");
	}
	public void removeSprite(String ID, int x, int y) {
		
		//System.out.println("selection_action");
		for (ISprite sprite: spriteList) {
			
			//System.out.println(sprite.getID() + " " +sprite.getX() + " " + sprite.getY() );
			if(sprite.getID().equals(ID) && sprite.getX()==pixelsPerCell*x && sprite.getY()==pixelsPerCell*y) {
				 spriteList.remove(sprite);
				 
				 //System.out.println("remove_action");
				 break;
			}
			
		}
		repaint();
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
	
	@Override
	public int getHeight() {
		return height;
	}
}
