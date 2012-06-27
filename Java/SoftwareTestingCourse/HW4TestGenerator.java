package HW4;
/* Geoffrey Paulsen
 * CSC 577 HW4 source code
 *  */



import java.io.*;
import java.util.*;

public class HW4TestGenerator
{	
	static File file;
	static FileWriter fw;
	static PrintWriter pw;

	static int r0=0, r1=0, r2=0, r3=0, r4=0, r5=0, r6=0, r7=0, r8=0, r9=0;
	static int right = 0, wrong = 0;
	
	public static void main(String[] args) throws Exception 
	{
		file = new File("paulsenHW4.txt");
		fw = new FileWriter(file);
		pw = new PrintWriter(fw);
		
		Scanner scannerIn = new Scanner(System.in);
		System.out.print("Please enter the number of test cases to generate: ");
		int testNumber  = Integer.parseInt(scannerIn.nextLine());

		//print number of tests to console
		System.out.println(testNumber); 
		//write number of tests to file
		pw.println(testNumber);
		
		for(int i = 0; i < testNumber ; i++)
		{	
			generateTest();
		}
		System.out.println(" ");
		System.out.println("Data - r0:" + r0 + " , " + "r1:" + r1 + " , " + "r2:" + r2 + ", " + "r3:" + r3 + ", " + 
				"r4:" + r4 + ", " + "r5:" + r5 + ", " + "r6:" + r6 + " , " + "r7:" + r7 + ", " + "r8:" + r8 + ", " + 
				"r9:" + r9);
		System.out.println(" ");
		System.out.println("right: " + right + ", wrong: " + wrong  + ", zeros :" + r0 + ", total :" +(right + wrong + r0));
		System.out.println(file.getAbsolutePath());
		pw.close();

	}
		private static void generateTest() throws Exception 
		{
			int searchItem, result;
			Random random = new Random();
			int arrayItems = random.nextInt(10);
			
			//print number of array items to console
			System.out.println(" ");
			System.out.println("Number of items : " + arrayItems); 
			//write number of array items to file
			pw.println(arrayItems);

			int[]theArray = new int[arrayItems];
			tallyIndecies(arrayItems);
			
			//array length is 0
			if (arrayItems == 0)
			{
				//choose random integer to search for
				int chosenItem  = 999 - (random.nextInt(2000));	
				
				//print integer to search for to console
				System.out.println("The item we are looking for : " + chosenItem); 
				//write integer to search for to file
				pw.println(chosenItem);
				
				//print result of 0 to console
				System.out.println("0");
				//write result of 0 to file
				pw.println("0");
				
			}
			
			//array length is not 0
			else
			{
				for(int i = 0, j = 1; i <arrayItems ; i++, j++)
				{	
					//randomly determine array items
					int k = 999 - (random.nextInt(2000));
					theArray[i] = k;
					
					//print each item in array to console
					System.out.println(theArray[i]); 
					//write each item in array to file
					pw.println(theArray[i]);
				}

				//flip coin to decide if item will be found or not in array
				int coinFlip  = (random.nextInt(2) + 1);
				
				//the case where search is unsuccessful
				if (coinFlip == 1)
				{
					//choose random integer to search for
					int chosenItem  = 999 - (random.nextInt(2000));
					
					//print integer to search for to console
					System.out.println("The item we are looking for : " + chosenItem);
					//write integer to search for to file
					pw.println(chosenItem);
					
					boolean found = false;
					for(int i = 0, j = 1; i < arrayItems ; i++, j++)
					{	
						//double-check to make sure chosen number is not found in array
						if (chosenItem == theArray[i])
							{
								//print the index to the console
								System.out.println("Found it at index : " + j);
								//write the index to the file
								pw.println(j);
								//set found to true and break out of search
								found = true;
								right++;
								break;
							}
					}
					//if item was not found
					if (found == false)
					{
						//print result of 0 to console
						System.out.println("0");
						//write result of 0 to file
						pw.println("0");
						wrong++;
					}
				}
				//create the case where search is successful
				else
				{
					//choose number randomly from items in the array
					int chosenItem  = theArray[(random.nextInt(arrayItems))];
					
					//print integer to search for to console
					System.out.println("The item we are looking for : " + chosenItem);
					//write integer to search for to file
					pw.println(chosenItem);
					right++;
					
					for(int i = 0, j = 1; i < arrayItems ; i++, j++)
					{	
						if (chosenItem == theArray[i])
							{
								//print the index to the console
								System.out.println("Found it at index : " + j);
								//write the index to the file
								pw.println(j);	
								break;
							}
					}
				}
			}
		}	
		
		public static void tallyIndecies(int items)
		{
			switch(items) {
			case 0:
	 			++r0;
	 			break;
	 		case 1:
	 			++r1;
	 			break;
	 		case 2:
	 			++r2;
	 			break;
	 		case 3:
	 			++r3;
	 			break;
	 		case 4:
	 			++r4;
	 			break;
	 		case 5:
	 			++r5;
	 			break;
	 		case 6:
	 			++r6;
	 			break;
	 		case 7:
	 			++r7;
	 			break;
	 		case 8:
	 			++r8;
	 			break;
	 		case 9:
	 			++r9;
	 			break;
		}
	}
}
