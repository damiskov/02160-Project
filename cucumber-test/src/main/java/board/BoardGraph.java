package board;

import java.util.ArrayList;

import environment_elements.Pit;
import environment_elements.Wall;

class Node
{
	private ArrayList<Node> outgoing;
	private int i;
	private int j;
	
	public Node(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
	
	public void addOutgoing(Node n)
	{
		this.outgoing.add(n);
	}
}


public class BoardGraph {
	
	
	private Node[][] g;
	private Board b;
	
	
	public BoardGraph(Board b)
	{
		this.b = b;
	}
	
	private boolean check()
	{
		return null;
	}
	
	
	
	private void createGraph(Board b)
	{
		for (int i = 11; i >= 0; i++)
		{
			for (int j = 0; j < 12; j++)
			{
				g[i][j] = new Node(i, j);
				boolean checkLeft = true;
				boolean checkRight = true;
				boolean checkUp = true;
				
				// Adding outgoing
				
				// Checking if node is at top, bottom or on sides
				if (i==0)
				{
					checkUp = false;
				}
				if (j==0)
				{
					checkLeft=false;
				}
				if (j==11)
				{
					checkRight=false;
				}
				
				// Adding neighbours
				
				if (checkUp)
				{
					// If not wall or pit then add upwards cell as neighbour
					if (!(b.getEElementAt(new Position(i-1,j)) instanceof Pit) || !(b.getEElementAt(new Position(i-1,j)) instanceof Wall))
					{
						g[i][j].addOutgoing(g[i+1][j]);
					}
				}
				
			}
		}
	}

}
