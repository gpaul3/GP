package edu.uis.mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import edu.uis.mastermind.model.CodePeg;
import edu.uis.mastermind.model.GameManager;
import edu.uis.mastermind.model.KeyPeg;
import edu.uis.mastermind.model.MatchManager;
import edu.uis.mastermind.view.CodePegPanel;
import edu.uis.mastermind.view.GreetingScreen;
import edu.uis.mastermind.view.KeyPegPanel;
import edu.uis.mastermind.view.MastermindBoard;
import edu.uis.mastermind.view.NameEntryForm;

public class GameController implements ActionListener {
	private CodePegPanel codeRow;
	private CodePegPanel guessRows;
	private KeyPegPanel feedbackRows;
	private MastermindBoard board;
	private GreetingScreen greeting;
	private GameManager gameManager;
	private MatchManager matchManager;
	private NameEntryForm entryForm;
	private int numPlayers;
	private String player1Name;
	private String player2Name;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameController gameController = new GameController();
					/*
					 * The Player shall be allowed to select the number of
					 * players. (Requirement 4.0)
					 */
					gameController.intializeGreetingScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public GameController() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {

		// Initialize the Model
		gameManager = new GameManager();

		// Initialize the View
		board = new MastermindBoard();
		board.playAgainButton.setVisible(false);
		board.getGuessButton().addActionListener(this);
		board.getQuitButton().addActionListener(this);
		board.getPlayButton().addActionListener(this);
		board.getCodeButton().addActionListener(this);

		/*
		 * The game board shall contain 1 Code Row and 10 Guess Rows.
		 * (Requirement 1.0)
		 * 
		 * Code Row (Requirement 1.1)
		 */
		// create 1 code row
		int[] codeRowBounds = { 17, 23, 178, 35 };
		codeRow = new CodePegPanel(1, codeRowBounds);
		board.frame.getContentPane().add(codeRow);

		/*
		 * Guess Rows (Requirement 1.2) Guess Section (Requirement 1.2.2)
		 */
		// create 10 guess rows
		int[] guessRowBounds = { 18, 83, 175, 406 };
		guessRows = new CodePegPanel(gameManager.getMaxGuesses(),
				guessRowBounds);
		board.frame.getContentPane().add(guessRows);

		/*
		 * Feedback Section (Requirement 1.2.3)
		 */
		// create 10 feedback rows
		feedbackRows = new KeyPegPanel(gameManager.getMaxGuesses());
		board.frame.getContentPane().add(feedbackRows);

	}

	// reset the views at the start of each game
	private void resetView() {
		codeRow.reset();
		guessRows.reset();
		feedbackRows.reset();
		board.playAgainButton.setVisible(false);
	}

	// Configure a 1 or 2 player game
	private void startNewGame() {
		resetView();
		gameManager.startGame();

		// Initialize single player mode
		if (getNumPlayers() == 1) {
			/*
			 * The game engine shall randomly generate a secret code for the
			 * Code Row. (Requirement 5.1)
			 */
			gameManager.setRandomCode();
			codeRow.setVisible(false);

			/*
			 * The Code Shield should cover the Code Row after a code is set.
			 * (Requirement 1.1.3.1)
			 */
			board.codeCoverPanel.setVisible(true);
			codeRow.enableRow(0, false);
			codeRow.setPegColors(convertCodePegRowToColorRow(gameManager
					.getCodeRow()));
			guessRows.enableRow(getCurrentRow(), true);
		}

		else {
			// 2 player game
			/*
			 * Code Maker generates secret code (Requirement 6.3)  
			 */
			board.message.setText(matchManager.getCurrentCodeMaker().getName()
					+ ", create the secret code.");
			board.logoM.setVisible(false);
			
			// enable code row
			board.codeCoverPanel.setVisible(false);
			codeRow.setVisible(true);
			codeRow.enableRow(0, true);
			board.getCodeButton().setVisible(true);

			// disable guess button
			board.getGuessButton().setEnabled(false);
			board.roundNumber.setText(matchManager.getCurrentRound() + "");
			board.gameNumber.setText(matchManager.getCurrentGame() + "");
		}

	}

