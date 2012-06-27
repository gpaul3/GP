package edu.uis.mastermind.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * The KeyPegPanel class is used to render the Feedback Rows on the game board.
 */
public class KeyPegPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	KeyPegButton[][] keyPegs;

	/**
	 * constructor
	 * 
	 * @param rows
	 *            number of Feedback Rows
	 */
	public KeyPegPanel(int rows) {
		initialize(rows);
	}

	/**
	 * Called from the constructor to set up the Key Peg Panel.
	 * 
	 * @param rows
	 *            number of Feedback Rows
	 */
	public void initialize(int rows) {

		setBounds(215, 83, 94, 407);
		setLayout(new GridLayout(0, 4, 5, 20));
		setBackground(new Color(220, 220, 220));
		keyPegs = new KeyPegButton[rows][4];
		for (int i = 0; i < keyPegs.length; i++) {
			for (int j = 0; j < keyPegs[i].length; j++) {
				keyPegs[i][j] = new KeyPegButton();
				keyPegs[i][j].setEnabled(false);
				add(keyPegs[i][j]);
			}
		}
	}

	/**
	 * Sets the KeyPegButton Color values for a specified row.
	 * 
	 * @param row
	 *            the row to set
	 * @param feedback
	 *            an array of Color values
	 */
	public void setPegColorsForRow(int row, Color[] feedback) {

		for (int i = 0; i < feedback.length; i++) {
			keyPegs[row][i].setBackground(feedback[i]);
			keyPegs[row][i].setOpaque(true);
		}
	}

	/**
	 * Resets the Key Peg Panel to its initial state.
	 */
	public void reset() {
		for (int i = 0; i < keyPegs.length; i++) {
			for (int j = 0; j < keyPegs[i].length; j++) {
				keyPegs[i][j].setBackground(null);
			}
		}
	}
}
