/**
 * Class: HomeWork 3
 * 
 * 
 * @version 1.0 
 * Course: ITECH 2150 Fall 2019 
 * Written: October 8, 2019 
 * Purpose: Create a read and write program that prints out the total number of words, total number of “the”,
 *  and total number of “a” or “an” 
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class HomeWork3 {

	public static void main(String[] args) throws FileNotFoundException {

		// define my file variables
		File  inFile = null;
		PrintWriter pw  = null;
		FileReader fr = null;
		Scanner input = null;
		JFileChooser fileChooser = null;
		// declare the total  wordcount to 0
		int wordCount = 0; 
		// declare a the total "the" to 0
		int the = 0;
		// declare the total a or an to to 0
		int AorAn = 0;
	try {

		//filechooser
		
		fileChooser = new JFileChooser();
		 if (fileChooser.showOpenDialog(null)
			        == JFileChooser.APPROVE_OPTION) {
			 
			  inFile = fileChooser.getSelectedFile();
			 pw  = new PrintWriter("stats.txt");
			 	fr = new FileReader(inFile);
			 input = new Scanner(fr);
		      input.useDelimiter("[^a-zA-Z]+");
		      // Read text from the input
		      while (input.hasNext())
		      {
		         String aWord = input.next();
		         // convert to lower case
		         aWord = aWord.toLowerCase();

		         // process the word 
		       //the total "the" and incrementing by one
		         if(aWord.equals("the"))
		         {
		        	 the++;
		         }
		         //the total "a" and incrementing by one
		         if(aWord.equals("a"))
		         {
		        	 AorAn++;
		         }
		       //the total "an" and incrementing by one
		         if(aWord.equals("an"))
		         {
		        	 AorAn++;
		         }
		         
		      }
		      //printer getting the name of the file, the total wordcount, total "the","a" and "an"
			pw.println("The file name is : "+inFile.getName());
			pw.println("The total number of words is " +wordCount);
			pw.println("The total number of the is " + the);
			pw.println("The total number of a or an is "+AorAn);
		 }
	}
	//catch exception handling
	catch(IOException ex) 
	{
		System.out.println("Error reading file ");
		ex.printStackTrace();
	}
	// close my file
	finally {
		
		pw.close();
		input.close();
	}
	System.out.println("All stats are in written in stats file");
	
	}// end of main
	
}