	// fire appropriate event
	public void actionPerformed(ActionEvent e) {

		/*
		 * The game should allow the user to play alone (single player mode).
		 * (Requirement 4.1)
		 */

		if ("PLAYER_1".equals(e.getActionCommand())) {
			setNumPlayers(1);
			greeting.frmWelcome.setVisible(false);
			board.frame.setVisible(true);
			board.message.setText("Please enter your first guess.");
			board.guessButton.setEnabled(true);
			/*
			 * There will be no score keeping in single player mode (Requirement
			 * 5.5)
			 */
			// turn off score board for two player option
			board.scoreboard1.setVisible(false);
			board.scoreboard2.setVisible(false);
			startNewGame();
		}

		/*
		 * The game should allow the user to play against another human player
		 * (two player mode). (Requirement 4.2)
		 */
		else if ("PLAYER_2".equals(e.getActionCommand())) {
			// Initialize Name Entry Form
			setNumPlayers(2);
			greeting.frmWelcome.setVisible(false);
			/*
			 * Players enter name into Name Entry Form (Requirement 6.2)  
			 */	
			entryForm = new NameEntryForm();
			entryForm.frmPlayers.setVisible(true);
			entryForm.getOKButton().addActionListener(this);
			entryForm.getCancelButton().addActionListener(this);
		}

		else if ("OK".equals(e.getActionCommand())) {
			// get players names
			/*
			 * If no name is entered, the default name "Player 1" shall be used
			 * (Requirement 7.4.3)
			 */
			if (entryForm.p1NameField.getText().trim().equals("")) {
				player1Name = "Player 1";
			} 
			/*
			 * Max. characters 32 (Requirement 7.4.2)
			 */
			
			else if (entryForm.p1NameField.getText().length() >= 32) {
				showNameSetErrorDialog();
				entryForm.p1NameField.setText("");
				return;
			} else {
				player1Name = entryForm.p1NameField.getText();
			}
			/*
			 * If no name is entered, the default name "Player 1" shall be used
			 * (Requirement 7.5.3)
			 */
			if (entryForm.p2NameField.getText().trim().equals("")) {
				player2Name = "Player 2";
			} 
			/*
			 * Max. characters 32 (Requirement 7.5.2)
			 */
			
			else if (entryForm.p2NameField.getText().length() >= 32) {
				showNameSetErrorDialog();
				entryForm.p2NameField.setText("");
				return;
			} else {
				player2Name = entryForm.p2NameField.getText();
			}
			/*
			 * Confirmation button “OK”(Requirement 7.6)
			 * The confirmation button should
			 * start the two player match.(Requirement 7.6.1)
			 */
			matchManager = new MatchManager(player1Name, player2Name);
			entryForm.frmPlayers.setVisible(false);
			board.frame.setVisible(true);
			board.gameLabel.setVisible(true);
			board.roundLabel.setVisible(true);
			board.gameNumber.setVisible(true);
			board.roundNumber.setVisible(true);
			board.scoreboard1.setVisible(true);
			board.scoreboard2.setVisible(true);
			board.player1Label.setText(player1Name + " : ");
			board.player2Label.setText(player2Name + " : ");
			matchManager.getPlayer1().resetScore();
			matchManager.getPlayer2().resetScore();
			board.player1Points.setText("" + matchManager.getPlayer1().getScore());
			board.player2Points.setText("" + matchManager.getPlayer2().getScore());
			startNewGame();

		}

		else if ("GUESS_CODE".equals(e.getActionCommand())) {
			/*
			 * The game shall allow the Code Breaker to enter and lock in a
			 * guess. (Requirement 5.3) - 1 player mode (Requirement 6.5) - 2
			 * player mode
			 */
			CodePeg[] currentGuess = getCurrentGuessFromView();
			/*
			 * The Guess Row must have all slots filled by Code Pegs in order to
			 * be valid.If the Guess Row is not set properly the Player should
			 * be alerted. (Requirement 1.1.4) (Requirement 1.2.5)
			 */
			// check to make sure code breaker used all pegs
			if (Arrays.asList(currentGuess).contains(CodePeg.NONE)) {
				board.message
						.setText("You should use all 4 pegs in your guess.");
				showGuessErrorDialog();
				return;
			}
			/*
			 * The game engine shall provide feedback after each Code Breaker
			 * guess. (Requirement 1.2.3.2)
			 */
			KeyPeg[] result = gameManager.makeGuess(currentGuess);
			feedbackRows.setPegColorsForRow(getCurrentRow(),
					convertKeyPegRowToColorRow(result));
			guessRows.enableRow(getCurrentRow(), false);
			/*
			 * The game shall end when the Code Breaker has cracked the code..
			 * (Requirement 5.2)
			 */
			if (gameManager.isSolved()) {
				/*
				 * At the end of a game the Code Shield should be removed so
				 * that the Secret Code is revealed. (Requirement 1.1.3.2)
				 */
				board.codeCoverPanel.setVisible(false);
				codeRow.setVisible(true);
				
				/*
				 * At the end of a game a message shall appear that indicates
				 * the outcome of the game. (Requirement 5.4 - 1 player mode)
				 * (Requirement 6.9 - 2 player mode)
				 * 
				 * At the end of each game a message should be displayed to
				 * indicate whether or not the code breaker was successful.
				 * (Requirement 8.0)
				 * 
				 * Success message : “Congratulations. You are a Mastermind!”
				 * (Requirement 8.1)
				 */
				if (getNumPlayers() == 1) {
					board.message.setText("Congratulations. You are a Mastermind!");
					endGame();
				} else {
					// if guess is the last of the match
					if (matchManager.getCurrentGame() == matchManager
							.getMaxGamesPerRound()
							&& matchManager.getCurrentRound() == matchManager
									.getMaxRounds()) {
						endMatch();
					} else {

						// beginNextGameDialog();
						board.scoreboard1.setVisible(false);
						board.scoreboard2.setVisible(false);
						board.playAgainButton
								.setText("Press to start next game.");
						board.playAgainButton.setVisible(true);
						board.message.setText(matchManager
								.getCurrentCodeBreaker().getName()
								+ ", you are a Mastermind!");
					}
				}
			}

			/*
			 * The game shall end when the Code Breaker has unsuccessfully
			 * completed 10 attempts. (Requirement 5.2)
			 */
			else if (gameManager.getCurrentGuess() == gameManager
					.getMaxGuesses()) {

				/*
				 * At the end of a game a message shall appear that indicates
				 * the outcome of the game. (Requirement 5.4 - 1 player mode)
				 * (Requirement 6.9 - 2 player mode)
				 * 
				 * At the end of each game a message should be displayed to
				 * indicate whether or not the code breaker was successful.
				 * (Requirement 8.0)
				 * 
				 * Success message : “Congratulations. You are a Mastermind!”
				 * (Requirement 8.2)
				 */
				
				board.codeCoverPanel.setVisible(false);
				codeRow.setVisible(true);
				board.playAgainButton.setVisible(true);

				if (getNumPlayers() == 1) {
					board.message.setText("Oh well, better luck next time.");
					endGame();
				} else {
					
					// beginNextGameDialog();

					board.message.setText("Better luck next time, "
							+ matchManager.getCurrentCodeBreaker().getName()
							+ ".");
					board.scoreboard1.setVisible(false);
					board.scoreboard2.setVisible(false);
					board.playAgainButton.setText("Press to start next game.");
				}

			}
			/*
			 * Guess Rows shall become enabled one at a time starting with row 1
			 * and ending with row 10. (Requirement 1.2.4)
			 */
			else {
				// add random message generator
				board.message.setText(randomFailMessage() + "You have "
						+ (10 - gameManager.getCurrentGuess())
						+ " guesses left.");
				gameManager.incrementGuess();
				guessRows.enableRow(getCurrentRow(), true);
				
				if (getNumPlayers() == 2) {
					matchManager.getCurrentCodeMaker().updateScore(1);
					updateScoreBoard();
				}
			}
		} 
		/*
		 * Restart game with "Quit" button (Requirement 11.1/11.2)
		 */
		
		else if ("QUIT_GAME".equals(e.getActionCommand())) {
			intializeGreetingScreen();
			board.frame.setVisible(false);
			board.playAgainButton.setVisible(false);

		} else if ("SET_CODE".equals(e.getActionCommand())) {
			
			// get the code row and pass it to the MODEL, then hide everything
			CodePeg[] currentCode = getCodeFromView();

			// check to make sure code breaker used all pegs
			if (Arrays.asList(currentCode).contains(CodePeg.NONE)) {
				board.message.setText(matchManager.getCurrentCodeMaker().getName() + ", use all 4 pegs in your code.");
				showSetCodeErrorDialog();
				return;
			}

			// disable code row
			board.codeButton.setVisible(false);
			/*
			 * Code Shield should cover secret code (Requirement 6.6)  
			 */
			board.codeCoverPanel.setVisible(true);
			codeRow.setVisible(false);
			codeRow.enableRow(0, false);

			board.logoM.setVisible(true);
			board.codeButton.setVisible(false);

			// send the code row to the MODEL
			gameManager.setCodeRow(currentCode);

			// enable 1st guess row
			guessRows.enableRow(getCurrentRow(), true);

			// enable guess button
			board.getGuessButton().setEnabled(true);

			// tell the code breaker to begin guessing
			board.message.setText(matchManager.getCurrentCodeBreaker()
					.getName() + ", you've got 10 guesses.");

		} else if ("PLAY_AGAIN".equals(e.getActionCommand())) {
			/*
			 * The user should be able to dismiss the message. (Requirement 8.3)
			 */
			if (getNumPlayers() == 1) {
				board.frame.setVisible(false);
				board.playAgainButton.setVisible(false);
				intializeGreetingScreen();
			} else {
				board.scoreboard1.setVisible(true);
				board.scoreboard2.setVisible(true);
				board.playAgainButton.setVisible(false);
				endGame();
			}
		} else if ("CANCEL".equals(e.getActionCommand())) {
			/*
			 * Cancel button “Cancel” (Requirement 7.7) The cancel button should
			 * return the game to the mode selection state. (Requirement 7.7.1)
			 */
			intializeGreetingScreen();
			entryForm.frmPlayers.setVisible(false);
			return;
		} else {

		}

	}

