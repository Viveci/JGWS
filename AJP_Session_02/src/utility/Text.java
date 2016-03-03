package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Text
{
   private String text;

   public Text(String text)
   {
      this.text = text;
   }

   public String getText()
   {
      return text;
   }

   public String toString()
   {
      return text;
   }

   public boolean isPalindrome()
   {
      return isPalindrome(text, 0, text.length() - 1);
   }

   private boolean isPalindrome(String text, int left, int right)
   {
      if (left >= right)
      {
         return true;
      }
      return (Character.toLowerCase(text.charAt(left)) == Character.toLowerCase(text.charAt(right))
            && isPalindrome(text, left + 1, right - 1));
   }

   public boolean isPalindromePeasant()
   {
      boolean eq = true;
      int negative = text.length() - 1;
      for (int i = 0; i < this.text.length(); i++)
      {
         if (text.toLowerCase().charAt(i) != text.toLowerCase().charAt(negative))
         {
            eq = false;
         }
         negative--;
      }
      return eq;
   }

   public String reverseString()
   {
      return reverseString(text, 0, text.length() - 1);
   }

   private String reverseString(String text, int left, int right)
   {
      if (right == 0)
      {
         return text;
      }
      else
      {
         text = text.charAt(right - 1) + reverseString(text.substring(left, right - 1), left, right - 1);
         return text;
      }
   }

   public boolean isInDictionary(){
      String[] words = getFromFile("dictionary.txt");
      String word = "abate";
      return isIn(word, words, 0, words.length-1);
   }

   private boolean isIn(String word, String[] words, int start, int end){
      int middle = (start+end)/2;
      if(word.equals(words[middle])){
         return true;
      }
      if(word.compareTo(words[middle]) > 0) // After middle
      {
         System.out.println(word.compareTo(words[middle]));
         start = middle+1;
      }
      else{
         end = middle-1;
         System.out.println(word.compareTo(words[middle]));
      }
      return isIn(word,words,start,end);
   }

   private static String[] getFromFile(String filename)
   {
      ArrayList<String> lines = new ArrayList<>();
      try{
         File file = new File(filename);
         Scanner in = new Scanner(file);
         while (in.hasNext()){
            lines.add(in.nextLine().toLowerCase());
         }
         in.close();
      }
      catch (Exception e){
         e.printStackTrace();
      }
      String[] all = new String[lines.size()];
      return lines.toArray(all);
   }

}
