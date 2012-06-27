import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JRockPaperScissors extends JApplet implements ActionListener
{
	JLabel greeting = new JLabel ("Rock, Paper, Scissors");
	JLabel choose = new JLabel ("c  h  o  o  s  e    a    b  u  t  t  o  n");
	JLabel results = new JLabel("-  -  -  -  -  -  r   e   s   u   l   t   s  -  -  -  -  -  -");
	JLabel message = new JLabel ("");
	JLabel winner = new JLabel ("");
	JLabel score = new JLabel ("");

	Font firstFont = new Font("Century Gothic", Font.BOLD, 28);
	Font secondFont = new Font("Arial", Font.BOLD, 14);

	JButton rButton = new JButton("rock");
	JButton pButton = new JButton("paper");
	JButton sButton = new JButton("scissors");

	int uChoice, cChoice, uScore, cScore, countTie, countLoss, countWin;
	String result = "";
	String uName, cName;


	public void init ()
	{
//set up applet layout and colors
		Container con = getContentPane();
		con.setLayout(null);
		con.setSize(300,400);
		con.setBackground(Color.BLACK);
		greeting.setFont(firstFont);
		greeting.setBounds(50,30,300,30);
		con.add(greeting);
		greeting.setForeground(Color.RED);
	  	choose.setFont(secondFont);
		choose.setBounds(85,60,280,30);
		con.add(choose);
		choose.setForeground(Color.LIGHT_GRAY);
		rButton.setBounds(20,90,110,35);
	   con.add(rButton);
	   rButton.setBackground(Color.PINK);
	   pButton.setBounds(140,90,110,35);
		con.add(pButton);
	  	pButton.setBackground(Color.YELLOW);
	   sButton.setBounds(260,90,110,35);
		con.add(sButton);
	   sButton.setBackground(Color.GREEN);
	   results.setBounds(50, 133, 290, 30);
		results.setFont(secondFont);
	   results.setForeground(Color.LIGHT_GRAY);
		rButton.addActionListener(this);
		pButton.addActionListener(this);
		sButton.addActionListener(this);
		con.add(results);
		message.setBounds(50,162,300,30);
		con.add(message);
		message.setForeground(Color.WHITE);
		winner.setBounds(50,180,280,40);
		con.add(winner);
		winner.setForeground(Color.RED);
		score.setForeground(Color.WHITE);
		score.setBounds(50,200,280,40);
		con.add(score);
		display();

	}
///display score
	public void display()
	{
		message.setText("You picked " + uName + " | The Computer picked " + cName);
		winner.setText(result);
		score.setText("You: " + countWin + " | Computer: " + countLoss + " | Ties: " + countTie);
	}
///player makes choice
	 public void actionPerformed(ActionEvent e)
	  {
		Object source = e.getSource();
		if(source == rButton)
		{
			uChoice = 1;
			uName = "Rock";
		}
		else if (source == pButton)
		{
			uChoice = 2;
			uName = "Paper";
		}
		else
		{
			uChoice = 3;
			uName = "Scissors";
		}
///computer makes choice
		cChoice = (1 + (int) (Math.random() * 3));
		if (cChoice == 1)
		{
			cName = "Rock";
		}
		else if (cChoice == 2)
		{
			cName = "Paper";
		}
		else
		{
			cName = "Scissors";
		}

///winner is decided
		if (uChoice == cChoice)
		{
			++countTie;
			result = "It is a tie. I guess great minds think alike.";
			display();
		}

		else if ((uChoice == 2 && cChoice == 1) || (uChoice == 3 && cChoice == 2) || (uChoice == 1 && cChoice == 3))
		{
			++countWin;
			result= "Congratulaitons - you win!!";
			display();
		}
		else
		{
			++countLoss;
			result = "Sorry, the computer won this time.";
			display();
		}
	}
}


