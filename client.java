//Always plays 0

import java.net.*;
import java.util.Random;
import java.io.*;

public class client extends Thread
{


	public static void main( String[] args)
	{		
		Socket toServerSocket;
		int   reply;   // for later use

		System.out.println("CLIENT is attempting connection....");

		try {
			Thread thread = new Thread();
			thread.start();
			toServerSocket = new Socket("localhost", 7788);
			System.out.println("Connecting to server");			

			DataInputStream serverIn = new DataInputStream( toServerSocket.getInputStream());
			DataOutputStream clientOut = new DataOutputStream( toServerSocket.getOutputStream());

			System.out.println("Connected...");

			boolean playGame = serverIn.readBoolean();
			while(playGame){
				Random rand = new Random();
				reply = rand.nextInt(10);
				clientOut.writeInt(reply);
			}
			String endGame = serverIn.readUTF();
			System.out.println(endGame);
			toServerSocket.close();
			
		}
		catch (IOException e) {
			System.out.println("You chose to end the game");
		}
	}  
}
