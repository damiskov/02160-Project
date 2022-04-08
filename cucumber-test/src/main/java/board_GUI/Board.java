package board_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board {
		
	//create a robot 
		Graphics g;
		
		
		public	String[][] boardMatrix;
		JFrame frame;
		
		Board (JFrame f, int cell_width, int cell_height){
			boardMatrix = new String[8][8];
			frame = f;
			
			//template matrix
			String [][] matrix = {
					{"", "", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""},
					{"", "r", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""},
					{"", "", "", "", "", "", "", ""}	
			};
			
			//create instances of Piece object for each element of the board Matrix from template
			
			for (int y = 0; y < matrix.length; y++) {
				
				for(int x = 0; x < matrix[y].length; x++) {
					
					boardMatrix[y][x] = matrix[y][x];
					
				}
				
			}
			
		}
		
		void printBoard(Image imgs[], Robot r, int cell_width, int cell_height) {
			
			
			//print game board
			JPanel pn = new JPanel() {
				@Override 
				public void paint(Graphics g) {
					
					boolean white = true;
					
					for (int y = 0; y < boardMatrix.length; y++) {
						for(int x = 0; x < boardMatrix[y].length; x++) {
							if(white) {
								
								g.setColor(Color.white);
								
							} else {
								g.setColor(Color.black);
							}
							
							g.fillRect(x*cell_width, y*cell_height, cell_width, cell_height);
							
							white = !white;
						}
						white = !white;
						
						
						g.drawImage(r.getImage(), r.x, r.y, this );
						
					}
					
				}
				
				
			};
			
		
			//buttons panel
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout( new GridLayout(4,1) );
			buttonPanel.setBounds(0,0, 50, 50);
			buttonPanel.setSize(50, 50);
			
			JLabel labelOrientation = new JLabel("Orientation: UP");
				  
			JButton buttonL = new JButton("Left");
			JButton buttonR = new JButton("Right");
			JButton buttonB = new JButton("Backward");
			JButton buttonF = new JButton("Forward");
			
			buttonPanel.add(labelOrientation);
			buttonPanel.add(buttonL);
			buttonPanel.add(buttonR);
			buttonPanel.add(buttonB);
			buttonPanel.add(buttonF);
			
			buttonPanel.setMaximumSize(new Dimension(1000, 100));
			
			buttonF.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  r.moveForward();
					  pn.repaint();
				
				  }
				});
			
			buttonB.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  r.moveBackward();
					  pn.repaint();
				  }
				});
			
			buttonR.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  r.rotate("right");
					  labelOrientation.setText("Orientation: " + r.getOrientation());
//					  r.setOrientation(null);
				  }
				});
			
			buttonL.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  r.rotate("left");
					  labelOrientation.setText("Orientation: " + r.getOrientation());
					  
				  }
				});
			
			
			
			
			
			JPanel container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			
			
			//add panels to container 
			container.add(pn);
			container.add(buttonPanel);
			
			frame.add(container);
//			frame.add(pn);
			
		}
		
		
		
	
}
