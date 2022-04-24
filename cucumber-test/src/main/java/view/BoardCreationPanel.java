package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import board.Board;
import board.Position;
import controller.BoardCreationController;
import environment_elements.ConveyorBelt;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import utils.GridBagLayoutUtils;
import utils.ImageUtils;

public class BoardCreationPanel extends JPanel {
	
private static final long serialVersionUID = -2140843137512577992L;
	
	private static final int maxDimension = 600;
	
	
	private BoardCreationController controller;
	
	
	
	private int rows;
	private int cols;
	private int pixelsPerCell;
	private int width;
	private int height;
	private Board newBoard;
	
	int col = 0;
	int row = 0;
	

	public BoardCreationPanel(int rows, int cols, BoardCreationController controller, Board newBrd) {
		
		newBoard = newBrd;
		
		setController(controller);
		
		setRowsCols(rows, cols);
		setPixelsPerCell();	
		setWidthHeight();
		
		//set layout
		GridBagLayout boardLayout = new GridBagLayout();
		setLayout(boardLayout);
		
		setPreferredSize(new Dimension(width, height));
		
		createCellButtons();
		
	}

	
	@Override
	public int getHeight() {
		return height;
	}
	
	public void addElement(String e, int x, int y) {
		
//		spriteList.add(SpriteFactory.getFromPieceID(e, pixelsPerCell, pixelsPerCell * x, pixelsPerCell * y, 0, this));
//		repaint();
		
	}
	
	private void setController(BoardCreationController c) {
		controller = c;
	}
	
	private void setRowsCols( int r, int c ) {
		rows = r;
		cols = c;
	}
	
	private void setPixelsPerCell() {
		if (rows >= cols) {
			pixelsPerCell = maxDimension/(rows);
		} else {
			pixelsPerCell = maxDimension/(cols);
		}
	}
	
	private void setWidthHeight() {
		width = cols*pixelsPerCell;
		height = rows*pixelsPerCell;
	}
	
	private void createCellButtons() {
		
		ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("images/tile.png", pixelsPerCell, pixelsPerCell));
		
		
		while(col < cols) {
			while (row < rows) {
				
					JButton cell = new JButton(icon);
					cell.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
					cell.setAlignmentX(Component.CENTER_ALIGNMENT);
					cell.setName("tile");
					
					cell.addActionListener(e -> {
						System.out.println("Element clicked" );
						
						if (controller.elementIsActive()) {
							
							System.out.println("imageChanged");
							
							
							
							// check if env = element.getIcon()?
							ImageIcon env = new ImageIcon(ImageUtils.scaledImage("images/" + controller.getSelectedElement() + ".png", pixelsPerCell, pixelsPerCell));
							JButton selectedCell = (JButton) e.getSource();
							selectedCell.setIcon(env);
							
							// if has EnvElement at this pos
							// then remove it and add this new element
							if (newBoard.hasEElementAt(new Position(col, row))) {
								newBoard.removeEElement(new Position (col, row));
								newBoard.initialPlacement(createEElement(controller.getSelectedElement()), new Position(col, row));
							} else {
								newBoard.initialPlacement(createEElement(controller.getSelectedElement()), new Position(col, row));
							}
							
							System.out.println("removed element at col " + col + " and row at " + row);
							
							
						}
						
						repaint();
						
					});
					add(cell, GridBagLayoutUtils.constraint(col, row, 0));
					
//					add(Box.createRigidArea(new Dimension(0, 5)));
				
					row++;
				
			}
			
			row = 0;
			col++;

		}
	}
	
	private EnvironmentElement createEElement (String id){
		
		//return new element from the name id
		return new ConveyorBelt(Orientation.UP);
		
	}
	
}
