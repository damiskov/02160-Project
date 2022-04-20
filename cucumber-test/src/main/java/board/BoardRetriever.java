package board;

import java.io.*;
import java.util.HashMap;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;

public class BoardRetriever  
{  
	
	
	private HashMap<Character, EnvironmentElement> asciiToEE = new HashMap<>();
	private void initialiseHM()
	{
		asciiToEE.put('W', new Wall());
		asciiToEE.put('P', new Pit());
		asciiToEE.put('O', new OilSpill());
		asciiToEE.put('T', new Teleporter());
		asciiToEE.put('X', new RespawnPoint());
		asciiToEE.put('^', new ConveyorBelt(Orientation.UP));
		asciiToEE.put('>', new ConveyorBelt(Orientation.RIGHT));
		asciiToEE.put('<', new ConveyorBelt(Orientation.LEFT));
		asciiToEE.put('v', new ConveyorBelt(Orientation.DOWN));
		asciiToEE.put('H', new HealthStation());
		asciiToEE.put('-', new Laser());
		asciiToEE.put('L', new Gear(true));
		asciiToEE.put('G', new Gear(false));
		asciiToEE.put('R', new ReversalPanel());
		asciiToEE.put('C', new ChainingPanel());
		asciiToEE.put(' ', null);
		
	}
	
	public BoardRetriever()
	{
		this.initialiseHM();
	}
	
	public Board retrieveBoard(String filename) 
	{
		Board b = new Board(12,12);
		String path = "boards\\" + filename;
		// Open the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		//Read File Line By Line
		try {
			int j = 0;
			while ((strLine = br.readLine()) != null)   {
				for (int i = 0; i < strLine.length(); i++)
				{
					if (!(asciiToEE.get(strLine.charAt(i))==null))
					{
						b.initialPlacement(asciiToEE.get(strLine.charAt(i)), i, j);
					}
					
				}
				j++;
			  
			  
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Close the input stream
		try {
			fstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		
	}
	
		
		
}  
 