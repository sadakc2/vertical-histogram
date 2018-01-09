/*
NAME: Christina Sadak
ASSIGNMENT: Java homework 5 histogram class
PURPOSE: This is the histogram class which contains the methods histogram (constructor), add_value, and write. The parameterized constructor takes the maximum values that will be in the array to make an array of the appropriate size. It also akes the default group range 10. The add_value method is called in main each time we want to add a value to the array. It includes an index which is updated each time a value is added. The write method will be explained above the method itself.
*/

import java.util.Arrays;
public class histogram
{

      //private values
      protected int maximumValues;
      protected int valuetoGraph;
      protected int[] intArray;


      //public values and methods
      public int index = 0;
      public int grouping;

      public histogram(int maxVals) //constructor
      {
        maximumValues = maxVals;

    	intArray = new int[maximumValues];//creates an array with the correct amount of space allocated

	grouping = 10;//sets default grouping to a range of 10
      }

      public void add_value(int valtoGraph)
      {
         valuetoGraph = valtoGraph;

         intArray[index] = valuetoGraph;

         index++;//updating index to add values to the correct index of the array
      }

      public void write()
      {

        Arrays.sort(intArray);//sorts the array from lowest to highest

        int largestVal;
        largestVal= intArray[maximumValues-1];//the largest value will be in the last index since the array is sorted

	       int numberIntervals = (largestVal/grouping)+1; //rounds (largestVal/grouping) down to the whole number since it is stored as an int and adds 1 to account for the 0th interval of 0-grouping

	       int minLook = 0;//lower limit of range to check for
	       int maxLook = grouping-1;//upper limit of range to check for

		       for(int x=0; x<=numberIntervals-1; x++)//loops through until we have the correct number of intervals (found above)
		       {
			          System.out.print(minLook + "-" + maxLook + ": ");//outputs histogram row label based on current lower and upper bounds of range

			           for(int i=0; i<intArray.length; i++)//looks through entire array
			           {
			                if((intArray[i]>=minLook) && (intArray[i]<maxLook))//checks to see if current value is within current bounds
			                {
				                    System.out.print("*");//adds a star to the general print statement above
			                }

                 }

			           System.out.println(" ");//breaks line

			           minLook = minLook + grouping;//updates lower bound
			           maxLook = maxLook + grouping;//updates upper bound
		      }
	   }
}