	/**
	 * get the current guess row
	 * 
	 * @return
	 */
	protected int getCurrentRow() {
		return gameManager.getMaxGuesses() - gameManager.getCurrentGuess();
	}

	/**
	 * get the current guess from the View and return it as Model colors
	 * 
	 * @return
	 */
	protected CodePeg[] getCurrentGuessFromView() {
		Color[] pegColors = guessRows.getPegColorsForRow(getCurrentRow());
		CodePeg[] guess = new CodePeg[4];

		for (int i = 0; i < pegColors.length; i++) {
			guess[i] = convertColorToCodePeg(pegColors[i]);
			System.out.println(guess[i].toString());
		}
		return guess;
	}

	protected CodePeg[] getCodeFromView() {
		Color[] pegColors = codeRow.getPegColors();
		CodePeg[] code = new CodePeg[4];

		for (int i = 0; i < pegColors.length; i++) {
			code[i] = convertColorToCodePeg(pegColors[i]);
			System.out.println(code[i].toString());
		}
		return code;
	}

	/**
	 * convert from the Model representation to the View representation
	 * 
	 * @param codeRow
	 * @return color
	 */
	protected Color[] convertCodePegRowToColorRow(CodePeg[] codeRow) {
		Color[] pegColors = new Color[4];

		for (int i = 0; i < pegColors.length; i++) {
			pegColors[i] = convertCodePegToColor(codeRow[i]);
		}
		return pegColors;
	}

