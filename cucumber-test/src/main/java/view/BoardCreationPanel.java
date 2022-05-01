package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
import game_basics.Board;
import game_basics.Position;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
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
	
	//icon for an empty tile
	ImageIcon icon;
	
	private JButton [][] cellButtons;
	private JButton saveBtn;
	
	int col = 0;
	int row = 0;
	

	public BoardCreationPanel(int rows, int cols, BoardCreationController controller, Board b, JButton saveButton) {
		
		newBoard = b;
		
		saveBtn = saveButton;
		
		setController(controller);
		
		
		setRowsCols(rows, cols);
		
		
		
		setPixelsPerCell();	
		setWidthHeight();
		
		//set layout
		GridBagLayout boardLayout = new GridBagLayout();
		setLayout(boardLayout);
		
		setPreferredSize(new Dimension(width, height));
		
		cellButtons = new JButton [rows][cols];
		
		createCellButtons();
		
	}

	
	@Override
	public int getHeight() {
		return height;
	}
	
	
	private void setController(BoardCreationController c) {
		controller = c;
	}
	
	private void setRowsCols( int r, int c ) {
		rows = r;
		cols = c;
		
	}
	
	/** This method sets the size (length of each side) of each cell based on the number of rows and columns of
	 *  the board */
	private void setPixelsPerCell() {
		if (rows >= cols) {
			pixelsPerCell = maxDimension/(rows);
		} else {
			pixelsPerCell = maxDimension/(cols);
		}
	}
	/** This method sets the width and height of the board creation panel from
	 * the given columns, rows and the number of pixels per cell, which are attributes of the panel */
	private void setWidthHeight() {
		width = cols*pixelsPerCell;
		height = rows*pixelsPerCell;
	}
	
	/** This method goes through all positions of columns and rows and creates a cell
	 *  of type JButton in the panel. */
	private void createCellButtons() {
		
		icon = new ImageIcon(ImageUtils.scaledImage("/tile.png", pixelsPerCell, pixelsPerCell));
		
		
		while(row < rows) {
			while (col < cols) {
					
					int x = col;
					int y = row;

					
					JButton cell = new JButton();
					
					//The icon with the image of an empty cell is assigned to a cell
					cell.setIcon(icon);
					//Set the size of the cell equal to the icon (which are the dimensions pixesPerCell)
					cell.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
					cell.setAlignmentX(Component.CENTER_ALIGNMENT);
					cell.setName("tile");
					
					//Add a cell button to cellButtons matrix
					//This is done to know the position of each cell button, for effects of removing certain buttons 
					//for Environment Elements that cannot appear twice, i.e, Checkpoints and Teleporters
					cellButtons[y][x]=cell;
					
					if (row!=11) {
						cell.addActionListener(e -> {
							
	
							JButton selectedCell = (JButton)  e.getSource();
	
							
							if (controller.elementIsActive()) {
								
								//set save button enabled
								saveBtn.setEnabled(true);
								
								
								// getSelectedElement() is a element ID
								ImageIcon env = new ImageIcon(ImageUtils.scaledImage("/" + controller.getSelectedElement() + ".png", pixelsPerCell, pixelsPerCell));
								
								
								Position pos = new Position(x , y);
	
								
								EnvironmentElement newElem = createEElement(controller.getSelectedElement());
	
								actionsOnBoardAndUI(newElem, pos, selectedCell, env);
								
	
							}
							
							repaint();
							
							controller.setCreatedBoard(newBoard);
							
						});
					}
					
					add(cell, GridBagLayoutUtils.constraint(col, row, 0));
				
					col++;
				
			}
			
			col = 0;
			row++;

		}
	}
	
	/** Returns an instance of an Environment Element according to the ID of the element selected */
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
				
			} else if (id == "checkpoint1" || id == "checkpoint2" || id == "checkpoint3" || id == "checkpoint4" || id == "checkpoint5") {
				
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
				} else if (id == "checkpoint5") {
					cp = new Checkpoint(5);
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
				
			} else if (id == "TeleporterBlue" || id == "TeleporterOrange") {
				
				Teleporter tp = null;
				
				System.out.println("Added Teleporter");
				
				if (id == "TeleporterBlue") {
					tp = new Teleporter(false);
				} else if (id == "TeleporterOrange") {
					tp = new Teleporter(true);
				} 
				return tp;
				
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
				throw new RuntimeException("Invalid input. Please enter a valid Environment Element id");
			}
			
			
		
	}
	
	/** This method returns the number that corresponds to the name of a Checkpoint
	 *  button from the ElementSelectionPanel. */
	private int getCheckpointNumber (String id) {
		
		if (id == "checkpoint1") {
			return 1;
		} else if(id == "checkpoint2") {
			return 2;
		} else if(id == "checkpoint3") {
			return 3;
		} else if(id == "checkpoint4") {
			return 4;
		} else if(id == "checkpoint5") {
			return 5;
		} else {
			throw new RuntimeException("ID from Checkpoint doesn't match any case.");
		}
		
	}
	
	/** This method returns the boolean that corresponds to the name of a Teleporter
	 *  button from the ElementSelectionPanel. */
	private boolean getTeleporterIsSending(String id) {
		
		if (id == "TeleporterOrange") {
			return true;
		} else if(id == "TeleporterBlue") {
			return false;
		} else {
			throw new RuntimeException("ID from Teleporter doesn't match any case.");
		}
		
	}
	
	/**This method removes a Checkpoint in the board newBoard that has its number
	 * attribute equal to the argument of this method*/
	private void removeCheckpointInBoard(int checkpointNumber) {
		
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				
				if(newBoard.hasEElementAt(new Position (row, col))) {
					if(newBoard.getEElementAt(new Position (row, col)) instanceof Checkpoint) {
						
						Checkpoint cp = (Checkpoint) newBoard.getEElementAt(new Position (row, col));
						if ( cp.getNumber() == checkpointNumber) {
							newBoard.removeEElement(new Position (row, col));
							cellButtons[col][row].setIcon(icon);
						}
						
						
						
					}
				}
				
			}
		}
		
	}
	
	/**This method removes a Teleporter in the board newBoard that has the isSending 
     * attribute equal to the argument of this method*/
	private void removeTeleporterInBoard(boolean sending) {
		
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				
				if(newBoard.hasEElementAt(new Position (row, col))) {
					if(newBoard.getEElementAt(new Position (row, col)) instanceof Teleporter) {
						
						Teleporter cp = (Teleporter) newBoard.getEElementAt(new Position (row, col));
						if ( cp.isSending() == sending) {
							newBoard.removeEElement(new Position (row, col));
							cellButtons[col][row].setIcon(icon);
						}
						
						
						
					}
				}
				
			}
		}
		
	}
	
	
	/**This method receives a newElem, which is the newElement that is to be attributed to a specific cell, a position p
     *which represents the position of the cell , a selectedCell which is the cell button that is clicked and an
     *icon which is the icon to be attributed to the selected cell button.
     *This method acts on all the changes that should be done both visually and on the board newBoard, essentially
     *by receiving an instance of a new Environment Element that is to be added and a selected cell and its position.
     *The env argument that is received is used for changing the icon of the selected cell button to the image corresponding 
     *to the selected element to add (obtained from the name of the selected element button).
     *   */
	private void actionsOnBoardAndUI(EnvironmentElement newElem, Position pos, JButton selectedCell, ImageIcon env ) {
		
		//If there is an Environment Element in the position pos, of the cell clicked
		if(newBoard.hasEElementAt(pos)) {
			
			EnvironmentElement existingElem = newBoard.getEElementAt(pos);
			
			//If the ID's of the Environment Elements  are the same (meaning that the Environment Element 
            //to be added is the same as the one in the position selected) then set the icon of the cell button
            //to an image of an empty cell and remove the Environment Element at this position
            //Else we just remove the element in the newBoard, place the newElem in the board and 
            // change the icon of the button selected to the image of the
			if (existingElem.getPieceID() == newElem.getPieceID()) {

				
				//remove element from board visually and in the board object
				selectedCell.setIcon(icon);
				newBoard.removeEElement(pos);
				
				
			} else {
				//visual
				selectedCell.setIcon(env);
				
				newBoard.removeEElement(pos);
				newBoard.initialPlacement(newElem, pos);
			}
			
		} else {
			//If there isn't an EnvironmentElement at the position of the selected button

            //if the newElem to be added is a Checkpoint
			
			if(newElem instanceof Checkpoint) {

				
				//visual
				selectedCell.setIcon(env);
				
				//get the checkpoint number of the element selected
				int checkpointNumber;
				checkpointNumber = getCheckpointNumber(controller.getSelectedElement());
				
				
				
				//remove same checkpoint in case it exists
				removeCheckpointInBoard(checkpointNumber);
				newBoard.initialPlacement(newElem, pos);
				
			} else if(newElem instanceof Teleporter) {
				//if selected element is a teleporter
				//visual
				selectedCell.setIcon(env);
				
				//get if the teleporter is sending or not
				boolean sending;
				sending = getTeleporterIsSending(controller.getSelectedElement());

				
				
				//remove same Teleporter in case it exists
				removeTeleporterInBoard(sending);
				newBoard.initialPlacement(newElem, pos);
				
			} else {
				//Else we can simply add a new Environment Element to the board
				//visual
				selectedCell.setIcon(env);
				
				newBoard.initialPlacement(newElem, pos);
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
