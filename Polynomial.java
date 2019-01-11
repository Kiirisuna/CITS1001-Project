/**
 * Polynomial models polynomials.
 * 
 * @author your name here
 * @version 0.0
 */
import java.util.ArrayList;

public class Polynomial
{
    // the terms making up the polynomial
    private ArrayList<Term> polynomial;

    // creates a zero polynomial
    public Polynomial()
    {
        polynomial = new ArrayList<>();
    }
    
    // returns the number of terms in polynomial
    public int numberOfTerms()
    {
        return polynomial.size();
    }
    
    // adds a new term to the end of polynomial
    public void addTerm(Term t)
    {
        polynomial.add(t);
    }

    // returns the indicated term of polynomial
    public Term getTerm(int k)
    {
        if (0 <= k && k < numberOfTerms()) 
             return polynomial.get(k);
        else return null;
    }
    
    // returns polynomial as a String for display 
    // see the sample file for the layout required 
    public String display()
        {
        String stringDisplay = "";//creates a new string
        
        for (int i = 0; i<numberOfTerms();i++) //a loop printing each polynomial until it produces the final statement
        {
            stringDisplay = stringDisplay + getTerm(i).display();
        }
        
        if(stringDisplay.charAt(0) == '+')//If the first character is '0', it will be ignored and everything after will be returned
        {   
            stringDisplay = stringDisplay.substring(1);
        }
        
        return stringDisplay;
        //TODO [WORKS]
    }
      
    
}