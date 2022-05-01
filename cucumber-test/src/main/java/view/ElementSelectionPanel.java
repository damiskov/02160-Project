package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.BoardCreationController;
import environment_elements.ChainingPanel;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Pit;
import environment_elements.ReversalPanel;
import environment_elements.Wall;
import utils.ImageUtils;

public class ElementSelectionPanel extends JPanel {
	
	private static final long serialVersionUID = 4888662845263342484L;
	
	private BoardCreationController controller;
	
	int elemWidth = 50;
	int elemHeight = 50;
	int canvas_width;
	int canvas_height;

//	JButton button_b;
	JButton element;
	private Border blackBorder;
	private Border emptyBorder;
	FlowLayout elementsLayout;
	
	private List<String> elementIDs;
	//to track all the selected elements
	List<JButton> elemButtonsList = new ArrayList<>();

	
	public ElementSelectionPanel(BoardCreationController controller) {
		
		setController(controller);
		
		createElementsIDList();
		createBorders();
		createLayout();
		
		createElementsButtons();
	}
	
	/**This method sets the controller attribute to a given controller of type BoardCreationController.   */
	private void setController(BoardCreationController c) {
		controller = c;
	}
	
	
	/**This method initializes the elementIDs attribute as an ArrayList and adds all the strings
	 * that correspond to the images of all the EnvironmentElements, and in some cases to the 
	 * id of an Environment Element (in Environment Elements without variations, i.e, Checkpoint, Teleporter
	 * , ConveyorBelt and Gear */
	private void createElementsIDList() {
		
		elementIDs =  new ArrayList<String>() ;
		
		elementIDs.add(ChainingPanel.ID);
		elementIDs.add(Laser.ID);
		elementIDs.add(OilSpill.ID);
		elementIDs.add(ReversalPanel.ID);
//		elementIDs.add(RespawnPoint.ID);
		
		elementIDs.add(Wall.ID);
		elementIDs.add(Pit.ID);
		elementIDs.add(HealthStation.ID);
		
		//add gears
		elementIDs.add("gear_left");
		elementIDs.add("gear_right");
		
		//add conveyor belts
		elementIDs.add("conveyor_beltD");
		elementIDs.add("conveyor_beltL");
		elementIDs.add("conveyor_beltR");
		elementIDs.add("conveyor_beltU");
		
		//add checkpoints TEMPORARY
		elementIDs.add("checkpoint1");
		elementIDs.add("checkpoint2");
		elementIDs.add("checkpoint3");
		elementIDs.add("checkpoint4");
		elementIDs.add("checkpoint5");
		
		//add teleporters
		elementIDs.add("TeleporterBlue");
		elementIDs.add("TeleporterOrange");
		
	}
	
	private void createBorders() {
		blackBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
		emptyBorder = BorderFactory.createEmptyBorder();
	}
	
	private void createLayout() {
		GridLayout elementsLayout = new GridLayout(0, 5, 1, 1);
		setLayout(elementsLayout);
	}
	
	/**This method goes through each element in the ArrayList elementIDs and creates a button with the
	 * correct image (whose name in the path is the same as the element in the ArrayList elementIDs) for its icon and sets its name to the element. */
	private void createElementsButtons() {
		
		for ( String id : elementIDs) {
			
			//check if conveyor belt to rotate the icon
			
			
			
			ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("/" + id + ".png", elemWidth, elemHeight));
			element = new JButton(icon);
			
			element.setPreferredSize(new Dimension(icon.getIconWidth()*4/3, icon.getIconHeight()*4/3));
			
			element.setAlignmentX(Component.CENTER_ALIGNMENT);
			element.setName(id);
			
			element.addActionListener(e -> {
				System.out.println("Element clicked");
				
				//set the element_is_selected attribute in the controller to true and the
				//selected_element attribute to the id/name of the button that is clicked
				controller.setElementIsActive( id ) ;
				
				JButton selected = (JButton) e.getSource();
				selected.setBorder(blackBorder);
				
				//remove the border for all the buttons (in elemButtonsList) that are not the one clicked
				for (JButton elem : elemButtonsList) {

					if (elem != e.getSource()) {
						elem.setBorder(emptyBorder);
					}
				}
			});
			
			//add the created button to elemButtonsList
			elemButtonsList.add(element);
			//add the created button to the ElementSelectionPanel
			add(element);
			
		}
		
	}
	
}
