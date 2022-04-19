package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.GridBagLayoutUtils;
import utils.ImageUtils;

public class CardPanel extends JPanel {

	private static final long serialVersionUID = 4888662845263342484L;
	
	private Image move1, move2, move3, turnLeft, turnRight, moveBack, uTurn;
	int card_width;
	int card_height;
	int number_cards;
	int space_between_cards;
	
	int canvas_width;
	int canvas_height;
	
	private List<JButton> hand = new ArrayList<>();
	private List<JButton> orderedCards = new ArrayList<>();
	
	JButton button_b;
	

	public CardPanel() {
		
		//given a hand
		// go through that hand and for each card create a button
		number_cards = 7;
		card_width = 96;
		card_height = 133;
		space_between_cards = 10;
		
		canvas_width = (card_width + space_between_cards) * 9;
		canvas_height = card_height + 2 * space_between_cards;
		
		setPreferredSize(new Dimension(canvas_width, canvas_height));
		
		//create hand
		
		
		// image icons
		ImageIcon move1 = new ImageIcon( createImage("images/move1.png" , card_width, card_height) );
		ImageIcon move2 = new ImageIcon( createImage("images/move2.png" , card_width, card_height) );
		ImageIcon move3 = new ImageIcon( createImage("images/move3.png" , card_width, card_height) );
		ImageIcon turnLeft = new ImageIcon( createImage("images/turnleft.png" , card_width, card_height) );
		ImageIcon turnRight = new ImageIcon( createImage("images/turnright.png" , card_width, card_height) );
		ImageIcon moveBack = new ImageIcon( createImage("images/movebackward.png" , card_width, card_height) );
		ImageIcon uTurn = new ImageIcon( createImage("images/uturn.png" , card_width, card_height) );
		
		
		// create buttons with images according to move
		JButton b1 = new JButton(move1);
		b1.setName("move1");
		hand.add(b1);
		
		JButton b2 = new JButton(turnLeft);
		b2.setName("turnLeft");
		hand.add(b2);
		
		JButton b3 = new JButton(moveBack);
		b3.setName("moveBack");
		hand.add(b3);
		
		JButton b4 = new JButton(move3);
		b4.setName("move3");
		hand.add(b4);
		
		JButton b5 = new JButton(move2);
		b5.setName("move2");
		hand.add(b5);
		
		JButton b6 = new JButton(turnRight);
		b6.setName("turnRight");
		hand.add(b6);
		
		JButton b7 = new JButton(uTurn);
		b7.setName("uTurn");
		hand.add(b7);
		
		
		
		super.setLayout(new FlowLayout());
		
		for (int i = 0; i < hand.size(); i++) {
			
			//set default border 
			hand.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			
			hand.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//refer to JButton clicked
					Object source = e.getSource();
			        if (source instanceof JButton) {
			            JButton btn = (JButton)source;
			           
			            System.out.println("button " + btn.getName() + " clicked" );
						
						
						if (orderedCards.contains(btn)) {
							orderedCards.remove(btn);
							System.out.println("BUTTON REMOVED");
							btn.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
							
							//remove priority text
							btn.setText("");
						} else {
							orderedCards.add(btn);
							System.out.println("BUTTON ADDED");
							btn.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
						}
						
						//print each element name
						for(int i = 0; i < orderedCards.size(); i++) {
					        
				            System.out.println(i + 1 + " -> " + orderedCards.get(i).getName());
				            orderedCards.get(i).setText(String.valueOf(i + 1) );
				     
				        }
			        }
					
			
					
					
				}
				
				
				
			});
			
//	        //add button to JPanel
	        super.add(hand.get(i));
		}
			
		
		
		
		
//        jB.addActionListener(new TheHandler());
		
		

		
	}
	

	
	  
	
	  
	
	private Image createImage (String path, int card_width, int card_height  ) {
		
		ImageIcon image1 = new ImageIcon(path);
        Image image2 = image1.getImage().getScaledInstance(card_width,card_height,0);
		
        return image2;
	}
	
	
//	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}



	
	
