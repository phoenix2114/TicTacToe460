//Always plays 0

import java.net.*;
import java.io.*;


public class client
{


	public static void main( String[] args)
	{		
		
	  Socket toserversocket;
	  int   reply;   // for later use
		
	  System.out.println("CLIENT is attempting connection....");
	  try {
		toserversocket = new Socket("localhost", 7788);
		System.out.println("CONNECTION HAS BEEN MADE");
		
		  DataInputStream in = new DataInputStream(toserversocket.getInputStream());
          DataOutputStream out = new DataOutputStream(toserversocket.getOutputStream());

          //AT THIS POINT CONNECTION MADE

          System.out.println("RECEIVED REQUEST");
        //stuff for tic tac toe
          
	  }
        catch (IOException e) {
        	System.out.println(e.toString());
            System.out.println("It Didn't work - client");
        }
    }  // end main
}  // end myserver class
