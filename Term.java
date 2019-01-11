/**
 * Term models terms in a polynomial. 
 * 
 * @author your name here
 * @version 0.0
 */
public class Term
{
    // the term = coefficient * x ^ exponent
    private double coefficient;
    private int    exponent;

    public Term(double c, int e)
    {
        coefficient = c;
        exponent = e;
    }

    // returns the coefficient
    public double getCoefficient()
    {
        return coefficient;
    }

    // returns the exponent
    public int getExponent()
    {
        return exponent;
    }

    // returns the term as a String for display 
    // see the sample file for the layout required 
    public String display()
    {String sign = "+"; 
        String termDisplay = ""; //creates a new string for the final answer
        double localCoeff = coefficient; //creates a copy of the coefficient locally
        if (coefficient == 0) //if coefficient is 0, no output is given
        { 
            sign = "";
        }
        else if (coefficient < 0) //With the default value being positive, only the negative cases have to be tested
        {
            sign = "-";
        }
        localCoeff = Math.abs(coefficient);

        String strCoeff = "" + localCoeff; 
        if (strCoeff.contains(".0")) //removes .0 from all the string type coefficients
        {
            strCoeff = strCoeff.replace(".0","");
        }

        if (coefficient == 0) //if coefficient is 0, there is no output
        {
            termDisplay = "";
        }
        else if (exponent == 0) //if exponent is 0, output would be 1
        {
            termDisplay = sign + strCoeff;
        }
        else if (exponent == 1 && localCoeff == 1) //making it so that no 1 will appear in any statements
        {
            termDisplay = sign + "x";
        }
        else if (exponent == 1) //if there is a non-zero, non- one coefficient and exponent it simplifies each test
        {
            termDisplay = (sign + strCoeff) + "x";
        }
        else if (localCoeff == 1) //this is also coduncted for the coefficient
        {
            termDisplay = (sign + "x^") + exponent;
        }
        else //after exhausting all "special cases"
        {
            termDisplay = (sign + strCoeff) + ("x^" + exponent);
        }
        return termDisplay;
    }

}