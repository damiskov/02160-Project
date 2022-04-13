package board;
import java.util.Random;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import piece_basics.Robot;
public class BoardGenerator {
	
	private Board b;
	
	public BoardGenerator(int numObstacles, int numRobots, Robot[] robots)
	{
		b = new Board(12,12);
		b.setNumberOfObstacles(numObstacles);
		EnvironmentElement[] EElist = {new Gear(true), new Gear(false),
										new ConveyorBelt(Orientation.UP), new ConveyorBelt(Orientation.DOWN), new ConveyorBelt(Orientation.RIGHT), new ConveyorBelt(Orientation.LEFT),
										new HealthStation(),
										new Pit(),
										new Wall(),
										new ReversalPanel(),
										new Laser(),
										new OilSpill(),
										new Teleporter()};
		int[] startPositionsX = {5,6,4,7,3,7,2,1};
		
		// Initial placement of robots
		// Will have X between 0-11 and Y between 1-11 (0th row is used for robot spawn points)
		
		for (int i = 0; i < numRobots; i++)
		{
			b.initialPlacement(robots[i], startPositionsX[i], 0);
			
		}
		
		// Placement of obstacles
		int i = 0;
		Random rand = new Random();
		while (i < numObstacles)
		{
			// random position
			int x = rand.nextInt(12);
			int y = 1 + rand.nextInt(11);
			Position p = new Position(x,y);
			// random obstacle
			int o = rand.nextInt(EElist.length);
			if (!b.hasEElementAt(p))
			{
				b.initialPlacement(EElist[o], p);
				i++;
			}
			
		}
		
	}
	
	public Board getBoard()
	{
		return b;
	}

}
