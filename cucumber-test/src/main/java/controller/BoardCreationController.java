package controller;

import java.util.ArrayList;
import java.util.List;

import view.BoardCreationView;
import view.CardSelectionPanel;
import view.MasterView;

public class BoardCreationController {
	
	private ApplicationController application;
	private BoardCreationView view;
	
//	private List<String> elements;
	
	private String selected_element;
	private boolean element_is_selected;
	

	
	
	BoardCreationController(ApplicationController appl){
		application = appl;
		element_is_selected = false;
		
		this.view = new BoardCreationView(this);
	}


	public void display() {
		view.setVisible(true);
	}
	
	public void initiateSetupMenu() {
		
		view.setVisible(false);
		application.initiate();
		
	}
	
	public boolean elementIsActive() {
		
		return element_is_selected;
		
	}
	
	public void setElementIsActive(String id ) {
		if (id == getSelectedElement() ) {
			//set element as nt active
			element_is_selected = false;
			setSelectedElement("NONE");
		} else {
			
			element_is_selected = true;
			setSelectedElement(id);
			
		}
		
		
	}
	
	public String getSelectedElement() {
		
		return selected_element;
		
	}
	
	public void setSelectedElement( String id) {
		
		selected_element = id;
		
	}
	
}
