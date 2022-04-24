package board;

import java.io.*;
import java.util.HashMap;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import property_changes.PropertyChangeSupport;

public class BoardRetriever  
{  
	
	
	private HashMap<Character, EnvironmentElement> asciiToEE = new HashMap<>();
	private void initialiseHM()
	{
		// Initialising sending and receiving teleporter
		Teleporter T1 = new Teleporter();
		T1.setSending(true);
		Teleporter T2 = new Teleporter();
		T2.setSending(false);
		T1.setReceiving(T2);
		
		asciiToEE.put('W', new Wall());
		asciiToEE.put('P', new Pit());
		asciiToEE.put('O', new OilSpill());
		asciiToEE.put('S', T1);
		asciiToEE.put('T', T2);
		asciiToEE.put('X', new RespawnPoint());
		asciiToEE.put('^', new ConveyorBelt(Orientation.UP));
		asciiToEE.put('>', new ConveyorBelt(Orientation.RIGHT));
		asciiToEE.put('<', new ConveyorBelt(Orientation.LEFT));
		asciiToEE.put('v', new ConveyorBelt(Orientation.DOWN));
		asciiToEE.put('H', new HealthStation());
		asciiToEE.put('L', new Laser());
		asciiToEE.put('A', new Gear(true));
		asciiToEE.put('K', new Gear(false));
		asciiToEE.put('R', new ReversalPanel());
		asciiToEE.put('C', new ChainingPanel());
		asciiToEE.put('1', new Checkpoint(1));
		asciiToEE.put('2', new Checkpoint(2));
		asciiToEE.put('3', new Checkpoint(3));
		asciiToEE.put('4', new Checkpoint(4));
		asciiToEE.put('5', new Checkpoint(5));
		
		asciiToEE.put(' ', null);
		
	}
	
	public BoardRetriever()
	{
		this.initialiseHM();
	}
	
	public Board retrieveBoard(String filename, PropertyChangeSupport pcs) 
	{
		Board b = new Board(12, 12, pcs);
		b.setName(filename);
		String path = "boards/" + filename + ".txt";
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
						System.out.println(asciiToEE.get(strLine.charAt(i)));
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
 