	protected CodePeg convertColorToCodePeg(Color color) {
		CodePeg codePeg = CodePeg.NONE;

		if (color.equals(Color.RED)) {
			codePeg = CodePeg.RED;
		} else if (color.equals(Color.BLUE)) {
			codePeg = CodePeg.BLUE;
		} else if (color.equals(Color.GREEN)) {
			codePeg = CodePeg.GREEN;
		} else if (color.equals(Color.YELLOW)) {
			codePeg = CodePeg.YELLOW;
		} else if (color.equals(Color.BLACK)) {
			codePeg = CodePeg.BLACK;
		} else if (color.equals(Color.WHITE)) {
			codePeg = CodePeg.WHITE;
		}
		return codePeg;
	}

	protected Color convertCodePegToColor(CodePeg codePeg) {
		Color color = Color.RED;

		if (codePeg.equals(CodePeg.RED)) {
			color = Color.RED;
		} else if (codePeg.equals(CodePeg.BLUE)) {
			color = Color.BLUE;
		} else if (codePeg.equals(CodePeg.GREEN)) {
			color = Color.GREEN;
		} else if (codePeg.equals(CodePeg.YELLOW)) {
			color = Color.YELLOW;
		} else if (codePeg.equals(CodePeg.BLACK)) {
			color = Color.BLACK;
		} else if (codePeg.equals(CodePeg.WHITE)) {
			color = Color.WHITE;
		}
		return color;
	}

	protected Color[] convertKeyPegRowToColorRow(KeyPeg[] feebackRow) {
		Color[] pegColors = new Color[4];

		for (int i = 0; i < pegColors.length; i++) {
			pegColors[i] = convertKeyPegToColor(feebackRow[i]);
		}
		return pegColors;
	}

