using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Craps
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        private int dice1, dice2, sum = 0; 
        private static int pointValue;

        public Window1()
        {
            InitializeComponent();
        }

        private void rollDice()
        {
            Random diceroll = new Random();
            dice1 = diceroll.Next(1,7);
            dice2 = diceroll.Next(1,7);
        }
    

        private void buttonPlay_Click(object sender, RoutedEventArgs e)
        {
            rollDice();
            rollBox.Text = "Outcome is " + dice1 + "," + dice2;
            sum = dice1 + dice2;
            sumBox.Text = "Sum is " + sum.ToString();

            switch (sum)
            {
                case 7 :
                    resultBox.Text = "You Win!!";
                    buttonRoll.IsEnabled = false;
                    break;

                case 11:
                    resultBox.Text = "You Win!!";
                    buttonRoll.IsEnabled = false;
                    break;

                case 2:
                    resultBox.Text = "House Wins..";
                    buttonRoll.IsEnabled = false;
                    break;

                case 3:
                    resultBox.Text = "House Wins..";
                    buttonRoll.IsEnabled = false;
                    break;

                case 12:
                    resultBox.Text = "House Wins..";
                    buttonRoll.IsEnabled = false;
                    break;
                
                default :
                    sumBox.Text = "Point value: " + sum;
                    buttonRoll.IsEnabled = true;
                    buttonPlay.IsEnabled = false;
                    pointValue = sum;
                    resultBox.Text = "Roll again...";
                    break;    

            }
            
        }

        private void buttonRoll_Click(object sender, RoutedEventArgs e)
        {

            rollDice();
            rollBox.Text = "Outcome is " + dice1 + ", " + dice2;
            sum = dice1 + dice2;
            sumBox.Text = "Sum is " + sum.ToString();

            if (sum == pointValue)
            {
                resultBox.Text = "You Win!!";
                buttonRoll.IsEnabled = false;
                buttonPlay.IsEnabled = true;
            }

            else if (sum == 7)
            {
                resultBox.Text = "House Wins..";
                buttonRoll.IsEnabled = false;
                buttonPlay.IsEnabled = true;
            }
            else
            {
                ;
            }   
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

        }

      
    }
}
