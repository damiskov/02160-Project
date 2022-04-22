package board;
import java.util.Random;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;

public class BoardGenerator {
	
	private Board b;
	Robot[] robots;
	String[] easyFiles = {"E1", "E2", "E3"};
	String[] mediumFiles = {"M1", "M2", "M3"};
    String[] hardFiles = {"H1", "H2", "H3"};
    String[] customFiles = {};
 	Position[] startingPositions = {new Position(10,6),
									new Position(10,7),
									new Position(10,5),
									new Position(10,8),
									new Position(10,4),
									new Position(10,8),
									new Position(10,3),
									new Position(10,9)
			
	};
	
	public BoardGenerator(Robot[] robots)
	{
		this.robots = robots;
	}
	
	public Board getBoard()
	{
		return b;
	}



	public Board getEasyBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(easyFiles[x]);
		b.setDifficulty(new Difficulty(1));
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}



	public Board getMediumBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(mediumFiles[x]);
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
		b = BR.retrieveBoard(hardFiles[x]);
		b.setDifficulty(new Difficulty(3));
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}

}
