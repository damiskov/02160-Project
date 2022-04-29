package board;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import environment_elements.*;
import piece_basics.EnvironmentElement;
import piece_basics.Orientation;
import property_changes.PropertyChangeSupport;

public class BoardRetriever  
{  
	
	public static Board retrieveBoard(String filename, Game game)  
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
		try {
			obj = new BufferedReader(new FileReader(doc));
			while (obj.readLine() != null) {
				str = obj.readLine();
				for (int i = 0; i < str.length(); i++)
				{
					if (EEFactory.getEE(str.charAt(i))==null) {
						b.initialPlacement(EEFactory.getEE(str.charAt(i)), new Position(i,j));
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
 