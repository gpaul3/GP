package HW6;
/* Geoffrey Paulsen
 * CSC 577 HW6 source code
 *  */
import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class paulsenHW6source
{
	public static void main(String[] args) throws Exception
	{
		File fileIn, fileOut;
		FileWriter fw;
		FileReader fr;
		PrintWriter pw;
		String variables = "", equation = "", fileInPath, fileOutPath;
		int tests, key, x, y, z, givenAnswer, result, right = 0, wrong = 0;
		
		//path of input/output files
		fileInPath = "C:/Temp/paulsenHW6file1.txt";
		fileOutPath = "C:/Temp/paulsenHW6file2.txt";
		
		//input processing
		fileIn = new File(fileInPath);
		fr = new FileReader(fileIn);
		Scanner scannerIn = new Scanner(fr);
		
		//output processing
		fileOut = new File(fileOutPath);
		fw = new FileWriter(fileOut);
		pw = new PrintWriter(fw);
		
		//print variables as is
		variables = scannerIn.nextLine();
		pw.println(variables);
		
		//print equation as is
		equation = scannerIn.nextLine();
		pw.println(equation);
		
		//print key as is
		key = scannerIn.nextInt();
		pw.println(key);

		//print test numbers as is
		tests = scannerIn.nextInt();
		pw.println(tests);

		
		while(scannerIn.hasNext())
		{
			x = scannerIn.nextInt();
			pw.print(x + " ");

			y = scannerIn.nextInt();
			pw.print(y + " ");

			z = scannerIn.nextInt();
			pw.println(z);

			givenAnswer = scannerIn.nextInt();
			result = x - (y * z);
			
			//compare given answer to the result of computation
			if (givenAnswer == result)
			{
				right++; //tally correct answers
				pw.println(givenAnswer);
			}
			else
			{
				wrong++; //tally incorrect answers
				pw.println(result);
			}
		}//end while
		
		//print out stats to console
	    System.out.println("Right : " + right + " | Wrong : " + wrong );
	    System.out.println("New file generated can be found at: " + fileOutPath);
	    
	    //open new file on screen
	    Desktop.getDesktop().edit(fileOut);
	    
	    //close output stream
	    pw.close();

	}//end main
}
