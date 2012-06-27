package edu.uis.mastermind.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * The CodePegPanel class is used to create both the single Code Row and the 10
 * Guess Rows of the game.
 */
public class CodePegPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	CodePegButton[][] codePegs;

	/**
	 * constructor
	 * 
	 * @param rows
	 *            the number of rows to create
	 * @param bounds
	 *            the bounds for the JPanel layout
	 */
	public CodePegPanel(int rows, int[] bounds) {
		initialize(rows, bounds);
	}

	/**
	 * Initialize method called by the constructor to set up the Code Peg Panel
	 * 
	 * @param rows
	 *            the number of rows to create
	 * @param bounds
	 *            the bounds for the JPanel layout
	 */
	public void initialize(int rows, int[] bounds) {

		setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		setLayout(new GridLayout(0, 4, 5, 5));
		setBackground(new Color(220, 220, 220));

		codePegs = new CodePegButton[rows][4];
		for (int i = 0; i < codePegs.length; i++) {
			for (int j = 0; j < codePegs[i].length; j++) {
				codePegs[i][j] = new CodePegButton();
				codePegs[i][j].setEnabled(false);
				add(codePegs[i][j]);
			}
		}

		// enable the last row
		enableRow(codePegs.length - 1, true);
	}

	/**
	 * Enables a specified row.
	 * 
	 * @param row
	 *            the index of the row to enable
	 * @param enableFlag
	 *            a boolean to say whether or not to enable the row
	 */
	public void enableRow(int row, boolean enableFlag) {
		for (CodePegButton codePeg : codePegs[row]) {
			codePeg.setEnabled(enableFlag);
		}
	}

	/**
	 * Returns the Color values for a specified row.
	 * 
	 * @param row
	 *            the row to return
	 * @return an array of Color values
	 */
	public Color[] getPegColorsForRow(int row) {
		Color rowColors[] = new Color[4];
		int colNum = 0;
		for (CodePegButton codePeg : codePegs[row]) {
			rowColors[colNum] = codePeg.getBackground();
			colNum++;
		}
		return rowColors;
	}

	/**
	 * Returns the Color values for the first row. Meant to be used for the Code
	 * Row.
	 * 
	 * @return an array of Color values
	 */
	public Color[] getPegColors() {
		Color rowColors[] = new Color[4];
		int colNum = 0;
		for (CodePegButton codePeg : codePegs[0]) {
			rowColors[colNum] = codePeg.getBackground();
			colNum++;
		}
		return rowColors;
	}

	/**
	 * Sets the Color values for the first row. Meant to be used for the Code
	 * Row.
	 * 
	 * @param colors
	 *            an array of Color values
	 */
	public void setPegColors(Color[] colors) {
		int colNum = 0;
		for (CodePegButton codePeg : codePegs[0]) {
			codePeg.setBackground(colors[colNum]);
			codePeg.setOpaque(true);
			colNum++;
		}
	}

	/**
	 * Resets the panel to its initial state.
	 */
	public void reset() {
		for (int i = 0; i < codePegs.length; i++) {
			for (int j = 0; j < codePegs[i].length; j++) {
				codePegs[i][j].reset();
				codePegs[i][j].setBackground(null);
				codePegs[i][j].setEnabled(false);
			}
		}
	}
}
