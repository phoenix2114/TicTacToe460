public class Main {

	public void play() {

		TicTacToe game = new TicTacToe();

		System.out.println("Welcome! Tic Tac Toe is a one player game against a computer.");
		
		boolean continuePlaying = true;

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
					String square = game.getPrompt();
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
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.play();
	}
}
