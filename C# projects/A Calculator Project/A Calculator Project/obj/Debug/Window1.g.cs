﻿#pragma checksum "..\..\Window1.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "9E42BC0DD79E75FA22F6FCCF995F61EE"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.269
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;


namespace A_Calculator_Project {
    
    
    /// <summary>
    /// Window1
    /// </summary>
    public partial class Window1 : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 5 "..\..\Window1.xaml"
        internal System.Windows.Controls.Grid Calculator;
        
        #line default
        #line hidden
        
        
        #line 6 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button1;
        
        #line default
        #line hidden
        
        
        #line 7 "..\..\Window1.xaml"
        internal System.Windows.Controls.TextBox calcWindow;
        
        #line default
        #line hidden
        
        
        #line 8 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonSubtract;
        
        #line default
        #line hidden
        
        
        #line 9 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button3;
        
        #line default
        #line hidden
        
        
        #line 10 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button2;
        
        #line default
        #line hidden
        
        
        #line 11 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonZero;
        
        #line default
        #line hidden
        
        
        #line 12 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button4;
        
        #line default
        #line hidden
        
        
        #line 13 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonMultipy;
        
        #line default
        #line hidden
        
        
        #line 14 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button6;
        
        #line default
        #line hidden
        
        
        #line 15 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button5;
        
        #line default
        #line hidden
        
        
        #line 16 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonOff;
        
        #line default
        #line hidden
        
        
        #line 17 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonAdd;
        
        #line default
        #line hidden
        
        
        #line 18 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonClear;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonEquals;
        
        #line default
        #line hidden
        
        
        #line 20 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonOn;
        
        #line default
        #line hidden
        
        
        #line 21 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button7;
        
        #line default
        #line hidden
        
        
        #line 22 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button9;
        
        #line default
        #line hidden
        
        
        #line 23 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button8;
        
        #line default
        #line hidden
        
        
        #line 24 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button buttonDivide;
        
        #line default
        #line hidden
        
        
        #line 25 "..\..\Window1.xaml"
        internal System.Windows.Controls.Button button10;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/A Calculator Project;component/window1.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Window1.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            
            #line 4 "..\..\Window1.xaml"
            ((A_Calculator_Project.Window1)(target)).Loaded += new System.Windows.RoutedEventHandler(this.Window_Loaded);
            
            #line default
            #line hidden
            return;
            case 2:
            this.Calculator = ((System.Windows.Controls.Grid)(target));
            return;
            case 3:
            this.button1 = ((System.Windows.Controls.Button)(target));
            
            #line 6 "..\..\Window1.xaml"
            this.button1.Click += new System.Windows.RoutedEventHandler(this.button1_Click);
            
            #line default
            #line hidden
            return;
            case 4:
            this.calcWindow = ((System.Windows.Controls.TextBox)(target));
            return;
            case 5:
            this.buttonSubtract = ((System.Windows.Controls.Button)(target));
            
            #line 8 "..\..\Window1.xaml"
            this.buttonSubtract.Click += new System.Windows.RoutedEventHandler(this.buttonSubtract_Click);
            
            #line default
            #line hidden
            return;
            case 6:
            this.button3 = ((System.Windows.Controls.Button)(target));
            
            #line 9 "..\..\Window1.xaml"
            this.button3.Click += new System.Windows.RoutedEventHandler(this.button3_Click);
            
            #line default
            #line hidden
            return;
            case 7:
            this.button2 = ((System.Windows.Controls.Button)(target));
            
            #line 10 "..\..\Window1.xaml"
            this.button2.Click += new System.Windows.RoutedEventHandler(this.button2_Click);
            
            #line default
            #line hidden
            return;
            case 8:
            this.buttonZero = ((System.Windows.Controls.Button)(target));
            
            #line 11 "..\..\Window1.xaml"
            this.buttonZero.Click += new System.Windows.RoutedEventHandler(this.buttonZero_Click);
            
