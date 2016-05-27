package bucket;

public class Bucket{
   
   private int[] bucket;
   private int count;

   public Bucket(int size){
      bucket = new int[size];
      count = 0;
   }

   public void insert(int x){
      if(count == bucket.length){
         throw new IllegalStateException("Over the limit");
      }
      bucket[count] = x;
      count++;
   }

   public void sort(){
      int min = Integer.MAX_VALUE;
      int temp = 0, minIndex = 0;;
      for (int i = 0; i < bucket.length; i++){
         min = Integer.MAX_VALUE;
         for(int j = i; j < bucket.length; j++){
            if(bucket[j] < min){
               min = bucket[j];
               minIndex = j;
            }
         }
         temp = bucket[i];
         bucket[i] = min;
         bucket[minIndex] = temp;
      }
   }

   public int copyBucketInto(int[] A, int first){
      int counter = 0;
      for (int i = 0; i < bucket.length; i++){
         if(bucket[i] != 0){
            A[counter+first] = bucket[i];
            counter++;
         }
      }
      return counter;
   }
   
   public String toString(){
      String s = "{";
      for (int i = 0; i < bucket.length-1; i++){
         s += bucket[i] + ",";
      }
      s += bucket[bucket.length-1] + "}";
      return s;
   }
      
   
}