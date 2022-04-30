package view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import board.Board;

import board.Position;
import controller.BoardCreationController;
import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;
import environment_elements.ConveyorBelt;
import environment_elements.Gear;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Pit;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import utils.GridBagLayoutUtils;

public class BoardCreationView extends JFrame{
	private static final long serialVersionUID = 5L;
	
	private BoardCreationController controller;
	private Board newBoard;
	
	
//	private BoardPanel boardPanel;
	private BoardCreationPanel boardPanel;
	private ElementSelectionPanel elements;
	private JButton cancelButton;
	private JButton saveButton;
	private JButton playButton;
	private JPanel buttonsContainer;
	private JPanel numPlayersPanel; 
	private JSlider sliderNumPlayers;
	
	private int rows;
	private int columns;
	private int numberPlayers;
	
	// for testing
	
	public BoardCreationView(BoardCreationController boardCreationController) {
		
		setController(boardCreationController);
		initGUI();
	}
	
	
	private void initGUI() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Board Creator");
		
		setLayout(new GridBagLayout());
		
		//CREATE SLIDER
		createSliderPlayers();

		//CREATE BUTTONS
		createButtonsContainer();
		
		rows = 12;
		columns = 12;
		
		newBoard = new Board(rows, columns);
		
		boardPanel = new BoardCreationPanel(rows, columns, controller, newBoard, saveButton);
		elements = new ElementSelectionPanel(controller);
		
		
		
		addElements();
		pack();
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	private void addElements() {
		setLayout(new GridBagLayout());
		add(boardPanel, GridBagLayoutUtils.constraint(0, 1, 10));
		add(elements, GridBagLayoutUtils.constraint(1, 1, 10));
		add(numPlayersPanel, GridBagLayoutUtils.constraint(1, 0, 0));
		add(buttonsContainer, GridBagLayoutUtils.constraint(0, 2, 0));
		
		revalidate();
		repaint();
	}
	
	private void setController(BoardCreationController boardCreationController) {
		controller = boardCreationController;
	}
	
	private void createButtonsContainer() {

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.red);
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		
		playButton = new JButton("Play");
		playButton.setBackground(Color.blue);
		
		playButton.addActionListener(e -> {
			
			numberPlayers = sliderNumPlayers.getValue();
			//TODO check if the board has 5 checkpoints
			
			if(enoughCheckpoints()) {
				controller.startGame(newBoard, numberPlayers);
			}else {
				JOptionPane.showMessageDialog(this, "Please ensure there are 5 checkpoints in the board!", "Error starting game", JOptionPane.ERROR_MESSAGE);
			}
			
			
		});
		
		cancelButton.addActionListener(e -> {
			controller.initiateSetupMenu();
		}); 
		
