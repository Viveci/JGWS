package task1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolverTest
{

   @Before
   public void setUp() throws Exception{
      
   }

   @After
   public void tearDown() throws Exception{
   }

   @Test
   public void testFactorial(){
      assertEquals(1,Solver.factorial(0));
      assertEquals(1,Solver.factorial(1));
      assertEquals(2,Solver.factorial(2));
      assertEquals(6,Solver.factorial(3));
      assertEquals(24,Solver.factorial(4));
   }
   
   @Test
   public void testBinomial(){
      assertEquals(6,Solver.binomial(4, 2));
      assertEquals(1,Solver.binomial(4, 4));
      assertEquals(1,Solver.binomial(4, 0));
   }
   
   @Test
   public void testBinomialRecursive(){
      assertEquals(6,Solver.binomialRecursive(4, 2));
      assertEquals(1,Solver.binomialRecursive(4, 4));
      assertEquals(1,Solver.binomialRecursive(4, 0));
   }

}
