/**
 * @(#)URLReference.java
 * @Lab 5b
 *
 * @Geoffrey Paulsen
 * @version 1.00 2011/10/23
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;
 

public class URLStockPriceFinder
{
	public static void main(String[] args) throws IOException
	{
		Scanner scannerIn = new Scanner(System.in);
		System.out.print("Please enter a stock symbol : ");
		String stockName = scannerIn.nextLine();
		String stockPrice = "";
		CharSequence price = "";
		
		try
		{
			URL url = new URL("http://finance.yahoo.com/q?s=" + stockName);
			URLConnection connect = url.openConnection();
			connect.setDoOutput(true);
			InputStream iS = connect.getInputStream();
			InputStreamReader iSR = new InputStreamReader(iS);
			BufferedReader br = new BufferedReader(iSR);
			String i, j = "Last Trade";
			
			int x,y;
			while ((i = br.readLine()) != null) 
			{
				if (i.contains(j))
				{
					y = i.indexOf("</span></b>");				
					price = i.subSequence(y-8, y);
					StringBuffer sb = new StringBuffer();
					for (int z = 0; z < 8 ; z++)
					{
						if (Character.isDigit(price.charAt(z)) || price.charAt(z) == '.')
						{

							sb.append(price.charAt(z));
						}
							
							stockPrice = sb.toString();
					 }
				}
			}
			System.out.flush();
			br.close();
		}
		catch (IOException e)
		{
			System.err.println("Requested stock not found.");
			System.exit(0);
		}		
		System.out.println("The requested stock '" + stockName +"' is at " + stockPrice + ".");
	}	

}
