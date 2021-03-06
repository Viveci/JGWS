package search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest
{

   @Before
   public void setUp() throws Exception{;
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testLoop(){
      int[] a = new int[]{0,0,1,2,3,4,5,6,7};
      assertEquals(0,Dictionary.binarySearch(0, a,0,a.length-1));
   }
   
   @Test
   public void testSearch1(){
      int[] a = new int[]{10,11,16,19,20,21,22};
      assertEquals(2,Dictionary.binarySearchIterative(16, a));
   }

}
