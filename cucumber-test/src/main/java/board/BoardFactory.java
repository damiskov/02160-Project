package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import piece_basics.Robot;
import board.EEFactory;


public class BoardFactory {
	
	
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
	private Board b;
	
	
	public Board generateBoard(Difficulty d, Robot[] robots, Game game)
	{
		if (d.getLevel()==1)
		{
			
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(easyFiles[x], game);
			b.setDifficulty(new Difficulty(1));
			for (int i = 0; i < robots.length; i++)
			{
				System.out.println(robots[i]);
				b.initialPlacement(robots[i], startingPositions[i]);
			}
			return b;
			
			
		} else if (d.getLevel()==2)
		{
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(mediumFiles[x], game);
			b.setDifficulty(new Difficulty(2));
			for (int i = 0; i < robots.length; i++)
			{
				b.initialPlacement(robots[i], startingPositions[i]);
			}
			return b;
			
		} else if (d.getLevel()==3)
		{
			
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(hardFiles[x], game);
			b.setDifficulty(new Difficulty(3));
			for (int i = 0; i < robots.length; i++)
			{
				b.initialPlacement(robots[i], startingPositions[i]);
			}
			return b;
		}
			
		
		return null;
	}

	
	/*
	 * retrieveBoard
	 * 
	 * - Takes a filename and a game
	 * - Returns a Board Object 
	 */
	
	private Board retrieveBoard(String filename, Game game)  
	{
		
		
		String path = "boards/" + filename + ".txt";
		int numRows=0;
		int numCols=0;
		File doc = new File(path);
		
		// Finding dimensions of board
		
		BufferedReader obj = null;
		try {
			obj = new BufferedReader(new FileReader(doc));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String str;
		try {
			while ((str = obj.readLine()) != null) {
				numRows++;
				numCols = str.length();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Placing environment elements on the board
		
		Board b = new Board(numRows, numCols, game);
		int j = 0;
		EEFactory EEFact = new EEFactory();
		try {
			obj = new BufferedReader(new FileReader(doc));
			while (obj.readLine() != null) {
				str = obj.readLine();
				for (int i = 0; i < str.length(); i++)
				{
					if (EEFact.getEE(str.charAt(i))!=null) {
						b.initialPlacement(EEFact.getEE(str.charAt(i)), new Position(i,j));
					}
				}
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return b;
		
	}
}
