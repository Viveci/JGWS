package bible;

import java.io.FileNotFoundException;
import java.security.AlgorithmConstraints;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Bible
{
   private static String[] words;
   private static String[] dictionary;
   private static long maxCharFreq;
   
   public static final char[] APLHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
      'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
      'x', 'y', 'z' };

   public Bible(String[] words, String[] dictionary)
   {
      this.words = words;
      this.dictionary = dictionary;
   }

   public static long numberOfWords()
   {
      return words.length;
   }

   public static long numberOfCharacters()
   {
      int count = 0;
      for (int i = 0; i < words.length; i++)
      {
         count += words[i].length();
      }
      return count;
   }

   public static long minCharacterFreq()
   {
      long min = 0;
      long counter = 0;
      for (int i = 0; i < APLHABET.length; i++)
      {
         counter = 0;
         for (int j = 0; j < words.length; j++)
         {
            for (int k = 0; k < words[j].length(); k++)
            {
               if (words[j].charAt(k) == APLHABET[i])
               {
                  counter++;
               }
            }
         }
         if (i == 0)
         {
            min = counter;
         }
         else if (counter < min)
         {
            min = counter;
         }
      }
      return min;
   }
   
   public static long maxCharacterFreq(){
      long max = 0;
      long counter = 0;
      for (int i = 0; i < APLHABET.length; i++)
      {
         counter = 0;
         for (int j = 0; j < words.length; j++)
         {
            for (int k = 0; k < words[j].length(); k++)
            {
               if (words[j].charAt(k) == APLHABET[i])
               {
                  counter++;
               }
            }
         }
         if (i == 0)
         {
            max = counter;
         }
         else if (counter > max)
         {
            max = counter;
         }
      }
      maxCharFreq = max;
      return max;
   }
   
   public static Object[][] charactFreq(){
      Object[][] doubleArray = new Object[APLHABET.length][3];
      long counter = 0;
      for (int i = 0; i < APLHABET.length; i++)
      {
         counter = 0;
         for (int j = 0; j < words.length; j++)
         {
            for (int k = 0; k < words[j].length(); k++)
            {
               if (words[j].charAt(k) == APLHABET[i])
               {
                  counter++;
               }
            }
         }
         doubleArray[i][0] = APLHABET[i];
         doubleArray[i][1] = (double)counter/maxCharFreq;
         doubleArray[i][2] = (double)counter;
      }
      return doubleArray;
   }
   
   public static double avgCharFreq()
   {
      Object[][] freqs = charactFreq();
      double sum = 0;
      for (int i = 0; i < freqs.length; i++)
      {
         sum += (double) freqs[i][2];
      }
      return sum / APLHABET.length;
   }
   
   public static double avgWordLength(){
      double avg = 0;
      for (int i = 0; i < words.length; i++){
         avg += words[i].length();
      }
      return avg/words.length;
   }
   
   public double standardDeviation()
   {
      double avg = avgCharFreq();
      Object[][] freqs = charactFreq();
      double sum = 0;
      for (int i = 0; i < freqs.length; i++)
      {
         sum+=Math.pow(((double)freqs[i][2] - avg), 2);
      }
      return sum/APLHABET.length;
   }
   
   public double timesAWord(String word)
   {
      double counter = 0;
      for (int i = 0; i < words.length; i++)
      {
         if (words[i].equalsIgnoreCase(word))
            counter++;
      }
      return counter;
   }
   
   public double timesAWordStarting(String word)
   {
      double counter = 0;
      for (int i = 0; i < words.length; i++)
      {
         if (words[i].contains(word))
            counter++;
      }
      return counter;
   }
   
   public static void main(String[] args) throws FileNotFoundException{
    
      Loader loader = new Loader();
      Bible bible = new Bible(loader.getBible(),loader.getDictionary());
      
      System.out.println("The number of words in bible: " + numberOfWords());
      
      System.out.println("\nThe number of charachters in bible: " + numberOfCharacters());
      
      System.out.println("\nThe minumum charachter frequency: " + minCharacterFreq());
      
      System.out.println("\nThe maximum charachter frequency: " + maxCharacterFreq());
      
      System.out.println("Charachter frequency table: ");
      
      Object[][] table = charactFreq();
      
      for (int i = 0; i < APLHABET.length-1; i++){
         System.out.println(table[i][0] + ": " + table[i][1] + "(" + table[0][2] + ")");
      }
      
      System.out.println("\nThe average charahter freqency: " + avgCharFreq());
      
      System.out.println("\nThe average length of the words: " + avgWordLength());
      
   }

}