		saveButton.addActionListener(e -> {
			//call method in controller that given a board of cells creates a text file
			JButton selectedSave = (JButton) e.getSource();
			
			
			try {
				newBoard = controller.getCreatedBoard();
				if(enoughCheckpoints()) {
					createTextFile();
				}else {
					JOptionPane.showMessageDialog(this, "Please ensure there are 5 checkpoints in the board!", "Error saving board", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			selectedSave.setEnabled(false);
			
		}); 
		
		//CREATE CONTAINER FOR BUTTONS
		buttonsContainer = new JPanel();
		buttonsContainer.setLayout(new GridBagLayout());
		buttonsContainer.add( saveButton, GridBagLayoutUtils.constraint(0, 1, 5) );
		buttonsContainer.add( cancelButton, GridBagLayoutUtils.constraint(0, 0, 5) );
		buttonsContainer.add( playButton, GridBagLayoutUtils.constraint(1, 0, 5) );
		
		
	}
	
	private void createSliderPlayers() {
		sliderNumPlayers = new JSlider(2,8,2);
		sliderNumPlayers.setMajorTickSpacing(1);
		sliderNumPlayers.setPaintLabels(true);
		
		numPlayersPanel = new JPanel();
		numPlayersPanel.setLayout(new GridBagLayout());
		numPlayersPanel.add( new JLabel("No. of players:"), GridBagLayoutUtils.constraint(0, 0, 5) );
		numPlayersPanel.add( sliderNumPlayers, GridBagLayoutUtils.constraint(0, 1, 5) );
	}
	
	private void createTextFile() throws IOException {
		
 
		
		//create new file
		final File dir = new File("boards" + File.separatorChar);
		final String name = "bb2";
		final String fileName = name + ".txt";
		final File file = new File(dir+fileName);
		file.createNewFile();
		
		System.out.println("BOARD CREATED AND ADDED TO DIRECTORY BOARDS");
		
		
		PrintWriter writer = new PrintWriter("boards/bb2.txt", "UTF-8");
//		writer.println("The first line");
//		writer.println("The second line");
//		writer.close();
		
		
		
		for(int i = 0; i < newBoard.getNumRows(); i++) {
			for(int j = 0; j < newBoard.getNumColumns(); j++) {
				
				Character mappedEE;
				EnvironmentElement env;
				
				Position currentPos = new Position(j,i);
				
				if (newBoard.hasEElementAt(currentPos)) {
					
					System.out.println("EE FOUND!");
					
					env = newBoard.getEElementAt(currentPos);	
					
					mappedEE = assignChar(env);
//					mappedEE = 'O';
					System.out.println("MAPPED TO " + mappedEE);
				} else {
					mappedEE = ' ';
				}
				
//				mappedEE = EEToascii.get(env);
				writer.print(mappedEE);
			}
			writer.print("\n");
		}
		
		writer.close();
		
	}
	
	private char assignChar(EnvironmentElement e) {
		
		if (e instanceof ChainingPanel) {
			return 'C';
		} else if (e instanceof ConveyorBelt) {
			
			ConveyorBelt conv = (ConveyorBelt) (e);
			
			if ( conv.getOrientation() == Orientation.UP ) {
				return '^';
			} else if ( conv.getOrientation() == Orientation.RIGHT ) {
				return '>';
			} else if ( conv.getOrientation() == Orientation.LEFT ) {
				return '<';
			} else if ( conv.getOrientation() == Orientation.DOWN ) {
				return 'v';
			} else {
				throw new RuntimeException("Error generating character for ConveyorBelt provided.");
			}
			
			
		} else if (e instanceof Teleporter) {
			
			Teleporter tel = (Teleporter) (e);
			
			if (tel.isSending()) {
				return 'S';
			} else if (!tel.isSending())  {
				return 'T';
			} else {
				throw new RuntimeException("Error generating character for Teleporter provided.");
			}

		} else if (e instanceof Laser) {
			return 'L';
		} else if (e instanceof OilSpill) {
			return 'O';
		} else if (e instanceof ReversalPanel) {
			return 'R';
		} else if (e instanceof RespawnPoint) {
			return 'X';
		} else if (e instanceof Checkpoint) {
			
			Checkpoint cp = (Checkpoint) (e);
			
			if (cp.getNumber()==1) {
				return '1';
			} else if (cp.getNumber()==2)  {
				return '2';
			} else if (cp.getNumber()==3)  {
				return '3';
			} else if (cp.getNumber()==4)  {
				return '4';
			} else if (cp.getNumber()==5)  {
				return '5';
			} else {
				throw new RuntimeException("Error generating character for Checkpoint provided.");
			}

		} else if (e instanceof Gear) {
			
			Gear g = (Gear) (e);
			
			if (g.isCounterClockwise()) {
				return 'A';
			} else if (!g.isCounterClockwise())  {
				return 'K';
			} else {
				throw new RuntimeException("Error generating character for Gear provided.");
			}

		} else if (e instanceof Wall) {
			return 'W';
		} else if (e instanceof Pit) {
			return 'P';
		} else if (e instanceof HealthStation) {
			return 'H';
		} else {
			throw new RuntimeException("Invalid input. Please enter a valid Environment Element.");
		}

	}
	
	private boolean enoughCheckpoints() {
		
		int checkpointCounter = 0;
		EnvironmentElement curr_element;
		
		for(int i = 0; i < newBoard.getNumColumns(); i++) {
			for(int j = 0; j < newBoard.getNumRows(); j++) {
				
				Position p = new Position(j, i);
				
				if(newBoard.hasEElementAt(p)) {
					
					curr_element = newBoard.getEElementAt(p);
					
					if (curr_element instanceof Checkpoint) {
						checkpointCounter ++;
					}
					
					
				}
				
			}
		}
		
		return checkpointCounter == 5;
		
	}
	
	
}
