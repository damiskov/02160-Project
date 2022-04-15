package board;

import piece_basics.Robot;

public class BoardFactory {
	
	public static Board generateBoard(Difficulty d, int numRobots, Robot[] robots)
	{
		if (d.getLevel()==1)
		{
			return new BoardGenerator(20, numRobots, robots).getBoard();
			
		} else if (d.getLevel()==2)
		{
			return new BoardGenerator(40, numRobots, robots).getBoard();
		} else if (d.getLevel()==3)
		{
			return new BoardGenerator(60, numRobots, robots).getBoard();
		}
		
		return null;
	}

}
