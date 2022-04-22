package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		elementIDs.add("arrow");
		elementIDs.add("circle");
		elementIDs.add("green_circle");
		elementIDs.add("empty_circle");
		elementIDs.add("heart");
		elementIDs.add("icon");
		
	}
	
	private void createBorders() {
		blackBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
		emptyBorder = BorderFactory.createEmptyBorder();
	}
	
	private void createLayout() {
		elementsLayout = new FlowLayout(FlowLayout.CENTER, 10, 0);
		setLayout(elementsLayout);
	}
	
	private void createElementsButtons() {
		
		for ( String id : elementIDs) {
			
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
			add(Box.createRigidArea(new Dimension(0, 5)));
			
		}
		
	}
	
}