import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TermTest provides 
 * unit test cases for the Term class.
 * @author Lyndon While
 * @version 1.0
 */
public class TermTest
{
    private Term term23, termm11;
    private double epsilon = 10e-6;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        term23  = new Term(2, 3);
        termm11 = new Term(-1, 1);
    }

    @Test
    public void testTerms() 
    {
        assertEquals("new Term( 2, 3) should set coefficient to 2.0",   2, term23.getCoefficient(), epsilon);
        assertEquals("new Term( 2, 3) should set exponent to 3",        3, term23.getExponent());
        assertEquals("new Term(-1, 1) should set coefficient to -1.0", -1, termm11.getCoefficient(), epsilon);
        assertEquals("new Term(-1, 1) should set exponent to 1",        1, termm11.getExponent());
    }

    @Test
    public void testdisplay() 
    {
        String s;
        s = term23.display().replaceAll(" ", "");
        assertEquals("term23 should appear as '+ 2x^3'", "+2x^3", s);
        assertEquals("term23 coefficient should be unchanged by display", 2, term23.getCoefficient(), epsilon); 
        assertEquals("term23 exponent should be unchanged by display",    3, term23.getExponent()); 
        s = termm11.display().replaceAll(" ", "");
        assertEquals("termm11 should appear as '- x'", "-x", s);
        assertEquals("termm11 coefficient should be unchanged by display", -1, termm11.getCoefficient(), epsilon); 
        assertEquals("termm11 exponent should be unchanged by display",     1, termm11.getExponent()); 
    } 

}