package bible;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader{
   
   private static ArrayList<String> bible;
   private static ArrayList<String> dictionary;
   
   public Loader(){
      bible = new ArrayList<String>();
      dictionary = new ArrayList<String>(); 
   }
   
   public String[] getBible() throws FileNotFoundException{
      
      File bble = new File("bible.txt");
      FileInputStream is = new FileInputStream(bble);
      Scanner sc = new Scanner(is);
            
      while(sc.hasNext()){
         
         Pattern pattern = Pattern.compile("\\w+");
         Matcher matcher = pattern.matcher(sc.nextLine().toLowerCase());
         
         while (matcher.find()) {
             bible.add(matcher.group());
         }
         
      }
      
      String[] rtrn = new String[bible.size()];
      bible.toArray(rtrn);
      
      sc.close();
      
      return rtrn;
      
   }
   
   public String[] getDictionary() throws FileNotFoundException{
      
      File dict = new File("dictionary.txt");
      FileInputStream ds = new FileInputStream(dict);
      Scanner sc = new Scanner(dict);
      
      while(sc.hasNext()){
         dictionary.add(sc.nextLine());
      }
      
      sc.close();
      
      String[] rtrn = new String[dictionary.size()];
      dictionary.toArray(rtrn);
      
      return rtrn;
   }
   
}
