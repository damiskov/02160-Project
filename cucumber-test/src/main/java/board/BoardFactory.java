package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Random;

import environment_elements.RespawnPoint;
import piece_basics.Robot;

public class BoardFactory {

	private String[] easyFiles = {"E1", "E2", "E3"};
	private String[] mediumFiles = {"M1", "M2", "M3"};
	private String[] hardFiles = {"H1", "H2", "H3"};
	private Position[] startingPositions = {new Position(6,0),
			new Position(7,0),
			new Position(5, 0),
			new Position(8,0),
			new Position(4,0),
			new Position(9,0),
			new Position(3,0),
			new Position(2,0)

	};
	
	private Board b;
		
	public Board generateBoard(Difficulty d, Robot[] robots, Game game)
	{
		if (d.getLevel()==0)
		{
			b = retrieveBoard("custom_board", game);
			b.setDifficulty(new Difficulty(0));
			for (int i = 0; i < robots.length; i++)
			{
				System.out.println(robots[i]);
				b.initialPlacement(robots[i], startingPositions[i]);
				RespawnPoint r = new RespawnPoint();
				b.initialPlacement(r, startingPositions[i]);
				robots[i].setRespawnPoint(r);
			}
			return b;		
		} 
		else if (d.getLevel()==1)
		{
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(easyFiles[x], game);
			b.setDifficulty(new Difficulty(1));
			for (int i = 0; i < robots.length; i++)
			{
				System.out.println(robots[i]);
				b.initialPlacement(robots[i], startingPositions[i]);
				RespawnPoint r = new RespawnPoint();
				b.initialPlacement(r, startingPositions[i]);
				robots[i].setRespawnPoint(r);
			}
			return b;			
		} 
		else if (d.getLevel()==2)
		{
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(mediumFiles[x], game);
			b.setDifficulty(new Difficulty(2));
			for (int i = 0; i < robots.length; i++)
			{
				System.out.println(robots[i]);
				b.initialPlacement(robots[i], startingPositions[i]);
				RespawnPoint r = new RespawnPoint();
				b.initialPlacement(r, startingPositions[i]);
				robots[i].setRespawnPoint(r);
			}
			return b;		
		} 
		else if (d.getLevel()==3)
		{		
			Random rand = new Random();
			int x = rand.nextInt(3);
			b = retrieveBoard(hardFiles[x], game);
			b.setDifficulty(new Difficulty(3));
			for (int i = 0; i < robots.length; i++)
			{
				System.out.println(robots[i]);
				b.initialPlacement(robots[i], startingPositions[i]);
				RespawnPoint r = new RespawnPoint();
				b.initialPlacement(r, startingPositions[i]);
				robots[i].setRespawnPoint(r);
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
		BufferedReader obj = null;
		
		if (filename.equals("custom_board")) {
			try {
				String path = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
				path = path.substring(0, path.lastIndexOf('/')) + "/custom_board.txt";
				obj = new BufferedReader(new FileReader(new File(path)));
			} catch (URISyntaxException | FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} else {
			String path = "/" + filename + ".txt";
			InputStream doc = BoardFactory.class.getResourceAsStream(path);
			obj = new BufferedReader(new InputStreamReader(doc));
		}
		
		// Placing environment elements on the board
		
		Board b = new Board(12, 12, game);
		int j = 0;
		String str;
		EEFactory EEFact = new EEFactory();
		try {
			while ((str = obj.readLine())!= null) {
				for (int i = 0; i < str.length(); i++)
				{
					if (EEFact.getEE(str.charAt(i))!=null) {
						b.initialPlacement(EEFact.getEE(str.charAt(i)), new Position(i,11-j));
					}
					
				}
				j++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return b;
		
	}
}
