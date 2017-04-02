import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
public class TicTacToe {

	private char[][] board = new char[3][3];
	private String client = "client";
	private String server = "server";
	private int currentPlayer;
	private char clientMarker = 'O';
	private char serverMarker = 'X';
	private int plays;
	private BufferedReader reader =
			new BufferedReader(new InputStreamReader(System.in));

	protected void init() {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				board[i][i1] = Character.forDigit(++counter, 10);
			}
		}
		currentPlayer = chooseFirstPlayer();
		plays = 0;
	}
	
	// Randomly determine whether the player or computer will get to go first during this game.
     public int chooseFirstPlayer() {
        Random generator = new Random();
        if(generator.nextInt(2) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }	

	protected void switchPlayers() {
		if (getCurrentPlayer() == 1) {
			setCurrentPlayer(2);
		} else {
			setCurrentPlayer(1);
		}
		setPlays(getPlays() + 1);
	}

	protected boolean placeMarker(int play) {
		for (int i = 0; i < 3; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				if (board[i][i1] == Character.forDigit(play, 10)) {
					board[i][i1] = (getCurrentPlayer() == 1) ? getClientMarker() : getServerMarker();
					return true;
				}
			}
		}
		return false;
	}

	protected boolean winner() {
		//Checking rows
		char current = ' ';
		for (int i = 0; i < 3; i++) {
			int i1 = 0;
			for (i1 = 0; i1 < 3; i1++) {
				if (!Character.isLetter(board[i][i1])) {
					break;
				}
				if (i1 == 0) {
					current = board[i][i1];
				} 
				else if (current != board[i][i1]) {
					break;
						}
				if (i1 == 2) {
					//Found winner
					return true;
				}
			}
		}
		//Checking columns
		for (int i = 0; i < 3; i++) {
			current = ' ';
			int i1 = 0;
			for (i1 = 0; i1 < 3; i1++) {
				if (!Character.isLetter(board[i1][i])) {
					break;
				}
				if (i1 == 0) {
					current = board[i1][i];
				} else if (current != board[i1][i]) {
					break;
				}
				if (i1 == 2) {
					//Found winner
					return true;
				}
			}
		}
		//Checking diagonals
		current = board[0][0];
		if (Character.isLetter(current) && board[1][1] == current && board[2][2] == current) {
			return true;
		}
		current = board[2][0];
			if (Character.isLetter(current) && board[1][1] == current && board[0][2] == current) {
				return true;
			}
		return false;
		}

	protected String getPrompt() {
		String prompt = "";
			try {
				prompt = reader.readLine();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		return prompt;
	}

	protected String drawBoard() {
		StringBuilder builder = new StringBuilder("Game board: \n");
		for (int i = 0; i < 3; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				builder.append("[" + board[i][i1] + "]");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public char getClientMarker() {
		return clientMarker;
	}

	public char getServerMarker() {
		return serverMarker;
	}
	
	public int getPlays() {
		return plays;
	}
	
	public void setPlays(int plays) {
		this.plays = plays;
	}
	
	public String getClient() {
		return client;
	}
	
	public String getServer() {
		return server;
	}

}
