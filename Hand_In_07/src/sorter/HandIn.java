package sorter;

public class HandIn{

   public static int SearchSequential(int[] a, int value){
      int rtrn = -1;
      
      for (int i = 0; i < a.length; i++){
         if(value == a[i]){
            rtrn = i;
         }
         if(value < a[i]){
            break;
         }
      }
      
      return rtrn;
   }
   
   public static int SearchRecSequental(int[] a, int value, int current){
      if(value == a[current]){
         return current;
      }
      else if(value < a[current]){
         return -1;
      }
      else{
         return SearchRecSequental(a, value, current+1);
      }
   }
   
   public static int getNumberOfNonZeroes(int[][] matrix){
      int rtrn = 0;
      
      for (int i = 0; i < matrix.length; i++){
         for (int j = 0; j < matrix.length; j++){
            if(matrix[i][j] != 0){
               rtrn ++;
            }
         }
      }
      
      return rtrn;
   }
   
   public static int[] getArrayRepresentation(int[][] matrix){
      int[] rtrn = new int[getNumberOfNonZeroes(matrix)*3];
      int pos = 0;
      for (int i = 0; i < matrix.length; i++){
         for (int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] != 0){
               rtrn[pos] = matrix[i][j];
               pos++;
               rtrn[pos] =  i;
               pos++;
               rtrn[pos] = j;
               pos++;
            }
         }
      }
      
      return rtrn;
   }
   
   public static int[][] getMatrixFromArray(int[] array, int n){
      int [][] rtrn = new int[n][n];
      int pos = 0;
      for(int i = 0; i < array.length/3; i++){
         int value = array[pos];
         pos++;
         int x = array[pos];
         pos++;
         int y = array[pos];
         pos++;
         rtrn[x][y] = value;
      }
      return rtrn;
   }
   
   public static String out(int[] a){
      String s = "[";
      for (int i = 0; i < a.length-1; i++){
         s += a[i]+",";
      }
      s += a[a.length-1] + "]";
      return s;
   }
   
   public static void main(String[] args){
      int[] a = {1,3,4,5,6,7,8,9};
      System.out.println(SearchSequential(a, 2));
      System.out.println(SearchRecSequental(a, 2, 0));
      
      int[][] matrix = {
            {0,0,1,2},
            {3,0,0,4},
            {0,0,0,0},
            {0,0,5,0}
      };
      System.out.println("\n"+getNumberOfNonZeroes(matrix));
      System.out.println(out(getArrayRepresentation(matrix)));
      
      int[] array = getArrayRepresentation(matrix);
      int [][] rtrn = getMatrixFromArray(array, 4);
      
      for (int i = 0; i < rtrn.length; i++){
         System.out.println(out(rtrn[i]));
      }
   }
   
}
