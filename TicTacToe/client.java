//Always plays 0

import java.net.*;
import java.io.*;


public class client
{


    public static void main( String[] args)
    {
        ServerSocket server; // this is the "door"

        Socket toclientsocket;


        try {    // NOTE - must be within a try-clause or throw exceptions!!!!

            server = new ServerSocket(7788);   //listen at the door
            System.out.println("waiting for connection");

            DataInputStream in = new DataInputStream(toclentsocket.getInputStream());
            DataOutputStream in = new DataOutputStream(toclentsocket.getOutputStream());

            toclientsocket = server.accept();   // block UNTIL request received

            //AT THIS POINT CONNECTION MADE

            System.out.println("RECEIVED REQUEST");
            out.writeDouble(55.1);
            out.writeDouble(44.7);

            Double answer = in.readDouble();

        }   // end try
        catch (IOException e) {
            System.out.println("It Didn't work");
        }
    }  // end main
}  // end myserver class
