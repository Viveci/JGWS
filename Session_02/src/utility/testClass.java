package utility;

import javax.crypto.MacSpi;

public class testClass{
   
   private static Text myText;
   
   public static void main(String[] args){
      System.out.println("Test class");
      
      //decl
      myText = new Text("MyTesttsetym");
      
      System.out.println(myText.toString());
      System.out.println(myText.isPalindrome());
      System.out.println(myText.isPalindromePeasant());
      
      myText = new Text("This is not a plaindrome");
      
      System.out.println(myText.toString());
      System.out.println(myText.isPalindrome());
      System.out.println(myText.isPalindromePeasant());
      System.out.println(myText.reverseString());
      
      myText = new Text("bob");
      
      System.out.println(myText.toString());
      System.out.println(myText.isPalindrome());
      System.out.println(myText.isPalindromePeasant());
      
   }
}
