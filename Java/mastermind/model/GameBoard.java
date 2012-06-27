package edu.uis.mastermind.model;

import java.util.ArrayList;

/**
 * The GameBoard is the logical representation of the Mastermind game board.
 * <p>
 * The main components of the GameBoard class are 3 arrays that represent the 3
 * main components of the physical game board. These components are:
 * <ol>
 * <li>The Code Row Ð represented by a single dimensional array of Code Pegs.
 * This is where the Code Maker's secret code is stored. The Code Row is exposed
 * in a 2 player game so that the code maker can create a secret code. The Code
 * Row is covered by the Code Shield to hide the secret code from the Code
 * Breaker. (Requirement 1.1.1)
 * 
 * <li>The Guess Rows Ð represented by a 2 dimensional array named Code Pegs.
 * These represent the Code Breaker's attempts to guess the secret code. Each
 * Guess Row is enabled one at a time until the Code Breaker has had 10 attempts
 * at guessing the secret code. (Requirement 1.2.1, Requirement 1.2.2.1)
 * 
 * <li>The Feedback Rows Ð represented in the GameBoard class as a 2 dimensional
 * array of Key Pegs. The rows in this array represent the feedback for each
 * guess that the Code Breaker has attempted. (Requirement 1.2.3.1)
 * </ol>
 * 
 * The color Code Peg and Key Peg values are represented by enum types that are
 * held in the GameBoard classes' 3 main component arrays.
 * 
 */
public class GameBoard {

	private CodePeg[] codeRow = new CodePeg[4];
	private CodePeg[][] guessRow = new CodePeg[10][4];
	private KeyPeg[][] feedbackRow = new KeyPeg[10][4];
	private boolean isSolved = false;

	/**
	 * class constructor
	 */
	public GameBoard() {
		reset();
	}

	/**
	 * Set the values of the code row by passing in each CodePeg value
	 * individually.
	 * 
	 * @param p0
	 *            a CodePeg value
	 * @param p1
	 *            a CodePeg value
	 * @param p2
	 *            a CodePeg value
	 * @param p3
	 *            a CodePeg value
	 */
	public void setCodeRow(CodePeg p0, CodePeg p1, CodePeg p2, CodePeg p3) {
		codeRow[0] = p0;
		codeRow[1] = p1;
		codeRow[2] = p2;
		codeRow[3] = p3;
	}

	/**
	 * Set the values of the code row by passing in all values in an array.
	 * 
	 * @param code
	 *            an array of CodePeg values
	 */
	public void setCodeRow(CodePeg[] code) {
		for (int i = 0; i < codeRow.length; i++) {
			codeRow[i] = code[i];
		}
	}

	/**
	 * Returns the values in the Code Row as an array of CodePeg values
	 * 
	 * @return an array of CodePeg values
	 */
	public CodePeg[] getCodeRow() {
		return codeRow;
	}

	/**
	 * Returns the values for a specified Guess Row as an array of CodePeg
	 * values.
	 * 
	 * @param row
	 *            the index to the Guess Row.
	 * @return an array of CodePeg values.
	 */
	public CodePeg[] getGuessRow(int row) {
		return guessRow[row];
	}

	/**
	 * Sets the values of the specified Guess Row and then calls the
	 * setFeedbackRow method to obtain the results of the guess.
	 * 
	 * @param row
	 *            the Guess Row to set
	 * @param guess
	 *            an array of CodePeg values
	 * @return an array of KeyPeg values
	 */
	public KeyPeg[] setGuessRow(int row, CodePeg[] guess) {
		for (int i = 0; i < guessRow[row].length; i++) {
			guessRow[row][i] = guess[i];
		}
		return setFeedbackRow(row);
	}

	/**
	 * Determines the values for the Feedback Row based on the values of the
	 * current Guess Row and the Code Row. Sets the Game Board's state to solved
	 * if all CodePegs in the Guess Row match the Code Row. (Requirement
	 * 1.2.3.2, Requirement 1.2.3.3)
	 * 
	 * @param row
	 *            the index of the Feedback Row to set
	 * @return an array of KeyPeg values
	 */
	private KeyPeg[] setFeedbackRow(int row) {

		ArrayList<CodePeg> colorCheckList = new ArrayList<CodePeg>();

		// first check if there are any code pegs in the correct position with
		// correct color
		for (int i = 0; i < guessRow[row].length; i++) {
			if (guessRow[row][i].equals(codeRow[i])) {
				feedbackRow[row][i] = KeyPeg.BLACK;
			} else {
				colorCheckList.add(codeRow[i]);
			}
		}

		if (colorCheckList.size() > 0) {
			// check the remainder for any matching colors
			int foundAtIndex;
			for (int i = 0; i < guessRow[row].length; i++) {
				if (feedbackRow[row][i].equals(KeyPeg.NONE)) {
					foundAtIndex = colorCheckList.indexOf(guessRow[row][i]);
					if (foundAtIndex != -1) {
						feedbackRow[row][i] = KeyPeg.WHITE;
						colorCheckList.remove(foundAtIndex);
					}
				}
			}
		} else {
			isSolved = true;
		}
		return feedbackRow[row];
	}

	/**
	 * Return the solved state of the Game Board. If the return value is true
	 * then the Code Breaker has solved the secret code.
	 * (Requirement 5.2, Requirement 6.1.1)
	 * 
	 * @return the current state of the game board
	 */
	protected boolean isSolved() {
		return isSolved;
	}

	/**
	 * Resets the game board to its initial state.
	 */
	public void reset() {
		isSolved = false;

		for (int i = 0; i < codeRow.length; i++) {
			codeRow[i] = CodePeg.NONE;
		}

		for (int i = 0; i < guessRow.length; i++) {
			for (int j = 0; j < guessRow[i].length; j++) {
				guessRow[i][j] = CodePeg.NONE;
			}
		}

		for (int i = 0; i < feedbackRow.length; i++) {
			for (int j = 0; j < feedbackRow[i].length; j++) {
				feedbackRow[i][j] = KeyPeg.NONE;
			}
		}
	}
}
