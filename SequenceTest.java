import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SequenceTest provides 
 * unit test cases for the Sequence class.
 * @author Lyndon While
 * @version 1.0
 */
public class SequenceTest
{
    private Sequence seq15, seq444, seqm;
    private double epsilon = 10e-6;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        seq15  = new Sequence("1, 5");
        seq444 = new Sequence("4, 4, 4");
        seqm   = new Sequence("0, -1.5, -4");
    }

    @Test
    public void testSequences() 
    {
       double[] s15 = {1, 5};
       assertTrue("seq15 gives {1, 5}",     java.util.Arrays.equals(seq15.getSequence(),  s15));
       double[] s444 = {4, 4, 4};
       assertTrue("seq444 gives {4, 4, 4}", java.util.Arrays.equals(seq444.getSequence(), s444));
       double[] sm   = {0, -1.5, -4};
       assertTrue("seq444 gives {0, -1.5, -4}", java.util.Arrays.equals(seqm.getSequence(), sm));
    }

    @Test
    public void testfactorial() 
    {
       assertEquals("fac(3) = 6",         6, seq15.factorial(3));
       assertEquals("fac(8) = 40320", 40320, seq15.factorial(8));
       double[] s15 = {1, 5};
       assertTrue("seq15 unchanged by factorial", java.util.Arrays.equals(seq15.getSequence(), s15));
    }

    @Test
    public void testallEqual() 
    {
       assertEquals("seq15 IS NOT all equal", false, seq15.allEqual());
       assertEquals("seq444 IS all equal",    true,  seq444.allEqual());
       assertEquals("seqm IS NOT all equal",  false, seqm.allEqual());
       double[] s15 = {1, 5};
       assertTrue("seq15 unchanged by allEqual",  java.util.Arrays.equals(seq15.getSequence(),  s15));
       double[] s444 = {4, 4, 4};
       assertTrue("seq444 unchanged by allEqual", java.util.Arrays.equals(seq444.getSequence(), s444));
       double[] sm = {0, -1.5, -4};
       assertTrue("seqm unchanged by allEqual",   java.util.Arrays.equals(seqm.getSequence(), sm));
    }

    @Test
    public void testdifferences() 
    {
       double[] s15 = {1, 5};
       double[] f   = {4};
       assertTrue("seq15 differences gives {4}",    java.util.Arrays.equals(seq15.differences(), f));
       assertTrue("seq15 unchanged by differences", java.util.Arrays.equals(seq15.getSequence(), s15));
       double[] s444 = {4, 4, 4};
       double[] zz = {0, 0};
       assertTrue("seq444 differences gives {0, 0}", java.util.Arrays.equals(seq444.differences(), zz));
       assertTrue("seq444 unchanged by differences", java.util.Arrays.equals(seq444.getSequence(), s444));
       double[] sm = {0, -1.5, -4};
       double[] ms = {-1.5, -2.5};
       assertTrue("seqm differences gives {-1.5, -2.5}", java.util.Arrays.equals(seqm.differences(), ms));
       assertTrue("seqm unchanged by differences", java.util.Arrays.equals(seqm.getSequence(), sm));
    }

    @Test
    public void testupdateSequence() 
    {
       double[] m3 = {-3, -3};
       seq15.updateSequence(new Term(4, 1));
       assertTrue("seq15 after 4x is {-3, -3}",  java.util.Arrays.equals(seq15.getSequence(), m3));
       double[] mh = {0.5, 0.5, 0.5};
       seqm.updateSequence(new Term(-0.5, 2));
       assertTrue("seqm after -0.5x^2 is {0.5, 0.5, 0.5}", java.util.Arrays.equals(seqm.getSequence(), mh));
    }

    @Test
    public void testnextTerm() 
    {
       double[] s15 = {1, 5};
       Term soln15 = seq15.nextTerm();
       assertEquals("seq15 nextTerm coeff is 4", 4, soln15.getCoefficient(), epsilon);
       assertEquals("seq15 nextTerm exp is 1",   1, soln15.getExponent());
       assertTrue("seq15 unchanged by nextTerm", java.util.Arrays.equals(seq15.getSequence(), s15));
       double[] sm = {0, -1.5, -4};
       Term solnm = seqm.nextTerm();
       assertEquals("seqm nextTerm coeff is -0.5", -0.5, solnm.getCoefficient(), epsilon);
       assertEquals("seqm nextTerm exp is 2",       2,   solnm.getExponent());
       assertTrue("seqm unchanged by nextTerm",     java.util.Arrays.equals(seqm.getSequence(), sm));
    }

    @Test
    public void testsolveSequence() 
    {
       assertEquals("seq15 gives 4x - 3",       "4x-3",        seq15.solveSequence().display().replaceAll(" ", ""));
       assertEquals("seq44 gives 4",            "4",          seq444.solveSequence().display().replaceAll(" ", ""));
       assertEquals("seqm gives -0.5x^2 + 0.5", "-0.5x^2+0.5",  seqm.solveSequence().display().replaceAll(" ", ""));
        
    }

}