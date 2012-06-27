package HW6;
/* Geoffrey Paulsen
 * CSC 577 HW6 source code
 *  */
import java.io.*;
import java.util.*;

public class paulsenHW6Checker
{
	static File fileIn, fileOut;
	static FileWriter fw;
	static FileReader fr;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception
	{
		String variables = "", equation = "";
		int tests, key, x, y, z, givenAnswer, result, right = 0, wrong = 0;
		fileIn = new File("C:/Temp/paulsenHW6file2.txt");
		fr = new FileReader(fileIn);
		Scanner scannerIn = new Scanner(fr);
		variables = scannerIn.nextLine();
		equation = scannerIn.nextLine();
		tests = scannerIn.nextInt();
		key = scannerIn.nextInt();

		while(scannerIn.hasNext()){
			x = scannerIn.nextInt();
			y = scannerIn.nextInt();
			z = scannerIn.nextInt();
			givenAnswer = scannerIn.nextInt();
			result = x - (y * z);
			if (givenAnswer == result)
				right++;
			else
				wrong++;
		}//end while

	    System.out.println("Right : " + right + " | Wrong : " + wrong );
	    //pw.close();
	}//end main
}
