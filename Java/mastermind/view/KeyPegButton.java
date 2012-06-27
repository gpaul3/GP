package edu.uis.mastermind.view;

import java.awt.Color;

import javax.swing.JButton;

/**
 * The KeyPegButton is a subclass of the JButton class and it is used to
 * represent a single Key Peg. (Requirement 3.0)
 */
public class KeyPegButton extends JButton {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 */
	public KeyPegButton() {
		super();
	}

	/**
	 * sets the Key Peg to the color Black (Requirement 3.1)
	 */
	public void setBlack() {
		setColor(Color.BLACK);
	}

	/**
	 * Sets the Key Peg to the color White (Requirement 3.2)
	 */
	public void setWhite() {
		setColor(Color.WHITE);
	}

	/**
	 * Sets the Key Peg to the specified color.
	 * 
	 * @param c
	 *            the color to set the Key Peg to.
	 */
	protected void setColor(Color c) {
		setBackground(c);
		setOpaque(true);
	}
}
