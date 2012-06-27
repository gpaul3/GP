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

namespace A_Security_Panel
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        private int enteredCode;
        private string personnel = "";
        DateTime currently = DateTime.Now;
       
 
        public Window1()
        {
            InitializeComponent();
        }
        private void getPassword()
        {
                enteredCode = int.Parse(passwordBox1.Password);
           
                if (enteredCode == 1645 || enteredCode == 1689)
                {
                    personnel = "Technicians";
                    logBox.Text = currently + "\nAccess granted : " + "\n" + personnel;
                    passwordBox1.Password = "";
                }
                else if (enteredCode == 8345)
                {
                    personnel = "Custodians";
                    logBox.Text = currently + "\nAccess granted :  " + "\n" + personnel;
                    passwordBox1.Password = "";
                }

                else if (enteredCode == 1006 || enteredCode == 1007 || enteredCode == 1008 || enteredCode == 9998)
                {
                    personnel = "Scientists";
                    logBox.Text = currently + "\nAccess granted :  " + "\n" + personnel;
                    passwordBox1.Password = "";
                }
                else if (enteredCode >= 0 && enteredCode <= 10)
                {
                    logBox.Text = currently + "\nRestricted Access :  " + "\nSecurity has been notified . . .";
                    passwordBox1.Password = "";
                }
                else
                {
                    logBox.Text = currently + "\nAccess Denied";
                    passwordBox1.Password = "";
 
                }
        }

        private void passwordBox1_PasswordChanged(object sender, RoutedEventArgs e)
        {

        }

        private void button1_Click_1(object sender, RoutedEventArgs e)
        {
           passwordBox1.Password += "1";
        }

        private void button2_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "2";
        }

        private void button3_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "3";
        }

        private void button4_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "4";
        }

        private void button5_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "5";
        }

        private void button6_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "6";
        }

        private void button7_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "7";
        }

        private void button8_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "8";
        }

        private void button9_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "9";
        }

        private void buttonClear_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password = "";
            logBox.Text = "";
        }

        private void buttonZero_Click(object sender, RoutedEventArgs e)
        {
            passwordBox1.Password += "0";
        }

        private void buttonEnter_Click(object sender, RoutedEventArgs e)
        {
            getPassword();
        }

        private void logBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

        }
    }
}
