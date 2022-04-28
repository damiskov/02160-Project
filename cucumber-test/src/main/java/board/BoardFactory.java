package board;

import piece_basics.Robot;
import property_changes.PropertyChangeSupport;

public class BoardFactory {
	
	public static Board generateBoard(Difficulty d, Robot[] robots, Game game)
	{
		if (d.getLevel()==1)
		{
			return new BoardGenerator(robots, game).getEasyBoard();
			
		} else if (d.getLevel()==2)
		{
			return new BoardGenerator(robots, game).getMediumBoard();
		} else if (d.getLevel()==3)
		{
			return new BoardGenerator(robots, game).getHardBoard();
		}
		
		return null;
	}

}
