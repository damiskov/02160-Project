package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import board.*;
import environment_elements.Laser;
import environment_elements.Pit;
import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.PropertyChangeEvent;
import utils.ImageUtils;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 600;
	
	private Image backgroundTile;
	
	private int rows;
	private int cols;
	private int cellWidth;
	private int width;
	private int height;
	private Board board;
	
	private List<Sprite> eElementSpriteList = new ArrayList<>();
	private List<Sprite> robotSpriteList = new ArrayList<>();

	public BoardPanel(IBoard board) {
		this.rows = board.getNumRows();
		this.cols = board.getNumColumns();
		
		if (rows >= cols) {
			cellWidth = maxDimension/rows;
		} else {
			cellWidth = maxDimension/cols;
		}
		
		width = cols*cellWidth;
		height = rows*cellWidth;
		
		setPreferredSize(new Dimension(width, height));
		
		backgroundTile = ImageUtils.scaledImage("images/tile.png", cellWidth, cellWidth);
	}

	public void addSprite(Piece piece, Position p) {
		if (piece instanceof EnvironmentElement) {
			eElementSpriteList.add(SpriteFactory.getFromPiece(piece, cellWidth, this));
		} else if (piece instanceof Robot) {
			robotSpriteList.add(SpriteFactory.getFromPiece(piece, cellWidth, this));
		} else {
			throw new IllegalArgumentException("Piece must be either a Robot or an EnvironmentElement");
		}
		repaint();
	}
	public void removeEElementSprite(Piece piece, Position p) {
		eElementSpriteList.remove(getEElementSpriteAtPosition(p));
		repaint();
	}
	
	public Sprite getEElementSpriteAtPosition(Position p) {
		int x = p.getX();
		int y = p.getY();
		
		for (Sprite sprite: eElementSpriteList) {
			if(sprite.getX()==cellWidth*x && sprite.getY()==cellWidth*y) {
				 return sprite;
			}
		}
		return null;
	}
	
	public Sprite getRobotSpriteAtPosition(Position p) {
		int x = p.getX();
		int y = p.getY();
		
		for (Sprite sprite: robotSpriteList) {
			if(sprite.getX()==cellWidth*x && sprite.getY()==cellWidth*y) {
				 return sprite;
			}
		}
		return null;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				g2.drawImage(backgroundTile, col*cellWidth, row*cellWidth, null);
			}
		}
		
		for (Sprite sprite: eElementSpriteList) {
			sprite.drawUsing(g2);
		}
		for (Sprite sprite: robotSpriteList) {
			sprite.drawUsing(g2);
		}
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	public void propertyChange(PropertyChangeEvent pci) {
		switch (pci.getPropertyChangeType()) {
		case PLACEMENT:
			addSprite(pci.getPiece(), pci.getPosCurrent());
			break;
		case REMOVAL:
			removeEElementSprite(pci.getPiece(), pci.getPosCurrent());
			break;
		case ACTIVATION:
			activateSprite(pci);
			break;
		case MOVEMENT:
			moveRobot(pci);
			break;
		case TELEPORT:
			teleportRobot(pci);
			break;
		case ROTATION:
			rotateSprite(pci);
			break;
		case ROBOT_LASER:
			displayRobotLaser(pci);
			break;
		default:
			break;
		}
	}
	
	private void activateSprite(PropertyChangeEvent pci) {
		System.out.println("activating");
		getEElementSpriteAtPosition(pci.getPosCurrent()).activate();
		repaint();
	}
	
	private void moveRobot(PropertyChangeEvent pci) {
		System.out.println("handling");
		Position pCurr = pci.getPosCurrent();
		Position pNew = pci.getPosNew();
		Position pDiff = pNew.subtract(pCurr);
		Sprite robotSprite = getRobotSpriteAtPosition(pCurr);
		System.out.println(pDiff + " " + pCurr + " " + pNew);
		double screenDiffX = pDiff.getX()*cellWidth;
		double screenDiffY = pDiff.getY()*cellWidth;
		double screenShiftX = screenDiffX/30;
		double screenShiftY = screenDiffY/30;
		
		int screenFinalX = pNew.getX()*cellWidth;
		int screenFinalY = pNew.getY()*cellWidth;
		
		
		
		robotSprite.setX(screenFinalX);
		robotSprite.setY(screenFinalY);
		System.out.println(screenFinalX + " " + screenFinalY);
		repaint();
		
//		new SwingWorker<Void, Void>() {
//			@Override
//			public Void doInBackground() {
//				try {
//					double screenX = robotSprite.getX();
//					double screenY = robotSprite.getY();
//					for (int i = 0; i < 29; i++) {
//						System.out.println("moving");
//						screenX += screenShiftX;
//						screenY += screenShiftY;
//						Thread.sleep(1000/60);
//						int screenXInt = (int) screenX;
//						int screenYInt = (int) screenY;
//						SwingUtilities.invokeLater(() -> {
//							robotSprite.setX(screenXInt);
//							robotSprite.setY(screenYInt);
//							repaint();
//						});
//					}
//					SwingUtilities.invokeLater(() -> {
//						robotSprite.setX(screenFinalX);
//						robotSprite.setY(screenFinalY);
//						System.out.println(screenFinalX + " " + screenFinalY);
//						repaint();
//					});
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return null;
//			}
//			
//		}.execute();
		
	}
	
	private void teleportRobot(PropertyChangeEvent pci) {
		Position posCurrent = pci.getPosCurrent();
		Sprite sprite = getRobotSpriteAtPosition(posCurrent);
		Position posNew = pci.getPosNew();
		sprite.setX(posNew.getX()*cellWidth);
		sprite.setY(posNew.getY()*cellWidth);
		repaint();
	}
	
	private void rotateSprite(PropertyChangeEvent pci) {
		System.out.println("turning");
		
		//Still dosent work, event needs to include which way the robot turns or figure out better from old - new
		
		double degCurr = pci.getOrientationOld().getDegrees();
		double degNew = pci.getOrientationNew().getDegrees();
		double degDiff;
		if(((degCurr < degNew) || ((degNew==0) && (degCurr==270))) && !(degCurr == 0 && degNew == 270)) {
			degDiff = 90;
		} else {
			degDiff = -90;
		}
		int degNewInt = (int) degNew;
		Position p = pci.getPosCurrent();
		Sprite robotSprite = getRobotSpriteAtPosition(p);
		System.out.println(degCurr + " " + degNew + " " + degDiff);
		
		
		
		robotSprite.setRotation(degNewInt);
		repaint();
		

//		new SwingWorker<Void, Void>() {
//			@Override
//			public Void doInBackground() {
//				try {
//					double deg = robotSprite.getRotation();
//					for (int i = 0; i < 29; i++) {
//						System.out.println("rotating");
//						deg += degDiff/30;
//						Thread.sleep(1000/60);
//						int degInt = (int) deg;
//						SwingUtilities.invokeLater(() -> {
//							robotSprite.setRotation(degInt);
//							repaint();
//						});
//					}
//					SwingUtilities.invokeLater(() -> {
//						robotSprite.setRotation(degNewInt);
//						repaint();
//					});
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return null;
//			}
//			
//		}.execute();
		
	}
	
	private void displayRobotLaser(PropertyChangeEvent pci) {
		// TODO Auto-generated method stub
		
	}
}
