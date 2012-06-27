import java.io.*;
import java.net.*;

	class ChatClient extends Thread //each ChatClient is a separate thread
	{
	  Socket client = null;	
	  String clientName;
	//default Chatter host name
	  public static String HOSTNAME = "HOST";
	  
	  //variable 'chatterers' keeps track of number of connected ChatClients
	  public static int chatterers = 0;
	   
	  //reader and writer for socket
	  BufferedReader br;
	  PrintWriter pw;
	  
	  //tasks of the thread
	  public void run() 
	  {
	    try 
	    {
	      //input & output streams are setup  
	      br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	      pw = new PrintWriter(client.getOutputStream(), true);
	      
	      //welcome message and exit instructions to connected ChatClient
	      pw.println("*** Welcome to the Chatter ***");
	      pw.println(" ");
	      pw.println("(Type BYE to exit)");
	      pw.println(" ");
	      //ChatClient is asked for their name, and name is stored
	      pw.println("So...tell us your name!");
	      String clientName = br.readLine();
	      
	      //number of connected clients is incremented
	      chatterers ++;
	      
	      //message is relayed that new Client has joined the chatter
	      //along with number of connected clients
	      ChatServer.chat(HOSTNAME, "Attention! " + clientName + " has joined the chat. " +
	      		"(Chatterers: " + chatterers + ")");
	      
	      //waits for ChatClient to type message
	      while (true) 
	      {
	    	//loop reads the input from the ChatClient  
	        String chatClientInput = br.readLine();
	        
	        //first checks to see if client typed BYE to exit?
	        if (chatClientInput.contains("BYE")) 
	        {
	        //if BYE is detected then connected client number is decremented
	          chatterers --;
	        //and message is relayed that Client has left the chatter   
	          ChatServer.chat(HOSTNAME, clientName + " has left the chat. " +
	          		"(Chatterers: " + chatterers + ")");
	          break;
	        }	        
	        //if ChatClient did not type BYE then their input
	        //is relayed to all the connected ChatClients
	        ChatServer.chat(clientName, chatClientInput);
	      }
	      //once the ChatClient types "BYE" then they are removed
	      //from the linked list and their socket is closed
	      ChatServer.remove(client);
	      client.close();
	    }
	    catch (Exception e) {
	    	System.err.println(e);
            System.exit(0);
	   }
	  }//end run()
	  
	  //Constructor - each ChatClient takes an associated socket as argument
	  ChatClient(Socket socket) 
	  {
	    client = socket;
	  }
}
