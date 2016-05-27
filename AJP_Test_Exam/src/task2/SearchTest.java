package task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest
{

   @Before
   public void setUp() throws Exception{
   }

   @After
   public void tearDown() throws Exception{
   }

   @Test
   public void linearSearchTest(){
      int[] t = {2,4,5,7,9,12};
      assertEquals(-1,Search.specialLinearSearch(t, 6));
      assertEquals(3,Search.specialLinearSearch(t, 7));
      assertEquals(4,Search.specialLinearSearch(t, 9));
      assertEquals(-1,Search.specialLinearSearch(t, 8));
      assertEquals(5,Search.specialLinearSearch(t, 12));
      assertEquals(-1,Search.specialLinearSearch(t, 0));
   }
   
   @Test
   public void JumpSearch(){
      int[] z = {0,1,1,2,3,5,8,13,21,34,55,89,144,150,151,152,153,155,160};
      
      //existing elements
      assertEquals(3,Search.jumpSearch(z,2));
      assertEquals(0,Search.jumpSearch(z,0));
      assertEquals(10,Search.jumpSearch(z,55));
      assertEquals(9,Search.jumpSearch(z,34));
      assertEquals(18,Search.jumpSearch(z,160));
      
      //non-existent elements
      assertEquals(-1,Search.jumpSearch(z,4));
      assertEquals(-1,Search.jumpSearch(z,7));
      
   }

}
