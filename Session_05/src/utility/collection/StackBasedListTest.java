package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackBasedListTest
{

   StackListBased<String> list;
   
   @Before
   public void setUp() throws Exception{
      list = new StackListBased<>();
   }

   @After
   public void tearDown() throws Exception{
   }

   @Test
   public void testAdd(){
      list.push("ASD");
      list.push("DSA");
      list.push("SAD");
      assertEquals("SAD",list.pop());
      assertEquals("DSA",list.pop());
      assertEquals("ASD",list.pop());
   }
   
   @Test
   public void testIsEmpty(){
      assertEquals(list.isEmpty(),true);
      list.push("ASD");
      assertEquals(list.isEmpty(),false);
      assertEquals("ASD",list.pop());
      assertEquals(list.isEmpty(),true);
   }
   
   @Test
   public void testSize(){
      assertEquals(0,list.size());
      list.push("ASD");
      assertEquals(1,list.size());
      list.push("DSA");
      assertEquals(2,list.size());
      assertEquals(list.pop(),"DSA");
      assertEquals(1,list.size());
   }
   
   @Test
   public void testIndexOf(){
      list.push("ASD");
      list.push("DSA");
      list.push("SAD");
      assertEquals(list.indexOf("SAD"),0);
      assertEquals(list.indexOf("DSA"),1);
      assertEquals(list.indexOf("ASD"),2);
      assertEquals(list.pop(),"SAD");
      assertEquals(list.indexOf("DSA"),0);
      assertEquals(list.pop(),"DSA");
      assertEquals(list.indexOf("ASD"),0);
   }

}
