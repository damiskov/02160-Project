package board;
import java.util.Random;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;

public class BoardGenerator {
	
	private Board b;
	Robot[] robots;
	String[] files = {"E1", "E2", "E3", "M1", "M2", "M3", "H1", "H2", "H3"};
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
	
	public static void main(String[] args)
	{
		String[] files = {"E1", "E2", "E3", "M1", "M2", "M3", "H1", "H2", "H3"};
		BoardRetriever BR = new BoardRetriever();
		for (String i : files)
		{
			System.out.println(i);
			BR.retrieveBoard(i);
			
		}
	}
	
	
	public Board getBoard()
	{
		return b;
	}



	public Board getEasyBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(files[x]);
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}



	public Board getMediumBoard() {
		Random rand = new Random();
		int x = rand.nextInt(3,6);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(files[x]);
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}



	public Board getHardBoard() {
		Random rand = new Random();
		int x = rand.nextInt(6, 9);
		BoardRetriever BR = new BoardRetriever();
		b = BR.retrieveBoard(files[x]);
		for (int i = 0; i < robots.length; i++)
		{
			b.initialPlacement(robots[i], startingPositions[i]);
		}
		return b;
	}

}
