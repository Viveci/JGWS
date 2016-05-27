package session;

public class MaaFunction{

   public static double bisection (Function fct, double a, double b,double epsilon){
      double rtrn = 0;
            
      while(Math.abs(b-a)>epsilon){
         double midpoint = (a+b)*0.5;
         
         if(fct.f(a) * fct.f(midpoint) > 0){
            a = midpoint;
         }
         else{
            b = midpoint;
         }
      }
      return (b+a)/2;
   }
   
   public static int Fibonacci(int n){
      if(n == 1 || n == 2){
         return 1;
      }
      else if(n > 2){
         return Fibonacci(n-1) + Fibonacci(n-2);
      }
      else{
         return -1;
      }
   }
   
   public static int FibonacciIt(int n){
      int rtrn = 0;
      int a = 1, b = 1;
      
      if(n == 1 || n == 2){
         return 1;
      }
      
      else if(n <= 0){
         return -1;
      }
      
      else if(n > 2){
         
         for (int i = 2; i < n; i++){
            rtrn = a + b;
            b = a;
            a = rtrn;
         }
         
      }
      
      return rtrn;
   }
   
   public static int FibonacciFormula2(int n){
      if(n == 1 || n == 2){
         return 1;
      }
      else if(n <= 0){
         return -1;
      }
      else if((n % 2) == 0){
         return (int) Math.pow(FibonacciFormula2((int)n/2+1),2) + (int) Math.pow(FibonacciFormula2((int)n/2-1),2);
      }
      else{
         return (FibonacciFormula2((int)(n+1)/2)*FibonacciFormula2((int)(n+1)/2)) + (FibonacciFormula2((int)(n-1)/2)*FibonacciFormula2((int)(n-1)/2));
      }
   }
   
   public static void main(String[] args){
      
      System.out.println("Bisection test");
      System.out.println(bisection(new SinusFunction(), ((double)Math.PI/2),((double)3*Math.PI/2), 0.01 ));
      
      int c = 7;
      
      System.out.println("\nFibonacci test");
      System.out.println(Fibonacci(c));
      
      System.out.println("\nFibonacci iterative test");
      System.out.println(FibonacciIt(c));
      
      System.out.println("\nFibonacci formula 2 test");
      System.out.println(FibonacciFormula2(c));
   }
   
}
