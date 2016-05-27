package task2;

public class Search{

   public static int specialLinearSearch(int[] t, int key){
      int rtrn = -1;
      
      for (int i = 0; i < t.length; i++){
         if(t[i] == key){
            rtrn = i;
         }
         else if(t[i] > key){
            break;
         }
      }
      
      return rtrn;
   }
   
   public static int jumpSearch(int[] t, int key){
      int rtrn, jumpLength = (int) Math.floor(Math.sqrt(t.length));
      int prevPosition = 0, counter = 0;
      
      if(key < 0){
         throw new IllegalArgumentException("This impleentation of the search method does not fucntion with negative values");
      }
      
      while(t[counter] < key){
         if(counter+jumpLength > t.length){
            break;
         }
         else{
         counter += jumpLength;
         }
      }
      
      if(key == t[counter]){
         return counter;
      }
      
      else{
         prevPosition = counter - jumpLength;
         while(t[prevPosition] < key){
            prevPosition++;
         }
         
         if(t[prevPosition] == key){
            rtrn = prevPosition;
         }
         else{
            rtrn = -1;
         }
         return rtrn;
      }
   }
   
}
