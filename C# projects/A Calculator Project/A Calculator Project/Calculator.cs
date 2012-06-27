using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace A_Calculator_Project
{
    class Calculator
    {
        public double? Calculate(double? op1, double? op2, char opSi)
        {
            if (opSi == '+' && op1 != null && op2 != null)
            {
                answer = op1 + op2;
            }
            else if (opSi == '-' && op1 != null && op2 != null)
            {
                answer = op1 - op2;
            }
            else if (opSi == '*' && op1 != null && op2 != null)
            {
                answer = op1 * op2;
            }
            else if (opSi == '/' && op1 != null && op2 != null)
            {
                answer = op1 / op2;
            }           
            return answer;
        }
        double? answer;
    }
}
