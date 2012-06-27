package HW1;

import java.io.IOException;
import java.util.Scanner;

public class HW1tester 
{

	public static void main(String[] args) throws IOException
	{
		Scanner scannerIn;
		int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0, s7 = 0;
		int s8 = 0, s9 = 0, s10 = 0;
		
		while (true)
		{
		
		scannerIn = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Please enter number K : ");
		int k  = Integer.parseInt(scannerIn.nextLine());
		System.out.println("Please enter number W : ");
		int w  = Integer.parseInt(scannerIn.nextLine());
		System.out.println("Please enter number M : ");
		int m  = Integer.parseInt(scannerIn.nextLine());
		System.out.println("The three integers in: " + k + " " + w + " " + m);
		
		if (k == 0)
		{
			k = 3;
			++s1;
		}
		else
		{
			++s2;
		}
		
		if (w > m)
		{
			w = m - 1;
			++s3;
		}
		else
		{
			++s4;
		}
		
		if (k > (w + m))
		{
			w = m * 2	;
			++s5;
		}
		else 
		{
			k = k + 10 ;
			++s6;
		}

		if ((k + w ) <  m)
		{
			m = m - 1;
			++s7;
		}
		else
		{
			k = k -2;
			++s8;
		}

		if (m > 0)
		{
			k = -m;
			++s9;
		}
		else
		{
			++s10;
		}

		System.out.println("The three integers out: " + k + " " + w + " " + m);
		System.out.println("The coverage is: s1:" + s1 + " , " + "s2:" + s2 + ", " + "s3:" + s3 + ", " + 
				"s4:" + s4 + ", " + "s5:" + s5 + ", " + "s6:" + s6 + " , " + "s7:" + s7 + ", " + "s8:" + s8 + ", " + 
				"s9:" + s9 + ", " + "s10:" + s10 + " .");
	 }
	}

}
