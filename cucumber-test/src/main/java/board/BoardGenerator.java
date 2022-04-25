package board;
import java.util.Random;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;
import property_changes.PropertyChangeSupport;

public class BoardGenerator {
	
	private Board b;
	private Robot[] robots;
	private PropertyChangeSupport propertyChangeSupport;
	private String[] easyFiles = {"E1", "E2", "E3"};
	private String[] mediumFiles = {"M1", "M2", "M3"};
	private String[] hardFiles = {"H1", "H2", "H3"};
	private String[] customFiles = {};
	private Position[] startingPositions = {new Position(6,11),
									new Position(7,11),
									new Position(5,11),
									new Position(8,11),
									new Position(4,11),
									new Position(9,11),
									new Position(3,11),
									new Position(10,11)
			
	};
	
	public BoardGenerator(Robot[] robots, PropertyChangeSupport propertyChangeSupport)
	{
		this.robots = robots;
		this.propertyChangeSupport = propertyChangeSupport;
	}
	
//	public Board getBoard()
//	{
//		return b;
//	}



	public Board getEasyBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(easyFiles[x], propertyChangeSupport);
		b.setDifficulty(new Difficulty(1));
		for (int i = 0; i < robots.length; i++)
		{
			System.out.println(robots[i]);
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}



	public Board getMediumBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(mediumFiles[x], propertyChangeSupport);
		b.setDifficulty(new Difficulty(2));
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}



	public Board getHardBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(hardFiles[x], propertyChangeSupport);
		b.setDifficulty(new Difficulty(3));
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}

}
