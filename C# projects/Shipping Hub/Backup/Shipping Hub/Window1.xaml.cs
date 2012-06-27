using System;
using System.Collections.Generic;
using System.Collections;
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

namespace Shipping_Hub
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        private string [] states = { "Alabama", "Florida", "Georgia", "Kentucky", 
                                   "Mississippi","North Carolina", "South Carolina", 
                                   "Tennessee", "West Virginia", "Virginia" };
        int packageID = 987654321;

        ArrayList packID = new ArrayList();
        ArrayList packAD = new ArrayList();
        ArrayList packCI = new ArrayList();
        ArrayList packST = new ArrayList();
        ArrayList packZC = new ArrayList();

        public Window1()
        {
            InitializeComponent();
            this.Reset();
            this.SetFalse();
        }
        public void SetFalse()
        {
            
            packIDLabel.IsEnabled = false;
            addressLabel.IsEnabled = false;
            addressBox.IsEnabled = false;
            cityLabel.IsEnabled = false;
            cityBox.IsEnabled = false;
            stateLabel.IsEnabled = false;
            stateNames2.IsEnabled = false;
            zipLabel.IsEnabled = false;
            zipBox.IsEnabled = false;
            backButton.IsEnabled = false;
            addButton.IsEnabled = false;
            removeButton.IsEnabled = false;
            editButton.IsEnabled = false;
            nextButton.IsEnabled = false;
        }
        public void SetTrue()
        {
            
            packIDLabel.IsEnabled = true;
            addressLabel.IsEnabled = true;
            addressBox.IsEnabled = true;
            cityLabel.IsEnabled = true;
            cityBox.IsEnabled = true;
            stateLabel.IsEnabled = true;
            stateNames2.IsEnabled = true;
            zipLabel.IsEnabled = true;
            zipBox.IsEnabled = true;
            backButton.IsEnabled = true;
            addButton.IsEnabled = true;
            removeButton.IsEnabled = true;
            editButton.IsEnabled = true;
            nextButton.IsEnabled = true;
        }

        public void Reset()
        {
            foreach (string state in states)
            {
                stateNames1.Items.Add(state);
                stateNames2.Items.Add(state);
            }
            stateNames1.Text = String.Empty;
            stateNames2.Text = String.Empty;
        }

        private void scanNewButton_Click(object sender, RoutedEventArgs e)
        {
            idBox.Text = packageID.ToString();
            arrivedAt.Text = (DateTime.Now).ToString();
            arrivedAt.IsEnabled = false;
            SetTrue();
            addressBox.Clear();
            cityBox.Clear();
            stateNames1.Text = String.Empty;
            stateNames2.Text = String.Empty;
            zipBox.Clear();
            packageID += 111;
            nextButton.IsEnabled = false;
            backButton.IsEnabled = false;
            idBox.IsEnabled = false;
            editButton.IsEnabled = false;
            scanNewButton.IsEnabled = false;
         }

        private void addButton_Click(object sender, RoutedEventArgs e)
        {
            string aR = arrivedAt.Text;
            object iD = idBox.Text;
            packID.Add(iD);
            object aD = addressBox.Text;
            packAD.Add(aD);
            object cI = cityBox.Text;
            packCI.Add(cI);
            object sN = stateNames2.Text;
            packST.Add(sN);
            object zI = zipBox.Text;
            packZC.Add(zI);
            addButton.IsEnabled = false;
            scanNewButton.IsEnabled = true;
            editButton.IsEnabled = true;
           
            
            object value = (object)idBox.Text;
            int j = packID.IndexOf(value);
            if (j == 0)
            {
                backButton.IsEnabled = false;
                nextButton.IsEnabled = false;
            }
            else
            {
                backButton.IsEnabled = true;
                nextButton.IsEnabled = false;
            }
         
            if (addressBox.Text.Length == 0)
            {
                MessageBox.Show("Please enter a valid address.", "Missing Information", MessageBoxButton.OK, MessageBoxImage.Error);
                addButton.IsEnabled = true;
            }
            else if (cityBox.Text.Length == 0)
            {
                MessageBox.Show("Please enter a valid city.", "Missing Information", MessageBoxButton.OK, MessageBoxImage.Error);
                addButton.IsEnabled = true;
            }
            else if (stateNames2.Text.Length == 0)
            {
                MessageBox.Show("Please enter a valid state.", "Missing Information", MessageBoxButton.OK, MessageBoxImage.Error);
                addButton.IsEnabled = true;
            }
            else if (zipBox.Text.Length == 0)
            {
                MessageBox.Show("Please enter a valid zip code.", "Missing Information", MessageBoxButton.OK, MessageBoxImage.Error);
                addButton.IsEnabled = true;
            }
            else
            {
                MessageBox.Show("Package ID# : " + iD + "\nArrived at " + arrivedAt.Text + "\nShipping to : " + '\n' +
                aD + '\n' + cI + " , " + sN + " , " + zI
                + "\nThis package has been added to the database.", "Package Information Added", MessageBoxButton.OK, MessageBoxImage.Information);
                addressLabel.IsEnabled = false;
                addressBox.IsEnabled = false;
                cityLabel.IsEnabled = false;
                cityBox.IsEnabled = false;
                stateLabel.IsEnabled = false;
                stateNames2.IsEnabled = false;
                stateNames1.IsEnabled = true;
                zipLabel.IsEnabled = false;
                zipBox.IsEnabled = false;
            }
          }

        private void removeButton_Click(object sender, RoutedEventArgs e)
        {
            object iD = idBox.Text;
            packID.Remove(iD);
            object aD = addressBox.Text;
            packAD.Remove(aD);
            object cI = cityBox.Text;
            packCI.Remove(cI);
            object sN = stateNames2.Text;
            packST.Remove(sN);
            object zI = zipBox.Text;
            packZC.Remove(zI);
                                   
            MessageBox.Show("Package ID# : " + iD + "\nShipping to : " + '\n' +
                aD + '\n' + cI + ", " + sN + ", " + zI
                + "\nThis package has been removed from the database.", "Package Information Removed", 
               MessageBoxButton.OK, MessageBoxImage.Exclamation);
            if ((idBox.Text.Length) == 0 || (packID.Count) == 0)
            {
                idBox.IsEnabled = false;
                addressLabel.IsEnabled = false;
                addressBox.IsEnabled = false;
                addressBox.Clear();
                cityLabel.IsEnabled = false;
                cityBox.IsEnabled = false;
                cityBox.Clear();
                stateLabel.IsEnabled = false;
                stateNames1.IsEnabled = false;
                stateNames1.Text = String.Empty;
                stateNames2.IsEnabled = false;
                stateNames2.Text = String.Empty;
                zipLabel.IsEnabled = false;
                zipBox.IsEnabled = false;
                zipBox.Clear();
                packIDLabel.IsEnabled = false;
                addButton.IsEnabled = false;
                removeButton.IsEnabled = false;
                editButton.IsEnabled = false;
                backButton.IsEnabled = false;
                nextButton.IsEnabled = false;
            }

            else
            {
                int k = packID.Count - 1;
                idBox.Text = (packID[k]).ToString();
                addressBox.Text = (packAD[k]).ToString();
                cityBox.Text = (packCI[k]).ToString();
                stateNames2.Text = (packST[k]).ToString();
                zipBox.Text = (packZC[k]).ToString();

                idBox.IsEnabled = false;
                addressLabel.IsEnabled = false;
                addressBox.IsEnabled = false;
                cityLabel.IsEnabled = false;
                cityBox.IsEnabled = false;
                stateLabel.IsEnabled = false;
                stateNames2.IsEnabled = false;
                zipLabel.IsEnabled = false;
                zipBox.IsEnabled = false;
                packIDLabel.IsEnabled = false;
                addButton.IsEnabled = false;
            }
        }
        private void nextButton_Click(object sender, RoutedEventArgs e)
        {
            PackInfo.IsEnabled = false;
            packIDLabel.IsEnabled = false;
            idBox.IsEnabled = false;
            addressLabel.IsEnabled = false;
            addressBox.IsEnabled = false;
            cityLabel.IsEnabled = false;
            cityBox.IsEnabled = false;
            stateLabel.IsEnabled = false;
            stateNames2.IsEnabled = false;
            zipLabel.IsEnabled = false;
            zipBox.IsEnabled = false;
            addButton.IsEnabled = false;
            removeButton.IsEnabled = true;
            editButton.IsEnabled = true;

            object value = (object)idBox.Text;
            int j = packID.IndexOf(value);
            int k;
            if (j == packID.Count || j == packID.Count-1)
            {
                k = j;
                backButton.IsEnabled = true;
                nextButton.IsEnabled = false;
            }
          
            else
            {
                k = j + 1;
                backButton.IsEnabled = true;
                nextButton.IsEnabled = true;
            }
                idBox.Text = (packID[k]).ToString();
                addressBox.Text = (packAD[k]).ToString();
                cityBox.Text = (packCI[k]).ToString();
                stateNames2.Text = (packST[k]).ToString();
                zipBox.Text = (packZC[k]).ToString();
          
        }

        private void backButton_Click(object sender, RoutedEventArgs e)
        {
            PackInfo.IsEnabled = false;
            packIDLabel.IsEnabled = false;
            idBox.IsEnabled = false;
            addressLabel.IsEnabled = false;
            addressBox.IsEnabled = false;
            cityLabel.IsEnabled = false;
            cityBox.IsEnabled = false;
            stateLabel.IsEnabled = false;
            stateNames2.IsEnabled = false;
            zipLabel.IsEnabled = false;
            zipBox.IsEnabled = false;
            addButton.IsEnabled = false;
            removeButton.IsEnabled = true;
            editButton.IsEnabled = true;

            object value = (object)idBox.Text;
            int j = packID.IndexOf(value);
            int k;
            if (j == 0)
            {
                k = j;
                backButton.IsEnabled = false;
                nextButton.IsEnabled = true;
                
            }
            else
            {
                k = j - 1;
                backButton.IsEnabled = true;
                nextButton.IsEnabled = true;
            }
                idBox.Text = (packID[k]).ToString();
                addressBox.Text = (packAD[k]).ToString();
                cityBox.Text = (packCI[k]).ToString();
                stateNames2.Text = (packST[k]).ToString();
                zipBox.Text = (packZC[k]).ToString();

        }

        private void stateNames1_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            idListBox.Items.Clear(); 
            string selectedState = (string)stateNames1.SelectedItem;
                for (int z = 0; z < packST.Count; z++)
                {
                    if ((string)packST[z] == selectedState)
                    {
                        idListBox.Items.Add(packID[z] as string);
                    }
                }
        }

        private void editButton_Click(object sender, RoutedEventArgs e)
        {
             PackInfo.IsEnabled = true;
             packIDLabel.IsEnabled = true;
             idBox.IsEnabled = true;
             addressLabel.IsEnabled = true;
             addressBox.IsEnabled = true;
             cityLabel.IsEnabled = true;
             cityBox.IsEnabled = true;
             stateLabel.IsEnabled = true;
             stateNames2.IsEnabled = true;
             zipLabel.IsEnabled = true;
             zipBox.IsEnabled = true;
             backButton.IsEnabled = true;
             addButton.IsEnabled = true;
             removeButton.IsEnabled = true;
             editButton.IsEnabled = true;
             nextButton.IsEnabled = true;
             addressBox.Focus();
             backButton.IsEnabled = true;
             nextButton.IsEnabled = true;
             scanNewButton.IsEnabled = false ;

        }            


    }
}
