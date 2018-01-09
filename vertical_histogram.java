/*
NAME: Christina Sadak
ASSIGNMENT: Java homework 6 vertical histogram class
PURPOSE: This is the vertical histogram class which inherits the methods from the histogram class
(constructor and add_value()). It does not inherit the write method though because the vertical histogram class
overrides the histogram class's write method. The overrided write method outputs the stars vertically
as opposed to horizontally.
*/

import java.util.Arrays;

public class vertical_histogram extends histogram
{
	public vertical_histogram(int maxVals)
	{
		super(maxVals); //inherits histogram class's constructor using keyword 'super'
	}

	public void write()
	{
		Arrays.sort(intArray);//sorts the integer array

		int largestVal = intArray[maximumValues-1];
		int numberIntervals = (largestVal/grouping)+1;
		int minLook = 0;
		int maxLook = grouping-1;

		int starCount;
		int starCountMAX = 0;

		int[] barSizesArray;
		barSizesArray = new int[numberIntervals];

		for(int x=0; x<intArray.length; x++)//goes through all integers in the integer array
		{
				barSizesArray[intArray[x]/grouping]++;/*fills each interval with how many stars it will have by taking
																							 the current integer from the intArray and dividing it by the
																							 size of the group. Since this is an integer value, the result
																							 from the division will be a a whole number which will then
																							 determine which interval the current integer belongs in. It does
																							 not place the actual integer into the array, it updates the counter
																							 for each interval (how many stars will be needed for that bar)*/
		}

		for(int w=0; w<numberIntervals; w++)
		{
				starCount = barSizesArray[w];/*stores the value in the barSizesArray into starCount becuase
																		each integer in this array represents how many stars will be used per bar*/

				if(starCount>starCountMAX)//if the starCount value is greater than the current max, the max gets replaced
						starCountMAX = starCount;
		}

		int rowNumber;

		for(rowNumber = starCountMAX; rowNumber > 0; rowNumber--)/*goes top-down through the determined number of
																															rows (number of rows is determined because the max
																															number of rows will be equal to the max number of stars
																															*/
		{
				for(int bar = 0; bar < numberIntervals; bar++)//prints the correct number of stars per interval
				{
						if(barSizesArray[bar] >= rowNumber)/*if the row number is less than the interval
																								 then output a star in that row
																								*/
								System.out.print("*     ");//star with spacing
						else
								System.out.print("      ");//spacing
				}
				System.out.println(" \n");//begins printing on a new line

		}

			for(int x=0; x<numberIntervals; x++)//outputs the legend underneath the stars
			{
				System.out.print(minLook + "-" + maxLook+ " ");

				minLook = minLook + grouping;
				maxLook = maxLook + grouping;
			}
					System.out.println(" ");

	}
}
