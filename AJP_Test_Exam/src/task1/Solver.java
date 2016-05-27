package task1;

public class Solver{

   public static int factorial(int n){
      int rtrn = 1;
      
         for (int i = 1; i < n+1; i++){
            rtrn *= i;
         }
      
      return rtrn;
   }
   
   public static int binomial(int n, int q){
      int rtrn = 0;
      
      rtrn = factorial(n)/(factorial(n-q)*factorial(q));
      
      return rtrn;
   }
   
   public static int binomialRecursive(int n, int q){
      if(n == q){
         return 1;
      }
      else if( q == 0){
         return 1;
      }
      else{
         return binomialRecursive(n-1, q) + binomialRecursive(n-1, q-1);
      }
   }
   
}
