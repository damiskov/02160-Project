package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import animations.SpriteActivationAnimation;
import animations.SpriteMovementAnimation;
import animations.SpriteRobotLaserAnimation;
import animations.SpriteRotationAnimation;
import animations.SpriteTeleportAnimation;
import board.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.ActivationEvent;
import property_changes.IPropertyChangeEvent;
import property_changes.MovementEvent;
import property_changes.PlacementEvent;
import property_changes.RemovalEvent;
import property_changes.RobotLaserEvent;
import property_changes.RotationEvent;
import property_changes.TeleportEvent;
import utils.ImageUtils;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 600;
	
	private final MasterView masterView;
	
	private Image backgroundTile;
	
	private int rows;
	private int cols;
	private int cellWidth;
	private int width;
	private int height;
	private Board board;
	
	private List<Sprite> eElementSpriteList = new ArrayList<>();
	private List<ImageToggleSprite> robotLaserSpriteList = new ArrayList<>();
	private List<Sprite> robotSpriteList = new ArrayList<>();
	private Map<Integer, Sprite> robotNumToSpriteMap = new HashMap<>();

	public BoardPanel(IBoard board, MasterView masterView) {
		this.masterView = masterView;
		
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
			Sprite robotSprite = SpriteFactory.getFromPiece(piece, cellWidth, this);
			robotSpriteList.add(robotSprite);
			Robot robot = (Robot) piece;
			robotNumToSpriteMap.put(robot.getRobotNumber(), robotSprite);
		} else {
			throw new IllegalArgumentException("Piece must be either a Robot or an EnvironmentElement");
		}
		repaint();
	}
	
	public void removeEElementSprite(Position p) {
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
		throw new SpriteNotFoundException("Could not find EElement sprite at " + p);
	}
	
	public Sprite getRobotSpriteAtPosition(Position p) {
		int x = p.getX();
		int y = p.getY();
		
		for (Sprite sprite: robotSpriteList) {
			if(sprite.getX()==cellWidth*x && sprite.getY()==cellWidth*y) {
				 return sprite;
			}
		}
		throw new SpriteNotFoundException("Could not find robot sprite at " + p);
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
		for (Sprite sprite: robotLaserSpriteList) {
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

	public void propertyChange(IPropertyChangeEvent pci) {
		if (pci instanceof PlacementEvent) {
			PlacementEvent pe = (PlacementEvent) pci;
			addSprite(pe.getPiece(), pe.getPos());
		} else if (pci instanceof RemovalEvent) {
			RemovalEvent re = (RemovalEvent) pci;
			removeEElementSprite(re.getPos());
		} else if (pci instanceof ActivationEvent) {
			ActivationEvent ae = (ActivationEvent) pci;
			activateSprite(ae);
		} else if (pci instanceof MovementEvent) {
			MovementEvent me = (MovementEvent) pci;
			moveRobot(me);
		} else if (pci instanceof TeleportEvent) {
			TeleportEvent te = (TeleportEvent) pci;
			teleportRobot(te);
		} else if (pci instanceof RotationEvent) {
			RotationEvent re = (RotationEvent) pci;
			rotateRobot(re);
		} else if (pci instanceof RobotLaserEvent) {
			RobotLaserEvent rle = (RobotLaserEvent) pci;
			displayRobotLaser(rle);
		}
	}
	
	private void activateSprite(ActivationEvent ae) {
		masterView.enqueueAnimation(new SpriteActivationAnimation(getEElementSpriteAtPosition(ae.getPos())));
		System.out.println("Activation animation enqueued");
	}
	
	private void moveRobot(MovementEvent me) {
		Sprite spriteToMove = robotNumToSpriteMap.get(me.getRobotNum());
		int screenDiffX = me.getPosChange().getX() * cellWidth;
		int screenDiffY = me.getPosChange().getY() * cellWidth;
		masterView.enqueueAnimation(new SpriteMovementAnimation(500, spriteToMove, screenDiffX, screenDiffY));
		System.out.println("Movement animation enqueued");
	}
	
	private void teleportRobot(TeleportEvent te) {
		Sprite spriteToTeleport = robotNumToSpriteMap.get(te.getRobotNum());
		int screenNewX = te.getPosNew().getX() * cellWidth;
		int screenNewY = te.getPosNew().getY() * cellWidth;
		masterView.enqueueAnimation(new SpriteTeleportAnimation(spriteToTeleport, screenNewX, screenNewY));
	}
	
	private void rotateRobot(RotationEvent re) {
		
		Sprite spriteToRotate = robotNumToSpriteMap.get(re.getRobotNum());
		int diffAngle;
		int degCurr = re.getOrientationOld().getDegrees();
		int degNew = re.getOrientationNew().getDegrees();
		if(((degCurr < degNew) || ((degNew==0) && (degCurr==270))) && !(degCurr == 0 && degNew == 270)) {
			diffAngle = 90;
		} else {
			diffAngle = -90;
		}
		masterView.enqueueAnimation(new SpriteRotationAnimation(500, spriteToRotate, diffAngle));
		System.out.println("Rotation animation enqueued");
		
	}
	
	private void displayRobotLaser(RobotLaserEvent rle) {
		Position startingPosition = rle.getPosStart();
		Position finishPosition = rle.getPosFinish();	
		//System.out.println("rle sequence started");
		//System.out.println("Drawing laser: " + startingPosition + "->" + finishPosition);
		
		masterView.enqueueAnimation(new SpriteRobotLaserAnimation(500, startingPosition, finishPosition, this, robotLaserSpriteList, cellWidth));
	
	}
}
