package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import board.Board;
import board.Position;
import controller.BoardCreationController;
import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Piece;
import utils.GridBagLayoutUtils;
import utils.ImageUtils;
import environment_elements.Pit;
import environment_elements.HealthStation;

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
	

	public BoardCreationPanel(int rows, int cols, BoardCreationController controller, Board b) {
		
		newBoard = b;
		
		
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
		
		
		while(row < rows) {
			while (col < cols) {
					
					int x = col;
					int y = row;
//					JButton cell = new JButton(icon);
					
					JButton cell = new JButton();
//					JButton cell = new CellButton(new Position(row, col));
					cell.setIcon(icon);
					cell.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
					cell.setAlignmentX(Component.CENTER_ALIGNMENT);
					cell.setName("tile");
					
					cell.addActionListener(e -> {

						JButton selectedCell = (JButton)  e.getSource();
//						JButton selectedCell = (CellButton)  e.getSource();
						

						
						System.out.println("Element clicked" );
						
						if (controller.elementIsActive()) {
							
							System.out.println("imageChanged");
							System.out.println("x " + x + "y " + y);
							
							
							// getSelectedElement() is a element ID
							ImageIcon env = new ImageIcon(ImageUtils.scaledImage("images/" + controller.getSelectedElement() + ".png", pixelsPerCell, pixelsPerCell));
							
							selectedCell.setIcon(env);
							
							// if has EnvElement at this pos
							// then remove it and add this new element
							
//							//DEBUGGING
//							if (controller.getSelectedElement()==ConveyorBelt.ID) {
//								System.out.println("GOT CONVEYORBELT ID" );
//							} else {
//								System.out.println("DIDNT GET ID" );
//							}
//							
//							EnvironmentElement en = createEElement("conveyor_belt");
//							boolean chain =  en instanceof ConveyorBelt;
//							
//							if(chain ) {
//								System.out.println("CONVEYORBELT CREATED SUCCESSFULY" +  createEElement(ConveyorBelt.ID) );
//							} else {
//								System.out.println("DIDNT CREATE CONVEYORBELT" );
//							}
							
							
							Position pos = new Position(x , y);
							
							EnvironmentElement newElem = createEElement(controller.getSelectedElement());
							System.out.println(pos );
							
							if (newBoard.hasEElementAt(pos)) {
								newBoard.removeEElement(pos);
								newBoard.initialPlacement(newElem, pos);
								System.out.println("HAS ELEMENT IN POSITION ALREADY" );
							} else {
								newBoard.initialPlacement(newElem, pos);
								System.out.println(newBoard.hasEElementAt(pos));
								System.out.println("DOESNT HAVE ELEMENT IN POSITION" );
							}
							
							
							if (newBoard.hasEElementAt(pos)) {
								System.out.println("Element added to matrix at x = " + x + " and row at y = " + y);
							} else {
								System.out.println("No element was added to matrix" );
							}
							
							
//							System.out.println("removed element at col " + x + " and row at " + y);
						}
						
						repaint();
						
						controller.setCreatedBoard(newBoard);
						
					});
					add(cell, GridBagLayoutUtils.constraint(col, row, 0));
					
//					add(Box.createRigidArea(new Dimension(0, 5)));
				
					col++;
				
			}
			
			col = 0;
			row++;

		}
	}
	
	private EnvironmentElement createEElement (String id){
			
			if (id == ChainingPanel.ID) {
				System.out.println("Added ChainingPanel");
				
				ChainingPanel e = new ChainingPanel();
				e = new ChainingPanel();
				return e;
			} else if (id == "conveyor_beltD" || id == "conveyor_beltR" || id == "conveyor_beltL" || id == "conveyor_beltU") {
				
				ConveyorBelt e = null;
				
				System.out.println("Added ConveyorBelt");
				if (id == "conveyor_beltD") {
					e = new ConveyorBelt(Orientation.DOWN);
				} else if (id == "conveyor_beltR") {
					e = new ConveyorBelt(Orientation.RIGHT);
				} else if (id == "conveyor_beltL") {
					e = new ConveyorBelt(Orientation.LEFT);
				} else if (id == "conveyor_beltU") {
					e = new ConveyorBelt(Orientation.UP);
				}
				return e;
				
			} else if (id == "checkpoint1" || id == "checkpoint2" || id == "checkpoint3" || id == "checkpoint4") {
				
				Checkpoint cp = null;
				
				System.out.println("Added ConveyorBelt");
				if (id == "checkpoint1") {
					cp = new Checkpoint(1);
				} else if (id == "checkpoint2") {
					cp = new Checkpoint(2);
				} else if (id == "checkpoint3") {
					cp = new Checkpoint(3);
				} else if (id == "checkpoint4") {
					cp = new Checkpoint(4);
				}
				return cp;
				
			} else if (id == "gear_left" || id == "gear_right") {
				
				Gear gear = null;
				
				System.out.println("Added ConveyorBelt");
				if (id == "gear_left") {
					gear = new Gear(true);
				} else if (id == "gear_right") {
					gear = new Gear(false);
				} 
				return gear;
				
			} else if (id == ConveyorBelt.ID) {
				System.out.println("Added ConveyorBelt");
				
				ConveyorBelt e = new ConveyorBelt(Orientation.RIGHT);
				return e;
				
			} else if (id == Teleporter.ID) {
				Teleporter e = new Teleporter();
				return e;
			} else if (id == Laser.ID) {
				Laser e = new Laser();
				return e;
			} else if (id == Fire.ID) {
				Fire e = new Fire();
				return e;
			} else if (id == OilSpill.ID) {
				OilSpill e = new OilSpill();
				return e;
			} else if (id == ReversalPanel.ID) {
				ReversalPanel e = new ReversalPanel();
				return e;
			} else if (id == RespawnPoint.ID) {
				RespawnPoint e = new RespawnPoint();
				return e;
			} else if (id == Wall.ID) {
				Wall e = new Wall();
				return e;
			} else if (id == Pit.ID) {
				Pit e = new Pit();
				return e;
			} else if (id == HealthStation.ID ) {
				HealthStation e = new HealthStation();
				return e;
			} else {
				throw new java.lang.RuntimeException("Invalid input. Please enter a valid Environment Element id");
			}
			
			
		
	}
	

	
}
