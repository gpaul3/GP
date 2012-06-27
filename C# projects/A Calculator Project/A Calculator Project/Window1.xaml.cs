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

namespace A_Calculator_Project
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        public Window1()
        {
            InitializeComponent();
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
        }
        private void buttonOn_Click(object sender, RoutedEventArgs e)
        {
            calcWindow.Text = "0";
            answer = 0;
            operand1 = null;
            operand2 = null;
        }
        private void buttonOff_Click(object sender, RoutedEventArgs e)
        {
            calcWindow.Text = " ";
        }
        private void buttonClear_Click(object sender, RoutedEventArgs e)
        {
            calcWindow.Text = "0";
            answer = 0;
            operand1 = null;
            operand2 = null;
        }
        private void button1_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 1;       
            }
            else
            {
                operand2 = 1;
            }
            calcWindow.Text = "1";
        }
        private void button2_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 2;
            }
            else
            {
                operand2 = 2;
            }
            calcWindow.Text = "2";
        }
        private void button3_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 3;
            }
            else
            {
                operand2 = 3;
            }
            calcWindow.Text = "3";
        }
        private void button4_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 4;
            }
            else
            {
                operand2 = 4;
            }
            calcWindow.Text = "4";
        }
        private void button5_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 5;
            }
            else
            {
                operand2 = 5;
            }
            calcWindow.Text = "5";
        }
        private void button6_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 6;
            }
            else
            {
                operand2 = 6;
            }
            calcWindow.Text = "6";
        }
        private void button7_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 7;
            }
            else
            {
                operand2 = 7;
            }
            calcWindow.Text = "7";
        }
        private void button8_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 8;
            }
            else
            {
                operand2 = 8;
            }
            calcWindow.Text = "8";
        }
        private void button9_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 9;
            }
            else
            {
                operand2 = 9;
            }
            calcWindow.Text = "9";
        }
        private void buttonZero_Click(object sender, RoutedEventArgs e)
        {
            if (!operand1.HasValue)
            {
                operand1 = 0;
            }
            else
            {
                operand2 = 0;
            }
            calcWindow.Text = "0";
        }
        private void buttonSubtract_Click(object sender, RoutedEventArgs e)
        {
            opSign = '-';
        }
        private void buttonMultipy_Click(object sender, RoutedEventArgs e)
        {
            opSign = '*';
        }
        private void buttonAdd_Click(object sender, RoutedEventArgs e)
        {
            opSign = '+';
        }
        private void buttonDivide_Click_1(object sender, RoutedEventArgs e)
        {
            opSign = '/';
        }
        private void buttonEquals_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                this.answer =  c.Calculate(operand1, operand2, opSign);
                calcWindow.Text = this.answer.ToString();
                operand1 = null;
                operand2 = null;
             }
            catch (DivideByZeroException zE)
            {
                calcWindow.Text = zE.Message;
            }
            catch (Exception caught)
            {
                calcWindow.Text = caught.Message;
            }     
        }
        private void button10_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
        private double? answer = null;
        private double? operand1 = null;
        private double? operand2 = null;
        private char opSign;
        Calculator c = new Calculator();

    }
}
