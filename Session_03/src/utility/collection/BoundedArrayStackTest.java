package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoundedArrayStackTest
{
   
   BoundedArrayStack<String> stack;

   @Before
   public void setUp() throws Exception{
      stack = new BoundedArrayStack<String>(10);
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testPush(){
      stack.push("First");
      assertEquals(1, stack.size());
   }

}
