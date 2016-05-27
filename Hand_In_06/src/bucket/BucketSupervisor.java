package bucket;

import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class BucketSupervisor{
   
   public static void bucketSort(int[] A, int m){
      
      Bucket[] buckets = new Bucket[4];
      for (int i = 0; i < 4; i++){
         buckets[i] = new Bucket(m);
      }
      
      for (int i = 0; i < A.length; i++){
         if(A[i] >= 0 && A[i] <= 25){
            buckets[0].insert(A[i]);
         }
         else if(A[i] >= 26 && A[i] <= 50){
            buckets[1].insert(A[i]);
         }
         else if(A[i] >= 51 && A[i] <= 75){
            buckets[2].insert(A[i]);
         }
         else if(A[i] >= 76 && A[i] <= 100){
            buckets[3].insert(A[i]);
         }
      }
      
      for(Bucket c : buckets){
         c.sort();
      }
      
      
      int temp = 0;
      for (int i = 0; i < 4; i++){
         temp += buckets[i].copyBucketInto(A, temp);
      }
      
   }
   
   public static void main(String[] args){
      
      int[] unsorted = new int[10];
      
      Random r = new Random();
      for (int i = 0; i < unsorted.length; i++){
         unsorted[i] = r.nextInt(100);
      }
      
      System.out.println(toString(unsorted));
      
      bucketSort(unsorted, 25);
      
      System.out.println(toString(unsorted));
      
   }
   
   public static String toString(int[] list){
      String s = "{";
      for (int i = 0; i < list.length-1; i++){
         s += list[i] + ",";
      }
      s += list[list.length-1] + "}";
      return s;
   }
}
