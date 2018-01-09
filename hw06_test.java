/*
NAME: Christina Sadak
ASSIGNMENT: CSCI 392 hw5
PURPOSE: reads the lines in a file, determines if the value is an integer. If is an integer, send to add_value function to add to array. If not, ignore it. Then determines how many values are in each range of values (determined by user) and uses the histogram class to make and output a histogram based on the values in the file
*/

import java.io.*;

public class hw06_test
{
	public static void main(String[] args) throws IOException
	{
		String fname;
		String dataline;

		BufferedReader inputFile;
		FileReader freader;

		//promt user for the name of the file
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(stdin);

		System.out.print("Enter the name of a file to process: ");
		fname = keyboard.readLine();

		//open the data file
		try//tries to open the file name, if it fails, it moves to the catch block
		{
			freader = new FileReader(fname);
			inputFile = new BufferedReader(freader);
		}
		catch(IOException e)//if there is an exception thrown and the file won't open, this outputs an error message and exits main
		{
			System.out.println("Error: Unable to open file: "+ fname);
			System.out.println("Cannot recover from error. Exiting.");
			return;
		}

		int count = 0;//intializes count variable to zero
    int nextvalue;

		dataline = inputFile.readLine();//intial read


    //STARTS HISTOGRAM CLASS NEW STUFF
    //int linecount;   // num of lines in files = max num of data values

    while( dataline != null)//reads until the end of the file
    {
     try//tries to parse the entry in the file and throws an exception if the entry is not an integer
     {
       Integer.parseInt(dataline);
       count++;
     }
     catch(NumberFormatException nfe)//if the entry in the file is not an integer, this ignores that entry and moves on to the next item
     {

     }
     dataline = inputFile.readLine();//reads the next line and continues in the while loop
   }

   if(count==0)//if count is 0 then no integers were read in
   {
     System.out.println("There are no integers in this file.");
   return; //exits main because we only work with integers
   }

   inputFile.close();//closes file so it can be read from again

   FileReader freader2 = new FileReader(fname);
   BufferedReader inputFile2 = new BufferedReader(freader2);


         // create a graph instance
         histogram myHistogram;
         myHistogram = new histogram(count);

	 vertical_histogram myVertHistogram;
	 myVertHistogram = new vertical_histogram(count);

         // read the lines of the file

         for (int i=0; i<=count; i++)
         {
            try
            {
              nextvalue = Integer.parseInt(inputFile2.readLine());
              myHistogram.add_value(nextvalue);
	      myVertHistogram.add_value(nextvalue);
            }
            catch (Exception e)
            {
            }
         }
         inputFile.close();

	int rangeSize;

	       System.out.println(" \n");
         System.out.println ("Done reading from file");
				 System.out.println(" \n");

         // output the horizontal histogram twice

         System.out.println ("Histogram One - grouping = 10");
         System.out.println(" \n");
         myHistogram.write();//calls the write function of histogram
         System.out.println("\n");

				 System.out.println ("Histogram Two - grouping = 20");
         myHistogram.grouping = 20;
	 		 	 myHistogram.write();
	 	 		 System.out.println(" \n");

				 System.out.println("Histogram Three - grouping = PICK");
	 		 	 System.out.println("Bar range size?");
	 		   rangeSize = Integer.parseInt(keyboard.readLine());//takes in the user value for the range size
	 		   myHistogram.grouping = rangeSize;//sets the grouping variable in histogram.java to equal rangeSize
         myHistogram.write();
				 System.out.println(" \n");

	 		   System.out.println("Vertical Histogram One - grouping = 10");
	       myVertHistogram.write();
	       System.out.println(" \n");

	 		   System.out.println("Vertical Histogram Two - grouping = 15");
	  	   myVertHistogram.grouping = 15;
	 		   myVertHistogram.write();

			System.out.println("Vertical Histogram Three - gropuing = PICK");
			rangeSize = Integer.parseInt(keyboard.readLine());
			myVertHistogram.grouping = rangeSize;
			myVertHistogram.write();
}
}
