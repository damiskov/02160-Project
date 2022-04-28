package board;
import java.util.Random;

import piece_basics.Robot;

public class BoardGenerator {
	
	private Board b;
	private Robot[] robots;
	private Game game;
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
	
	public BoardGenerator(Robot[] robots, Game game)
	{
		this.robots = robots;
		this.game = game;
	}
	
//	public Board getBoard()
//	{
//		return b;
//	}



	public Board getEasyBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(easyFiles[x], game);
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
		b = BR.retrieveBoard(mediumFiles[x], game);
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
		b = BR.retrieveBoard(hardFiles[x], game);
		b.setDifficulty(new Difficulty(3));
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}

}
