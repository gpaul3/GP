/**
 * @ExServ.java (Lab 4 - CSC583B)
 *@Using the ExecutorService Interface
 *
 * @Geoffrey Paulsen
 * @2011/9/28
 */

import java.io.*;
import java.security.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class ExServ
{
	private File d;

	//constructor method receives directory of files as arg
	public ExServ (File directory)
	 {
		 d = directory;
		 //ExecutorService interface creates a pool of 5 threads
		 ExecutorService pool = Executors.newFixedThreadPool(5);
		 //each file in directory is passed through the handler
	     for(File file : d.listFiles())
		 {
			 Handler h = new Handler (file);
			 pool.execute(h);
		 }
          //close pool when there are no more files to process
		 pool.shutdown();

     }

  	public static void main(String[] args)
  	{
  		//main method gets directory of files input from user
		Scanner in = new Scanner(System.in);
		System.out.print("Enter file directory to process: ");
		String filePath = in.nextLine();
		System.out.println("Digest for each file:");
		File dir = new File(filePath);
		 if (!dir.isDirectory())
			 System.out.println("\nSelected file is not a directory or does not exist.\n");
		//constructor method is called with directory of files passed as arg
		 ExServ es = new ExServ(dir);
  	}
  ///inner class creates runnable object
    class Handler implements Runnable
	{
	 private File f;
	 Handler (File f)
			 {
		  		this.f = f;
		 	 }
		 	 //section of code from Lab 3 solution employed here
			 public void run()
			 {
				 try
				 {
					 FileInputStream in = new FileInputStream(f);
					 MessageDigest sha = MessageDigest.getInstance("SHA");
					 DigestInputStream din = new DigestInputStream(in, sha);
					 int b;
					 while ((b = din.read()) != -1) ;
					 din.close();
					 byte[] digest = sha.digest();
					 StringBuffer result = new StringBuffer(f.toString());
					 result.append(": ");
					 for (int i = 0; i < digest.length; i++)
					 {
						 result.append(digest[i] + " ");
					 }
					 System.out.println(result);
				 }
		 	  catch (IOException e)
		 	  {
		 		  System.err.println(e);
		 	  }
		 	  catch (NoSuchAlgorithmException e)
		 	  {
				 System.err.println(e);
			   }

		    }
		 }
}

