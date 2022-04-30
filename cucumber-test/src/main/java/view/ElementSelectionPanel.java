package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.BoardCreationController;
import environment_elements.ChainingPanel;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Pit;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.Orientation;
import piece_basics.Robot;
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
	
	private void setController(BoardCreationController c) {
		controller = c;
	}
	
	private void createElementsIDList() {
		
		elementIDs =  new ArrayList<String>() ;
		
		elementIDs.add(ChainingPanel.ID);
		
		elementIDs.add(Teleporter.ID);
		elementIDs.add(Laser.ID);
		elementIDs.add(OilSpill.ID);
		elementIDs.add(ReversalPanel.ID);
		elementIDs.add(RespawnPoint.ID);
		
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
//		GridBagLayout TEMPelementsLayout = new GridBagLayout();
		GridLayout TEMPelementsLayout = new GridLayout(0, 5, 1, 1);
//		elementsLayout = new FlowLayout(FlowLayout.CENTER, 10, 0);
		setLayout(TEMPelementsLayout);
		
//		setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getMinimumSize().height));
	}
	
	private void createElementsButtons() {
		
		for ( String id : elementIDs) {
			
			//check if conveyor belt to rotate the icon
			
			
			
			ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("images/" + id + ".png", elemWidth, elemHeight));
			element = new JButton(icon);
			element.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			element.setAlignmentX(Component.CENTER_ALIGNMENT);
			element.setName(id);
			
			element.addActionListener(e -> {
				System.out.println("Element clicked");
				
				controller.setElementIsActive( id ) ;
				
				JButton selected = (JButton) e.getSource();
				selected.setBorder(blackBorder);
				selected.setPreferredSize(new Dimension(icon.getIconWidth()*4/3, icon.getIconHeight()*4/3));
				
				for (JButton elem : elemButtonsList) {

					if (elem != e.getSource()) {
						elem.setBorder(emptyBorder);
						elem.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
					}
				}
			});
			
			elemButtonsList.add(element);
			add(element);
//			add(Box.createRigidArea(new Dimension(0, 5)));
			
		}
		
	}
	
}
