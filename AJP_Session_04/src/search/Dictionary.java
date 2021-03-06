package search;

public class Dictionary
{

   public Dictionary()
   {

   }

   public static int binarySearchIterative(int x, int[] sortedArray)
   {
      if (sortedArray.length == 0)
         throw new IllegalStateException();
      int left = 0;
      int right = sortedArray.length - 1;

      while (left <= right)
      {
         int middle = (left + right) / 2;
         if (x == sortedArray[middle])
            return middle;
         if (x > sortedArray[middle])
         {
            left = middle + 1;
         }
         else
         {
            right = middle - 1;
         }
      }
      return -1;
   }

   public static int binarySearch(int x, int[] sortedArray, int left, int right)
   {
      if (left > right){
         return -1;
      }
      int middle = (left + right) / 2;
      if (x == sortedArray[middle]){
         while(middle >= 1 && sortedArray[middle] == sortedArray[middle-1]){
            middle--;
         }
         return middle;
      }
      if (x > sortedArray[middle]){
         left = middle + 1;
         System.out.println("Bigger,The left is " + left + " The right is " + right);
      }
      else{
         right = middle - 1;
         System.out.println("Smaller,The left is " + left + " The right is " + right);
      }
      return binarySearch(x, sortedArray, left, right);
   }
}
