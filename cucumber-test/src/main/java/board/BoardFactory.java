package board;

import piece_basics.Robot;
import property_changes.PropertyChangeSupport;

public class BoardFactory {
	
	public static Board generateBoard(Difficulty d, Robot[] robots, PropertyChangeSupport pcs)
	{
		if (d.getLevel()==1)
		{
			return new BoardGenerator(robots, pcs).getEasyBoard();
			
		} else if (d.getLevel()==2)
		{
			return new BoardGenerator(robots, pcs).getMediumBoard();
		} else if (d.getLevel()==3)
		{
			return new BoardGenerator(robots, pcs).getHardBoard();
		}
		
		return null;
	}

}
