package board;

import piece_basics.Robot;

public class BoardFactory {
	
	public static Board generateBoard(Difficulty d, Robot[] robots)
	{
		if (d.getLevel()==1)
		{
			return new BoardGenerator(robots).getEasyBoard();
			
		} else if (d.getLevel()==2)
		{
			return new BoardGenerator(robots).getMediumBoard();
		} else if (d.getLevel()==3)
		{
			return new BoardGenerator(robots).getHardBoard();
		}
		
		return null;
	}

}
