import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer 
{ 

  Socket client = null;
  
  //linked list to store all ChatClients
  public static LinkedList linkedList = new LinkedList();
  
  //constructor takes port as argument
  ChatServer (int port) throws IOException 
  {
	//create new server socket  
    ServerSocket server = new ServerSocket(port);
    
    //confirmation message that server is connected
    System.out.println("The Chat Server is now connected to port " + port + ".");
    System.out.println("Waiting for clients to connect...");

    //looks for new clients and adds them to linkedList
    while (true) 
    {
      client = server.accept();
      linkedList.add(client);
      
      //creates new participant(ChatClient) in discussion
      //with associated socket as argument
      ChatClient chatterer = new ChatClient(client);
      
      //starts the thread
      chatterer.start();
      
      //prints message on server console including  # of the client is and
      //where they are connected from
      System.out.println("New client #" + linkedList.size() + " on client's port " 
    		  + client.getPort());
    }
  }//end ChatServer
  
//synchronized method remove allows only one ChatClient at a time 
  //to be removed from linkedList
  synchronized static void remove(Socket socket) 
  {
	  linkedList.remove(socket);
  }
  
 
  //synchronized method chat allows only one ChatClient at a time to chat a message
  //sends message to all connected ChatClients with the ChatClients name  
  synchronized static void chat(String name, String message) throws IOException
  {	  
    PrintWriter pw;
    
    //prints message to the server console
    System.out.println(name + " >> " + message);
    
    //goes through each ChatClient stored in linkedList 
    for (Object o : linkedList)
    {
      //casts object in linked list to a socket
      pw = new PrintWriter(((Socket) o).getOutputStream(), true);
      
      //prints ChatClient's name with message to all connected ChatClients
      //on ChatClient socket outputstream
      pw.println(name + " >> " + message);
    }
  }//end chat
  
//main method asks user what port number to start server on
  public static void main(String[] args) throws IOException 
  {	  
	Scanner scannerIn = new Scanner(System.in);
	System.out.print("Please enter port number for the Chat Server to run on : ");
	int port = scannerIn.nextInt();
	//starts new ChatServer
	ChatServer cs = new ChatServer(port);
  }//end main
  
}