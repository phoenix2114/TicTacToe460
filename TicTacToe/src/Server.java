//Always plays X

import java.net.*;
import java.io.*;


public class Server
{


	public static void main( String[] args)
	{		
		ServerSocket server; // this is the "door" 
		
		Socket toclientsocket;

		
		try {    // NOTE - must be within a try-clause or throw exceptions!!!!
	  		
		server = new ServerSocket(7788);   //listen at the door
		System.out.println("waiting for connection");
		toclientsocket = server.accept();   // block UNTIL request received

		//AT THIS POINT CONNECTION MADE
		  DataInputStream in = new DataInputStream(toclientsocket.getInputStream());
          DataOutputStream out = new DataOutputStream(toclientsocket.getOutputStream());

          toclientsocket = server.accept();   // block UNTIL request received

          //AT THIS POINT CONNECTION MADE

          System.out.println("RECEIVED REQUEST");

          //stuff for tic tac toe
          
    		}   // end try

        catch (IOException e) {
        	System.out.println(e.toString());
            System.out.println("It didnt happen - server");
        }
    }  // end main
}  // end myserver class
