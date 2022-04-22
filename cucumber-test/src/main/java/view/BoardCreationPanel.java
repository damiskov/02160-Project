package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.BoardCreationController;
import utils.GridBagLayoutUtils;
import utils.ImageUtils;

public class BoardCreationPanel extends JPanel {
	
private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 600;
	
	private Image backgroundTile;
	
	private BoardCreationController controller;
	
	private JButton element;
	
	private int rows;
	private int cols;
	private int pixelsPerCell;
	private int width;
	private int height;
	
	private List<ISprite> spriteList = new ArrayList<>();

	public BoardCreationPanel(int rows, int cols, BoardCreationController controller) {
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
		ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("images/tile.png", pixelsPerCell, pixelsPerCell));
		
		
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				
					
					
					element = new JButton(icon);
					element.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
					element.setAlignmentX(Component.CENTER_ALIGNMENT);
					element.setName("tile");
					
					element.addActionListener(e -> {
						System.out.println("Element clicked");
						
						if (controller.elementIsActive()) {
							
							System.out.println("imageChanged");
							
							
							
							// check if env = element.getIcon()?
							ImageIcon env = new ImageIcon(ImageUtils.scaledImage("images/" + controller.getSelectedElement() + ".png", pixelsPerCell, pixelsPerCell));
							JButton selectedElement = (JButton) e.getSource();
							selectedElement.setIcon(env);
							
							
						}
						
						repaint();
						
					});
					add(element, GridBagLayoutUtils.constraint(col, row, 0));
					
//					add(Box.createRigidArea(new Dimension(0, 5)));
				
			}
		}
		
	}
	

	
	@Override
	public int getHeight() {
		return height;
	}
	
	public void addElement(String e, int x, int y) {
		
//		spriteList.add(SpriteFactory.getFromPieceID(e, pixelsPerCell, pixelsPerCell * x, pixelsPerCell * y, 0, this));
//		repaint();
		
	}
	
}
