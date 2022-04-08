package board_GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI {
	

	
	public GUI(Image imgs[]) {
		int cell_width = 64;
		int cell_height = 64;
		

	

		//panel1.set[Preferred/Maximum/Minimum]Size()
		
		//create a robot
		Robot r = new Robot(64, 64);
		r.setOrientation(Orientation.UP);
		r.setImage(imgs[0]);
		
		
		JFrame frame = new JFrame();
		frame.setBounds(10, 10, 512, 512);
		

	
		
//		//Left button
//		JButton buttonL = new JButton("Left");
////        buttonL.addActionListener((ActionListener) this);
//        buttonL.setActionCommand("rotate left");
//        
//        //Right button
//  		JButton buttonR = new JButton("Right");
////	    buttonR.addActionListener((ActionListener) this);
//	    buttonR.setActionCommand("rotate right");
//	    
//	    //Forward button
//  		JButton buttonF = new JButton("Forward");
////  		buttonF.addActionListener((ActionListener) this);
//  		buttonF.setActionCommand("move forward");
//	    
//  		//Backward button
//		JButton buttonB = new JButton("Backward");
////		buttonB.addActionListener((ActionListener) this);
//		buttonB.setActionCommand("move backward");
        
        
        
//        frame.setLayout(new FlowLayout());
		//print board
		Board board = new Board(frame, cell_width, cell_height);
		board.printBoard(imgs, r, cell_width, cell_height);
//        frame.add(buttonL);
        
        
		
		
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);

	}
	
//actions for buttons
//    public void actionPerformed(ActionEvent ae, Graphics g) {
//        String action = ae.getActionCommand();
//        if (action.equals("rotate left")) {
//            //rotate robot
//        	
//        } if (action.equals("rotate right")) {
//            //rotate robot
//        } if (action.equals("move forward")) {
//            //move forward
//        	g.clearRect(0, 0, 0, 0);
//        	
//        } if (action.equals("move backward")) {
//            //move backward
//        }
//    }
    

	public static void main(String[] args) throws IOException {
		BufferedImage all = ImageIO.read(new File("/Users/mac/Desktop/robotr.png"));
		
		Image imgs[] = new Image[8];
		
		imgs[0] = all.getSubimage(1, 10, 50, 50).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
		
		int ind = 0;
		
		
		
		for(int y = 0; y < 157; y += 80) {
			for(int x = 0; x < 320; x += 80) {
				imgs[ind] = all.getSubimage(x, y, 80, 77).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
				ind++;
			}
	
		}
		
		
		
		new GUI(imgs);

	}
	

}



