package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;

	public BoardPanel(int rows, int columns) {
		setLayout(new GridLayout(rows, columns, 0, 0));
		
		for (int i = 0; i < rows*columns; i++) {
			JPanel panel = new ImagePanel("images/tile.png");
//			panel.setPreferredSize(new Dimension(30, 30));
			add(panel);
		}
		
	}
}
