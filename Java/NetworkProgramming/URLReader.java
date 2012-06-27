/**
 * @(#)URLReader.java
 * @ Lab 6 : Getting Web Pages
 *
 *
 * @Geoffrey Paulsen
 * @version 1.00 2011/10/12
 */

import java.net.*;
import java.util.Scanner;
import java.awt.*;
import java.io.*;

import javax.swing.*;

public class URLReader
{

	public static void main(String[] args) throws IOException
	{
		//program reads URL from the command line
		Scanner scannerIn = new Scanner(System.in);
		System.out.print("Please enter URL : ");
		String address = scannerIn.nextLine();
		String filePath = ("http://" + address);

		if (address.length() > 0 )
    	{
			try
			{
				URL u = new URL (filePath);
				//open an InputStream from the URL
				InputStream in = u.openStream();
				int c;
				//read characters from file
				while ((c = in.read()) != -1)
				{
					//print characters to System.out
					System.out.write( c);
				}
				//JEditorPane set up to display URL/web page
				JEditorPane pane = new JEditorPane(filePath);
    			pane.setEditable(false);
    			//add scrolling capability to pane
    			JScrollPane jsp = new JScrollPane(pane);
    			//add name of address to frame title
    			JFrame frame = new JFrame(address);
	    		frame.setBounds(100, 100, 700, 500);
	    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frame.setContentPane(jsp);
	    		frame.setVisible(true);
	    		frame.setAlwaysOnTop(true);
	    		frame.setFocusable(true);

		    }

    		catch (IOException e)
    		{
    			System.err.println("Could not load the web page.");
    			System.exit(0);
    		}
    	}
    	else
    	{
    		System.out.println("No URL was entered.");
    		main(args);
    	}

    }
}
