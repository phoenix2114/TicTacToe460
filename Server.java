//Always plays X

import java.net.*;
import java.io.*;


public class Server 
{
	public static void main( String[] args) 
	{	
		try { 
			System.out.println("Binding to port 7788");    		
			ServerSocket server = new ServerSocket(7788);
			
			System.out.println("Waiting for client connection");
			Socket connectionSocket = server.accept( );

			System.out.println("Client CONNECTED");
			

			// Establish the client's input stream.
			DataInputStream clientInput = new DataInputStream( connectionSocket.getInputStream());

			// Establish the server's output stream.
			DataOutputStream serverOutput = new DataOutputStream( connectionSocket.getOutputStream());

			System.out.println("Connected...");
			
			serverOutput.writeBoolean(true);	
			
			TicTacToe game = new TicTacToe();
			
			boolean continuePlaying = true;
			System.out.println("Welcome! Tic Tac Toe is a one player game against a computer.");

			while (continuePlaying) {

				game.init();
				System.out.println();
				System.out.println(game.drawBoard());
				System.out.println();

				String player = null;
				while (!game.winner() && game.getPlays() < 9) {
					player = game.getCurrentPlayer() == 1 ? game.getClient() : game.getServer();
					boolean validPick = false;

					while (!validPick) {
						System.out.print("It is " + player + "'s turn. Pick a square: ");
						String square;
						if(player == "server"){
							int serverSquare = clientInput.readInt();
							square = String.valueOf(serverSquare);
						}
						else{
							square = game.getPrompt();
						}
						if (square.length() == 1 && Character.isDigit(square.toCharArray()[0])) {
							int pick = 0;
							try {
								pick = Integer.parseInt(square);
							} catch (NumberFormatException e) {
								//Do nothing here, it'll evaluate as an invalid pick on the next row.
							}
							validPick = game.placeMarker(pick);
						}
						if (!validPick) {
							System.out.println("Square can not be selected. Retry");
						}
					}
					game.switchPlayers();
					System.out.println();
					System.out.println(game.drawBoard());
					System.out.println();
				}
				if (game.winner()) {
					System.out.println("Game Over - " + player + " WINS!!!");
				} else {
					System.out.println("Game Over - Draw");
				}
				System.out.println();
				System.out.print("Play again? (Y/N): ");
				String choice = game.getPrompt();
				if (!choice.equalsIgnoreCase("Y")) {
					continuePlaying = false;
					serverOutput.writeUTF("Player has chosen to quit playing");
				}
			}
			
			server.close();
		}

		catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("It didnt happen - server");
		}

	}	

}  
