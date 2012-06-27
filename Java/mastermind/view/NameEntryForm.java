package edu.uis.mastermind.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameEntryForm {

	public JFrame frmPlayers;
	public JTextField p1NameField;
	public JTextField p2NameField;
	String player1Name, player2Name;
	public JButton okButton, cancelButton;

	/**
	 * Create the application.
	 */
	public NameEntryForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayers = new JFrame();
		frmPlayers.getContentPane().setBackground(new Color(173, 216, 230));
		frmPlayers.getContentPane().setLayout(null);

		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(117, 11, 207, 87);
		lblPlayers.setFont(new Font("Vivaldi", Font.PLAIN, 60));
		frmPlayers.getContentPane().add(lblPlayers);
		
		/*
		 * Form message."Please enter your names." (Requirement 7.1)
		 */

		JLabel lblPleaseEnterPlayers = new JLabel("Please enter your names:");
		lblPleaseEnterPlayers
				.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPleaseEnterPlayers.setBounds(85, 109, 313, 29);
		frmPlayers.getContentPane().add(lblPleaseEnterPlayers);

		okButton = new JButton("OK");
		okButton.setBackground(SystemColor.controlHighlight);
		okButton.setBounds(59, 265, 92, 41);
		okButton.setActionCommand("OK");
		frmPlayers.getContentPane().add(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(SystemColor.controlHighlight);
		cancelButton.setBounds(283, 265, 92, 41);
		cancelButton.setActionCommand("CANCEL");
		frmPlayers.getContentPane().add(cancelButton);
		
		/*
		 * Form labels.(Requirement 7.2/7.3)
		 */

		JLabel lblPlayer = new JLabel("Player 1:");
		lblPlayer.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPlayer.setBounds(59, 153, 71, 29);
		frmPlayers.getContentPane().add(lblPlayer);

		JLabel lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPlayer_1.setBounds(59, 201, 71, 29);
		frmPlayers.getContentPane().add(lblPlayer_1);
		
		/*
		 * Name fields.(Requirement 7.4/7.5)
		 */

		p1NameField = new JTextField("");
		p1NameField.setBounds(140, 156, 235, 26);
		frmPlayers.getContentPane().add(p1NameField);
		p1NameField.setColumns(10);

		p2NameField = new JTextField("");
		p2NameField.setColumns(10);
		p2NameField.setBounds(140, 205, 235, 26);
		frmPlayers.getContentPane().add(p2NameField);

		frmPlayers.setTitle("Name Entry Form");
		frmPlayers.setBounds(100, 100, 445, 365);
		frmPlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton getOKButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}
