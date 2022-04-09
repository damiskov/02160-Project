package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = -2140843137512577992L;
	
	private ImagePanel[][] matrix;

	public BoardPanel(int rows, int columns) {
		setLayout(new GridLayout(rows, columns, 0, 0));
		
		matrix = new ImagePanel[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				ImagePanel panel = new ImagePanel("images/tile.png");
				//			panel.setPreferredSize(new Dimension(30, 30));
				add(panel);
				matrix[i][j] = panel;
			}
		}
		
	}
}
