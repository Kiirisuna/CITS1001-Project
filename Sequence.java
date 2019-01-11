/**
 * Sequence models number sequences.
 * 
 * @Terence Leong
 * @version 0.0
 */
import java.util.ArrayList;

public class Sequence
{

    private double[] sequence; // the numbers in the sequence

    // sets up sequence by parsing s 
    public Sequence(String s)
    {
        String [] presplit; //user input string
        presplit = s.split (","); //split string into individual strings
        sequence = new double[presplit.length]; 
        
        for (int x=0; x<presplit.length;x++)
        {
            double prearray = Double.parseDouble (presplit[x]); //convert string to double
            sequence [x] = prearray ; //places double into double[]
        }

        //TODO [WORKS]
    }  

    // returns sequence 
    public double[] getSequence()
    {
        return sequence;
    }

    // returns the product of 1..x 
    public int factorial(int x)
    {
        if (x == 0 || x==1) 
        {
            return 1; //factorial of 0 and 1 is 1
        }
        else
        {
            return x * factorial(x-1); //factorial
        }
        //TODO [WORKS]
    }

    // returns true iff all of the items on sequence are equal 
    public boolean allEqual()
    {

        for (int x=1; x<sequence.length; x++)
        {
            if (sequence[0] != sequence[x]) //if all value in sequence does not equal
            {
                return false;
            }
        } 

        return true;
        //TODO [WORKS]
    }

    // returns a new array holding the differences between adjacent items on sequence 
    public double[] differences()
    {
        double [] temp = new double [sequence.length-1];

        for (int y=0; y<sequence.length-1; ++y)
        {  
            temp[y]=sequence[y+1]-sequence[y]; //subtracting the arrays obtaining difference
        }     

        return temp;
        //TODO [WORKS]
    }

    // subtracts from each item in sequence the effect of the term t 
    // implements Step 4 of the algorithm description on the project web page 
    public void updateSequence(Term t)
    {    
        double index = 0; //x- value in equation
        double coeff = t.getCoefficient();
        double expo = t.getExponent();

        for (int i = 0; i <sequence.length; i++) 
        {
            index++;
            sequence[i] = sequence[i]-(coeff*Math.pow(index,expo)); //provides new sequence
        }  

        // TODO [WORKS]
    }

    // returns the next term in the simplest polynomial that generates sequence 
    // implements Steps 1-3 of the algorithm description on the project web page 
    public Term nextTerm()
    {
        int e = 0;
        double [] tempSequence = new double [sequence.length];
        tempSequence = sequence;

        while (allEqual() !=true) 
        {
            e++; //exponent count incremental increase with each loop
            double [] tempdiff = differences(); //implement difference() method
            sequence = new double [tempdiff.length];
            sequence = tempdiff;
        }

        double c = (sequence[0]/factorial(e)); //coefficient calculation
        sequence = new double [tempSequence.length];
        sequence = tempSequence; //saves new sequence

        return new Term(c,e); // return new Term

        // TODO [WORKS]
    } 

    // returns the simplest polynomial that generates sequence and displays the polynomial as a String 
    // implements the algorithm description on the project web page 
    public Polynomial solveSequence()
    {
        Polynomial Poly = new Polynomial();
        while (!(allEqual()&&sequence[0]==0))
        {
            Poly.addTerm(nextTerm());
            updateSequence(nextTerm());
        }
        System.out.println(Poly.display());
        return Poly;
    }
    //TODO [WORKS]
}