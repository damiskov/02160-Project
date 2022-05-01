package view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import animations.ChainActivationAnimation;
import animations.ColoredLinePair;
import animations.SpriteImageChangeAnimation;
import animations.SpriteMovementAnimation;
import animations.SpritePlacementAnimation;
import animations.SpriteRemovalAnimation;
import animations.SpriteRobotLaserAnimation;
import animations.SpriteRotationAnimation;
import animations.SpriteTeleportAnimation;
import board.*;
import piece_basics.EnvironmentElement;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.ChainingEvent;
import property_changes.ChainingPanelActivationEvent;
import property_changes.IPropertyChangeEvent;
import property_changes.MovementEvent;
import property_changes.PlacementEvent;
import property_changes.RemovalEvent;
import property_changes.RobotLaserEvent;
import property_changes.RotationEvent;
import property_changes.TeleportEvent;
import utils.ImageUtils;

// This is the part of the main UI that displays the board and everything on it
public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 500;
	
	private final MasterView masterView;
	
	private Image backgroundTile;
	
	private int rows;
	private int cols;
	private int cellWidth;
	private int width;
	private int height;
	
	private List<Sprite> eElementSpriteList = new ArrayList<>();
	private List<ColoredLinePair> chainSpriteList = new ArrayList<>();
	private List<ColoredLinePair> laserSpriteList = new ArrayList<>();
	private List<Sprite> robotSpriteList = new ArrayList<>();
	private Map<Integer, Sprite> robotNumToSpriteMap = new HashMap<>();

	public BoardPanel(Board board, MasterView masterView) {
		this.masterView = masterView;
		
		this.rows = board.getNumRows();
		this.cols = board.getNumColumns();
		
		if (rows >= cols) {
			this.cellWidth = maxDimension/rows;
		} else {
			this.cellWidth = maxDimension/cols;
		}
		
		this.width = cols*cellWidth;
		this.height = rows*cellWidth;
		
		setMinimumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height)); 
		
		backgroundTile = ImageUtils.scaledImage("images/tile.png", cellWidth, cellWidth);
		
		addInitialSprites(board);
	}

	// This method creates sprites for all the pieces initially on the board
	private void addInitialSprites(Board board) {
		System.out.println("\tInitial sprite placements");
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				Position cpos = new Position(i, j);
				if(board.hasEElementAt(cpos)){
					addSprite(board.getEElementAt(cpos), cpos);
				}
				if(board.hasRobotAt(cpos)){
					addSprite(board.getRobotAt(cpos), cpos);
				}
			}
		}
	}

	/* 
	 * Everything to do with sprites in the BoardPanel is done using animations, including the initial placement
	 * of the sprites
	 */
	public void addSprite(Piece piece, Position p) {
		if (piece instanceof EnvironmentElement) {
			Sprite eElementSprite = SpriteFactory.getFromPiece(piece, cellWidth, this);
			masterView.enqueueAnimation(new SpritePlacementAnimation(eElementSprite, eElementSpriteList));
		} else if (piece instanceof Robot) {
			Sprite robotSprite = SpriteFactory.getFromPiece(piece, cellWidth, this);
			masterView.enqueueAnimation(new SpritePlacementAnimation(robotSprite, robotSpriteList));
			Robot robot = (Robot) piece;
			robotNumToSpriteMap.put(robot.getRobotNumber(), robotSprite);
		} else {
			throw new IllegalArgumentException("Piece must be either a Robot or an EnvironmentElement");
		}
	}
	
	public Sprite getEElementSpriteAtPosition(Position p) {
		int x = p.getX();
		int y = p.getY();
		
		/* 
		 * The position p uses board cell coordinates, where (0, 0) is the bottom-left cell. Here, we must
		 * convert to pixel coordinates, where (0, 0) is the bottom left pixel, by multiplying by cellWidth
		 */
		for (Sprite sprite: eElementSpriteList) {
			if(sprite.getX()==cellWidth*x && sprite.getY()==cellWidth*y) {
				 return sprite;
			}
		}
		throw new SpriteNotFoundException("Could not find EElement sprite at " + p);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		// draw the background tiles
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				g2.drawImage(backgroundTile, col*cellWidth, row*cellWidth, null);
			}
		}
		
		// draw environment elements
		for (Sprite sprite: eElementSpriteList) {
			sprite.drawUsing(g2);
		}
		// draw chains between robots created by ChainingPanels
		for (ColoredLinePair chainPair: chainSpriteList) {
			g2.setStroke(new BasicStroke(4));
			g2.setColor(chainPair.getOuterColor());
			g2.drawLine(chainPair.getSprite1().getX()+cellWidth/2, (cols*cellWidth)-chainPair.getSprite1().getY()-cellWidth/2, 
					    chainPair.getSprite2().getX()+cellWidth/2, (cols*cellWidth)-chainPair.getSprite2().getY()-cellWidth/2);
			g2.setStroke(new BasicStroke(2));
			g2.setColor(chainPair.getInnerColor());
			g2.drawLine(chainPair.getSprite1().getX()+cellWidth/2, (cols*cellWidth)-chainPair.getSprite1().getY()-cellWidth/2, 
				        chainPair.getSprite2().getX()+cellWidth/2, (cols*cellWidth)-chainPair.getSprite2().getY()-cellWidth/2);
			
		}
		// draw robot lasers
		for (ColoredLinePair laserPair: laserSpriteList) {
			g2.setStroke(new BasicStroke(4));
			g2.setColor(laserPair.getOuterColor());
			g2.drawLine(laserPair.getSprite1().getX()+cellWidth/2, (cols*cellWidth)-laserPair.getSprite1().getY()-cellWidth/2, 
					    laserPair.getSprite2().getX()+cellWidth/2, (cols*cellWidth)-laserPair.getSprite2().getY()-cellWidth/2);
			g2.setStroke(new BasicStroke(2));
			g2.setColor(laserPair.getInnerColor());
			g2.drawLine(laserPair.getSprite1().getX()+cellWidth/2, (cols*cellWidth)-laserPair.getSprite1().getY()-cellWidth/2, 
				        laserPair.getSprite2().getX()+cellWidth/2, (cols*cellWidth)-laserPair.getSprite2().getY()-cellWidth/2);
			
		}
		// draw robots
		for (Sprite sprite: robotSpriteList) {
			sprite.drawUsing(g2);
		}
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	public void propertyChange(IPropertyChangeEvent pci) {
		/* 
		 * dispatch property change events to private methods based on the event type. The addSprite
		 * method is above, and the rest are below this method
		 */
		if (pci instanceof PlacementEvent) {
			PlacementEvent pe = (PlacementEvent) pci;
			addSprite(pe.getPiece(), pe.getPos());
		} else if (pci instanceof RemovalEvent) {
			RemovalEvent re = (RemovalEvent) pci;
			removeEElementSprite(re);
		} else if (pci instanceof ChainingEvent) {
			ChainingEvent ce = (ChainingEvent) pci;
			chainRobots(ce);
		} else if (pci instanceof ChainingPanelActivationEvent) {
			ChainingPanelActivationEvent ae = (ChainingPanelActivationEvent) pci;
			toggleChainingPanelSprite(ae);
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
	
	public void removeEElementSprite(RemovalEvent re) {
		System.out.println("Handling removal event");
		Position p = re.getPos();
		masterView.enqueueAnimation(new SpriteRemovalAnimation(p, this));
	}
	
	private void toggleChainingPanelSprite(ChainingPanelActivationEvent ae) {
		masterView.enqueueAnimation(new SpriteImageChangeAnimation(getEElementSpriteAtPosition(ae.getPos())));
		System.out.println("Chaining panel toggle animation enqueued");
	}
	
	private void moveRobot(MovementEvent me) {
		Sprite spriteToMove = robotNumToSpriteMap.get(me.getRobotNum());
		masterView.enqueueAnimation(new SpriteMovementAnimation(500, spriteToMove, me.getOldPos(), me.getNewPos(), cellWidth));
		System.out.println("Movement animation enqueued");
	}
	
	private void chainRobots(ChainingEvent ce) {
		Sprite robot1 = robotNumToSpriteMap.get(ce.getRobotNumber1());
		Sprite robot2 = robotNumToSpriteMap.get(ce.getRobotNumber2());
		boolean process = ce.getProcess();
		masterView.enqueueAnimation(new ChainActivationAnimation(500, chainSpriteList, robot1, robot2, process));	
		System.out.println("Chaining animation enqueued");
	}
	
	private void teleportRobot(TeleportEvent te) {
		Sprite spriteToTeleport = robotNumToSpriteMap.get(te.getRobotNum());
		int screenNewX = te.getPosNew().getX() * cellWidth;
		int screenNewY = te.getPosNew().getY() * cellWidth;
		masterView.enqueueAnimation(new SpriteTeleportAnimation(spriteToTeleport, screenNewX, screenNewY));
	}
	
	private void rotateRobot(RotationEvent re) {	
		Sprite spriteToRotate = robotNumToSpriteMap.get(re.getRobotNum());
		masterView.enqueueAnimation(new SpriteRotationAnimation(500, spriteToRotate, re.getOrientationOld(),re.getOrientationNew()));
		System.out.println("Rotation animation enqueued");
	}
	
	private void displayRobotLaser(RobotLaserEvent rle) {
		Sprite shooter = robotNumToSpriteMap.get(rle.getShooterRobotNumber());
		Sprite target = robotNumToSpriteMap.get(rle.getTargetRobotNumber());		
		System.out.println("Laser rendition" + rle.getShooterRobotNumber() + "->" + rle.getTargetRobotNumber());
		masterView.enqueueAnimation(new SpriteRobotLaserAnimation(500, laserSpriteList, shooter, target));
	
	}

	public List<Sprite> geteElementSpriteList() {
		return eElementSpriteList;
	}
}





