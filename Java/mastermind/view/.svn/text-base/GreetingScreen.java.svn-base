package edu.uis.mastermind.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class GreetingScreen {

	public JFrame frmWelcome;
	private JButton player1Button;
	private JButton player2Button;

	// Create the application.
	public GreetingScreen() {
		initialize();
	}

	// Initialize the contents of the frame.

	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.getContentPane().setBackground(new Color(176, 196, 222));
		frmWelcome.setTitle("Welcome ");
		frmWelcome.setBounds(100, 100, 445, 365);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);

		player1Button = new JButton("1 player");
		player1Button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		player1Button.setBackground(UIManager.getColor("Button.light"));
		player1Button.setBounds(91, 200, 239, 41);
		player1Button.setActionCommand("PLAYER_1");
		frmWelcome.getContentPane().add(player1Button);

		player2Button = new JButton("2 player");
		player2Button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		player2Button.setBackground(UIManager.getColor("Button.light"));
		player2Button.setBounds(91, 261, 239, 41);
		player2Button.setActionCommand("PLAYER_2");
		frmWelcome.getContentPane().add(player2Button);

		/*
		 * player2Button.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { NameEntryForm window =
		 * new NameEntryForm(); window.frmPlayers.setVisible(true);
		 * frmWelcome.setVisible(false); } });
		 */

		JLabel lblMastermind = new JLabel("Mastermind");
		lblMastermind.setFont(new Font("Vivaldi", Font.PLAIN, 70));
		lblMastermind.setBounds(54, 11, 313, 87);
		frmWelcome.getContentPane().add(lblMastermind);

		CodePegButton peg1 = new CodePegButton();
		peg1.setBounds(65, 115, 40, 10);
		frmWelcome.getContentPane().add(peg1);

		CodePegButton peg2 = new CodePegButton();
		peg2.setBounds(115, 115, 40, 10);
		frmWelcome.getContentPane().add(peg2);

		CodePegButton peg3 = new CodePegButton();
		peg3.setBounds(165, 115, 40, 10);
		frmWelcome.getContentPane().add(peg3);

		CodePegButton peg4 = new CodePegButton();
		peg4.setBounds(215, 115, 40, 10);
		frmWelcome.getContentPane().add(peg4);

		CodePegButton peg5 = new CodePegButton();
		peg5.setBounds(267, 115, 40, 10);
		frmWelcome.getContentPane().add(peg5);

		CodePegButton peg6 = new CodePegButton();
		peg6.setBounds(317, 115, 40, 10);
		frmWelcome.getContentPane().add(peg6);

		peg1.setBackground(Color.RED);
		peg2.setBackground(Color.BLUE);
		peg3.setBackground(Color.GREEN);
		peg4.setBackground(Color.YELLOW);
		peg5.setBackground(Color.BLACK);
		peg6.setBackground(Color.WHITE);
		peg1.setEnabled(false);
		peg2.setEnabled(false);
		peg3.setEnabled(false);
		peg4.setEnabled(false);
		peg5.setEnabled(false);
		peg6.setEnabled(false);

		// plasyer selects game modes
		JLabel lblPleaseSelectGame = new JLabel("Please select game mode ");
		lblPleaseSelectGame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPleaseSelectGame.setBounds(95, 149, 313, 29);
		frmWelcome.getContentPane().add(lblPleaseSelectGame);
	}

	public JButton getPlayer1Button() {
		return player1Button;
	}

	public JButton getPlayer2Button() {
		return player2Button;
	}
}
