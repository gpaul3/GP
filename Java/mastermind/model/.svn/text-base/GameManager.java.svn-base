package edu.uis.mastermind.model;

import java.util.Random;

/**
 * The GameManager class is responsible for managing the state of a single
 * Mastermind game.
 * <p>
 * The GameManager keeps track of the number of guesses that the Code Breaker
 * has attempted. The GameManager also acts as a proxy between the
 * GameController and the GameBoard so that the GameController does not need to
 * manipulate the GameBoard directly. In addition, the GameManager is
 * responsible for resetting the game board to its initial state after each
 * game.
 * 
 */
public class GameManager {

	private int maxGuesses = 10;
	private int currentGuess = 1;
	private GameBoard gameBoard = new GameBoard();
	private static final Random RANDOM = new Random();

	/**
	 * Returns the current guess count.
	 * 
	 * @return the current guess count
	 */
	public int getCurrentGuess() {
		return currentGuess;
	}

	/**
	 * Returns the maximum number of guesses allowed in each game.
	 * <p>
	 * Currently, the maximum number of guesses allowed is set to 10.
	 * (Requirement 5.2, Requirement 6.1.1)
	 * 
	 * @return maximum number of guesses allowed
	 */
	public int getMaxGuesses() {
		return maxGuesses;
	}

	/**
	 * Start a brand new game. Resets the state of the Manager and the Game
	 * Board.
	 */
	public void startGame() {
		currentGuess = 1;
		gameBoard.reset();
	}

	/**
	 * Set the code row to a Random set of Code Pegs. This is used in single
	 * player game mode. (Requirement 5.1)
	 */
	public void setRandomCode() {
		CodePeg[] randomRow = new CodePeg[4];
		for (int i = 0; i < 4; i++) {
			randomRow[i] = CodePeg.values()[RANDOM
					.nextInt(CodePeg.values().length - 1)];
		}
		gameBoard.setCodeRow(randomRow);
	}

	/**
	 * increment the guess count
	 */
	public void incrementGuess() {
		currentGuess++;
	}

	/**
	 * Passes the current guess to the game board. The game board returns the
	 * key peg values associated with the guess. The feedback is returned as an
	 * array of KeyPegs from this method. (Requirement 5.3, Requirement 6.4)
	 * 
	 * @param guess
	 *            an array of CodePegs
	 * @return an array of KeyPegs
	 */
	public KeyPeg[] makeGuess(CodePeg[] guess) {
		int currentRow = currentGuess - 1;
		return gameBoard.setGuessRow(currentRow, guess);
	}

	/**
	 * Check if the code breaker has solved the code. If the return value is
	 * true then the code breaker has cracked the secret code.
	 * (Requirement 5.2, Requirement 6.1.1)
	 * 
	 * @return the state of the game board
	 */
	public boolean isSolved() {
		return gameBoard.isSolved();
	}

	/**
	 * Gets the computer generated code row. Used when in single player mode.
	 * 
	 * @return an array of CodePeg values
	 */
	public CodePeg[] getCodeRow() {
		return gameBoard.getCodeRow();
	}

	/**
	 * Sets the code row created by the code maker. Used in two player game
	 * mode.
	 * 
	 * @param an
	 *            array of CodePeg values
	 */
	public void setCodeRow(CodePeg[] code) {
		gameBoard.setCodeRow(code);
	}

}