            #line default
            #line hidden
            return;
            case 9:
            this.button4 = ((System.Windows.Controls.Button)(target));
            
            #line 12 "..\..\Window1.xaml"
            this.button4.Click += new System.Windows.RoutedEventHandler(this.button4_Click);
            
            #line default
            #line hidden
            return;
            case 10:
            this.buttonMultipy = ((System.Windows.Controls.Button)(target));
            
            #line 13 "..\..\Window1.xaml"
            this.buttonMultipy.Click += new System.Windows.RoutedEventHandler(this.buttonMultipy_Click);
            
            #line default
            #line hidden
            return;
            case 11:
            this.button6 = ((System.Windows.Controls.Button)(target));
            
            #line 14 "..\..\Window1.xaml"
            this.button6.Click += new System.Windows.RoutedEventHandler(this.button6_Click);
            
            #line default
            #line hidden
            return;
            case 12:
            this.button5 = ((System.Windows.Controls.Button)(target));
            
            #line 15 "..\..\Window1.xaml"
            this.button5.Click += new System.Windows.RoutedEventHandler(this.button5_Click);
            
            #line default
            #line hidden
            return;
            case 13:
            this.buttonOff = ((System.Windows.Controls.Button)(target));
            
            #line 16 "..\..\Window1.xaml"
            this.buttonOff.Click += new System.Windows.RoutedEventHandler(this.buttonOff_Click);
            
            #line default
            #line hidden
            return;
            case 14:
            this.buttonAdd = ((System.Windows.Controls.Button)(target));
            
            #line 17 "..\..\Window1.xaml"
            this.buttonAdd.Click += new System.Windows.RoutedEventHandler(this.buttonAdd_Click);
            
            #line default
            #line hidden
            return;
            case 15:
            this.buttonClear = ((System.Windows.Controls.Button)(target));
            
            #line 18 "..\..\Window1.xaml"
            this.buttonClear.Click += new System.Windows.RoutedEventHandler(this.buttonClear_Click);
            
            #line default
            #line hidden
            return;
            case 16:
            this.buttonEquals = ((System.Windows.Controls.Button)(target));
            
            #line 19 "..\..\Window1.xaml"
            this.buttonEquals.Click += new System.Windows.RoutedEventHandler(this.buttonEquals_Click);
            
            #line default
            #line hidden
            return;
            case 17:
            this.buttonOn = ((System.Windows.Controls.Button)(target));
            
            #line 20 "..\..\Window1.xaml"
            this.buttonOn.Click += new System.Windows.RoutedEventHandler(this.buttonOn_Click);
            
            #line default
            #line hidden
            return;
            case 18:
            this.button7 = ((System.Windows.Controls.Button)(target));
            
            #line 21 "..\..\Window1.xaml"
            this.button7.Click += new System.Windows.RoutedEventHandler(this.button7_Click);
            
            #line default
            #line hidden
            return;
            case 19:
            this.button9 = ((System.Windows.Controls.Button)(target));
            
            #line 22 "..\..\Window1.xaml"
            this.button9.Click += new System.Windows.RoutedEventHandler(this.button9_Click);
            
            #line default
            #line hidden
            return;
            case 20:
            this.button8 = ((System.Windows.Controls.Button)(target));
            
            #line 23 "..\..\Window1.xaml"
            this.button8.Click += new System.Windows.RoutedEventHandler(this.button8_Click);
            
            #line default
            #line hidden
            return;
            case 21:
            this.buttonDivide = ((System.Windows.Controls.Button)(target));
            
            #line 24 "..\..\Window1.xaml"
            this.buttonDivide.Click += new System.Windows.RoutedEventHandler(this.buttonDivide_Click_1);
            
            #line default
            #line hidden
            return;
            case 22:
            this.button10 = ((System.Windows.Controls.Button)(target));
            
            #line 25 "..\..\Window1.xaml"
            this.button10.Click += new System.Windows.RoutedEventHandler(this.button10_Click);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

