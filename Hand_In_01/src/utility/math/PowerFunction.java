package utility.math;

public class PowerFunction{
   
   private static long power(long x, int n){
      if(n == 0){
         return 1;
      }
      else if(n==1){
         return x;
      }
      else{
         return x*power(x,n-1);
      }
   }
   
   private static long iterativePower(long x, int n){
      long sum = 1;
      for (int i = 1; i < n+1; i++){
         sum *= x;
      }
      return sum;
   }
   
   private static long formula2Power(long x, int n){
      if((n % 2)==0){
         return sqr(power(x,n/2));
      }
      else{
         return power(x,n);
      }
   }
   
   public static long sqr(long x){
      return x*x;
   }
   
   public static void main(String[] args){
      
      long x = 3;
      int n = 0;
      
      System.out.println(Math.pow(x, n));
      System.out.println(power(x,n));
      System.out.println(iterativePower(x,n));
      System.out.println(Math.pow(x, n) == power(x,n));
      
      System.out.println(formula2Power(x, n));
      
   }

}