	protected Color convertKeyPegToColor(KeyPeg keyPeg) {
		Color color = null;

		if (keyPeg.equals(KeyPeg.BLACK)) {
			color = Color.BLACK;
		} else if (keyPeg.equals(KeyPeg.WHITE)) {
			color = Color.WHITE;
		}
		return color;
	}

	public void intializeGreetingScreen() {
		greeting = new GreetingScreen();
		greeting.frmWelcome.setVisible(true);
		greeting.getPlayer1Button().addActionListener(this);
		greeting.getPlayer2Button().addActionListener(this);

	}

	public String getFailMessage() {
		String failmessage = " ";
		return failmessage;
	}

	public void setNumPlayers(int p) {
		numPlayers = p;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	private void endGame() {
		if (getNumPlayers() == 1) {
			board.playAgainButton.setText("Play Again ?");
			board.playAgainButton.setVisible(true);
 

		} else {
			// record score
			System.out.println(String.format("num guesses: %d",
					gameManager.getCurrentGuess()));
			/*
			 * Max. characters 32 (Requirement 7.4.2)
			 */

			if (gameManager.isSolved()) {
				// add one point to codebreaker's score if guess succeeds
				matchManager.getCurrentCodeBreaker().updateScore(1);

			} else {
				matchManager.getCurrentCodeMaker().updateScore(2);
			}

			// update score board
			updateScoreBoard();
			matchManager.incrementGame();

			if (matchManager.getCurrentGame() <= matchManager
					.getMaxGamesPerRound()) {
				// next game
				startNewGame();
			} else {
				if (matchManager.getCurrentRound() < matchManager
						.getMaxRounds()) {
					// next round
					matchManager.startNewRound();
					board.gameNumber
							.setText(matchManager.getCurrentGame() + "");
					board.roundNumber.setText(matchManager.getCurrentRound()
							+ "");
					startNewGame();
				} else {

					endMatch();
				}
			}
		}

	}

	private void endMatch() {
		// end of match
		String whichPlayer;
		/*
		 * At the end of a match the player with the high score will be
		 * declared the winner.  (Requirement 6.10)  A message will appear
		 * that indicates the outcome of the match (Requirement 6.11 / 9.1 / 9.2)
		 */
		if (matchManager.getPlayer1().getScore() > matchManager.getPlayer2()
				.getScore()) {
			whichPlayer = matchManager.getPlayer1().getName();
			board.message.setText(whichPlayer + ", HAS WON THE MATCH!");
		} else if (matchManager.getPlayer2().getScore() > matchManager
				.getPlayer1().getScore()) {
			whichPlayer = matchManager.getPlayer2().getName();
			board.message.setText(whichPlayer + ", HAS WON THE MATCH!");
		} else
			board.message.setText("This match was a draw!");
		board.guessButton.setEnabled(false);

		// to do: show dialog with winner
		System.out.println(String.format("Player1 Score: %d", matchManager
				.getPlayer1().getScore()));
		System.out.println(String.format("Player2 Score: %d", matchManager
				.getPlayer2().getScore()));
	}

	private void updateScoreBoard() {
		board.player1Points.setText(String.format("%d", matchManager
				.getPlayer1().getScore()));
		board.player2Points.setText(String.format("%d", matchManager
				.getPlayer2().getScore()));

	}

	private void showGuessErrorDialog() {
		JOptionPane.showMessageDialog(board,
				"You should use all 4 pegs in your guess.");
	}

	private void showSetCodeErrorDialog() {
		JOptionPane.showMessageDialog(board,
				"You should use all 4 pegs in your code.");
	}

	private void showNameSetErrorDialog() {
		JOptionPane.showMessageDialog(board,
				"Name must be less than 32 characters.");
	}

	private void beginNextGameDialog() {
		JOptionPane.showMessageDialog(board, "Ready to start next game?");
	}

	public String randomFailMessage() {
		Random random = new Random();
		int messageNumber = random.nextInt(7);
		String fail = "";
		switch (messageNumber) {
		case 0:
			fail = "Um, no. ";
			break;
		case 1:
			fail = "Nada. ";
			break;
		case 2:
			fail = "Close, but. ";
			break;
		case 3:
			fail = "Incorrect. ";
			break;
		case 4:
			fail = "Try again. ";
			break;
		case 5:
			fail = "Negative. ";
			break;
		default:
			fail = "Take a mulligan. ";
		}

		return fail;
	}
}
