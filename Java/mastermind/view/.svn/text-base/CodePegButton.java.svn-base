package edu.uis.mastermind.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The CodePegButton is a subclass of the JButton class and it is used to
 * represent a single Code Peg.
 */
public class CodePegButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int click = 0;
	Color bg = null;

	/**
	 * constructor
	 */
	public CodePegButton() {
		super();
		addActionListener(this);
		setText("");
	}

	/**
	 * Called when the button is clicked. Cycles through the 6 valid Code Peg
	 * colors. (Requirement 1.1.2, Requirement 1.2.2.2, Requirement 2.0)
	 */
	public void actionPerformed(ActionEvent e) {
		click++;

		switch (click) {
		/* Red Code Peg (Requirement 2.1) */
		case 1:
			bg = Color.RED;
			break;
		/* Blue Code Peg (Requirement 2.2) */
		case 2:
			bg = Color.BLUE;
			break;
		/* Green Code Peg (Requirement 2.3) */
		case 3:
			bg = Color.GREEN;
			break;
		/* Yellow Code Peg (Requirement 2.4) */
		case 4:
			bg = Color.YELLOW;
			break;
		/* Black Code Peg (Requirement 2.5) */
		case 5:
			bg = Color.BLACK;
			break;
		/* White Code Peg (Requirement 2.6) */
		case 6:
			bg = Color.WHITE;
			break;
		default:
			click = 1;
			bg = Color.RED;
		}
		setBackground(bg);
		setOpaque(true);
	}

	/**
	 * Resets the button to its initial state.
	 */
	public void reset() {
		bg = null;
		click = 0;
	}
}
