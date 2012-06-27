import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


	public class JMadLib extends JApplet implements ActionListener
	{
		Container con = getContentPane();
		JLabel greeting = new JLabel ("Welcome to Mad Libs !");
		JLabel line1 = new JLabel ("Enter your favorite city.");
		JLabel line2 = new JLabel ("Which animal are you most afraid of?");
		JLabel line3 = new JLabel ("Name an object you see in front of you.");
		JLabel line4 = new JLabel ("What is your favorite dinner entree ?");
		JLabel rhyme1 = new JLabel ("");
		JLabel rhyme2 = new JLabel ("");
		JLabel rhyme3 = new JLabel ("");
		JLabel rhyme4 = new JLabel ("");
		Font firstFont = new Font("Gramond", Font.BOLD, 30);
		Font secondFont = new Font ("Garmond", Font.ITALIC, 24);
		Font rhymeFont = new Font ("Garmond", Font.BOLD, 28);
		JTextField field1 = new JTextField(10);
		JTextField field2 = new JTextField(10);
		JTextField field3 = new JTextField(10);
		JTextField field4 = new JTextField(10);
		JButton pButton = new JButton("press me");
		int click = 0;

		public void init ()
		{
//set up applet layout and colors
			setSize(500,300);
			setLayout(null);
			con.setBackground(Color.DARK_GRAY);
			greeting.setFont(firstFont);
			greeting.setBounds(20,20,480,30);
			greeting.setForeground(Color.PINK);
			con.add(greeting);
			setForeground(Color.PINK);
			pButton.setBounds(20,120,100,30);
			con.add(pButton);
			line1.setBounds(20,50,480,30);
			con.add(line1);
			line1.setFont(secondFont);
			line1.setForeground(Color.WHITE);
			field1.setBounds(20,90,100,20);
			con.add(field1);
			field1.requestFocus();
			pButton.setBackground(Color.LIGHT_GRAY);
			pButton.addActionListener(this);
		}
//actionlistener keeps track of number of clicks and removes and adds lines for madlib rhyme
//request focus on textfields prepare user to enter next word
		public void actionPerformed(ActionEvent e)
	  	{
			++click;
			if(click == 1)
			{
				remove(line1);
				remove(field1);
				line2.setFont(secondFont);
				line2.setBounds(20,50,480,30);
				field2.setBounds(20,90,100,20);
				line2.setForeground(Color.WHITE);
				con.add(line2);
				con.add(field2);
				field2.requestFocus();
				repaint();
				validate();
			}
			else if(click == 2)
			{
				remove(line2);
				remove(field2);
				line3.setFont(secondFont);
				line3.setForeground(Color.WHITE);
				con.add(line3);
				con.add(field3);
				line3.setBounds(20,50,480,30);
				field3.setBounds(20,90,100,20);
				field3.requestFocus();
				repaint();
				validate();
			}
			else if(click == 3)
			{
				remove(line3);
				remove(field3);
				line4.setFont(secondFont);
				line4.setForeground(Color.WHITE);
				con.add(line4);
				con.add(field4);
				line4.setBounds(20,50,480,30);
				field4.setBounds(20,90,100,20);
				field4.requestFocus();
				repaint();
				validate();
			}
//fourth click displays finished rhyme with input from user
//and also changes font and screen color
			else if(click == 4)
			{
				con.setBackground(Color.PINK);
			  	String word1 = field1.getText();
				String word2 = field2.getText();
				String word3 = field3.getText();
				String word4 = field4.getText();
				remove(line4);
				remove(field4);
				remove(pButton);
				greeting.setFont(firstFont);
				greeting.setText("Completed Rhyme");
				greeting.setForeground(Color.DARK_GRAY);
				con.add(greeting);
				greeting.setBounds(20,20,480,40);
				rhyme1.setBounds(20,60,480,40);
				rhyme2.setBounds(20,100,480,40);
				rhyme3.setBounds(20,140,480,40);
				rhyme4.setBounds(20,180,480,40);
				rhyme1.setFont(rhymeFont);
				rhyme2.setFont(rhymeFont);
				rhyme3.setFont(rhymeFont);
				rhyme4.setFont(rhymeFont);
				rhyme1.setForeground(Color.WHITE);
				rhyme2.setForeground(Color.WHITE);
				rhyme3.setForeground(Color.WHITE);
				rhyme4.setForeground(Color.WHITE);
				rhyme1.setText("Yankee Doodle went to " + word1 + ",");
				rhyme2.setText("riding on a " + word2 + ".");
				rhyme3.setText("He stuck a " + word3 + " in his hat, ");
				rhyme4.setText("and called it " + word4 + "!");
				con.add(rhyme1);
				con.add(rhyme2);
				con.add(rhyme3);
				con.add(rhyme4);
				repaint();
				validate();
			}
			repaint();
			validate();

		}
	}



