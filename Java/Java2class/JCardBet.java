import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCardBet extends JApplet implements ActionListener
{
	Container con = getContentPane();
	JLabel greeting = new JLabel ("***Bet The Card***");
	JLabel compCard = new JLabel ("");
	JLabel myCard = new JLabel ("");
	JLabel countTotal = new JLabel ("");
	Font firstFont = new Font("Garamond", Font.BOLD, 32);
	Font secondFont = new Font("Times New Roman", Font.BOLD, 20);
	JButton fhButton = new JButton("$5 Higher");
	JButton thButton = new JButton("$10 Higher");
	JButton flButton = new JButton("$5 Lower");
	JButton tlButton = new JButton("$10 Lower");
	JButton oButton = new JButton("OK");
//array for deck of cards
	String [] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
	String [] rank = {"Two", "Three", "Four", "Five", "Six", "Seven",
		"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	int [] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13};
	String cCard, mCard;
	int cValue, yValue, myValue, coValue, newTotal;
	int total = 10;
	int deal = 0;
	Color R = new Color (196, 67, 28);
	Color G = new Color (66, 204, 68);

	public void init()
	{
		setLayout(null);
		setSize(400,400);
		con.setBackground(G);
		greeting.setFont(firstFont);
		greeting.setForeground(R);
		greeting.setBounds(60,30,300,40);
		con.add(greeting);
//deal first computer card
		coValue = getCValue();
		compCard.setFont(secondFont);
		compCard.setText(cCard);
		compCard.setBounds(50,70,300,40);
		con.add(compCard);
		fhButton.setBounds(90,120,100,30);
		fhButton.setBackground(Color.BLACK);
		fhButton.setForeground(R);
		con.add(fhButton);
		thButton.setBounds(200,120,100,30);
		thButton.setBackground(Color.BLACK);
		thButton.setForeground(Color.WHITE);
		con.add(thButton);
		flButton.setBounds(90,160,100,30);
		flButton.setBackground(R);
		flButton.setForeground(Color.WHITE);
		con.add(flButton);
		tlButton.setBounds(200,160,100,30);
		tlButton.setBackground(R);
		tlButton.setForeground(Color.BLACK);
		con.add(tlButton);
		fhButton.addActionListener(this);
		thButton.addActionListener(this);
		flButton.addActionListener(this);
		tlButton.addActionListener(this);
		myCard.setForeground(R);
		myCard.setBounds(50,190,300,40);
		myCard.setFont(secondFont);
		con.add(myCard);
		countTotal.setText("Starting with $" + total);
		countTotal.setForeground(Color.WHITE);
		countTotal.setBounds(95,220,280,40);
		countTotal.setFont(secondFont);
		con.add(countTotal);
		oButton.setBounds(150,270,100,30);
		con.add(oButton);
		oButton.setEnabled(false);
		validate();
	}
//check to see if totoal winnings are 0 or 100 else display total
	public void display()
	{
		total = newTotal;
		if(total <= 0)
		{
			countTotal.setText("You are broke, my friend.");
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(false);
		}
		else if(total >= 100)
		{
			countTotal.setText("You just won $100!");
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(false);
		}
		else
		{
			countTotal.setText("Your new total is $" + total);
		}
//check to see if 52 cards have been dealt
		if(deal == 52)
		{
			countTotal.setText("The deck is exhausted!");
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(false);
		}
		validate();
	}

	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();

		if(source == fhButton)
		{
			myValue = getMValue();
			myCard.setText(mCard);
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(true);
			oButton.addActionListener(this);

			if (myValue > coValue)
			{
				newTotal = total + 5;
				display();
			}

			else
			{
				newTotal = total - 5;
				display();
			}
		}

		else if(source == thButton)
		{
			myValue = getMValue();
			myCard.setText(mCard);
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(true);
			oButton.addActionListener(this);
			if (myValue > coValue)
			{
				newTotal = total + 10;
				display();
			}
			else
			{
				newTotal = total - 10;
				display();
			}

		}
		else if(source == flButton)
		{
			myValue = getMValue();
			myCard.setText(mCard);
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(true);
			oButton.addActionListener(this);
			if (myValue < coValue)
			{
				newTotal = total + 5;
				display();
			}
			else
			{
				newTotal = total - 5;
				display();
			}
		}
		else if(source == tlButton)
		{
			myValue = getMValue();
			myCard.setText(mCard);
			fhButton.setEnabled(false);
			thButton.setEnabled(false);
			flButton.setEnabled(false);
			tlButton.setEnabled(false);
			oButton.setEnabled(true);
			oButton.addActionListener(this);
			if (myValue < coValue)
			{
				newTotal = total + 10;
				display();
			}
			else
			{
				newTotal = total - 10;
				display();
			}
		}
		else
		{
			coValue = getCValue();
			compCard.setText(cCard);
			myCard.setText("");
			fhButton.setEnabled(true);
			thButton.setEnabled(true);
			flButton.setEnabled(true);
			tlButton.setEnabled(true);
			oButton.setEnabled(false);
			fhButton.addActionListener(this);
			thButton.addActionListener(this);
			flButton.addActionListener(this);
			tlButton.addActionListener(this);
		}
		++deal;
		validate();


	}
//get value of players cards
		public int getCValue()
		{
			int cR = ((int)(Math.random() * 100) % 13 + 1);
			int cS = ((int)(Math.random() * 100) % 4 + 1);
			cCard = "Computer : " + rank[cR] + " of " + suit[cS];
			int cValue = value[cR];
			return cValue;
		}
//get value of computers card
		public int getMValue()
		{
			int yR = ((int)(Math.random() * 100) % 13 + 1);
			int yS = ((int)(Math.random() * 100) % 4 + 1);
			mCard = "Your card : " + rank[yR] + " of " + suit[yS];
			yValue = value[yR];
			return yValue;
		}

	}










