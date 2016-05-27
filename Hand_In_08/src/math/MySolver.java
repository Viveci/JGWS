package math;

import java.util.function.Function;

public class MySolver{

   public static double bisection (ExampleFunction fct, double a, double b,double epsilon){
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
   
   public static int intDivison(int m, int n){
      if(m < n){
         return 0;
      }
      else{
         return 1 + intDivison(m-n, n);
      }
   }
   
   public static int intDivisionIt(int m, int n){
      int rtrn = 0;
      while(m>0){
         m = m-n;
         rtrn++;
      }
      return rtrn;
   }

   public static void main(String[] args){
      
      ExampleFunction fct = new ExampleFunction(-2, 1, 10);
      
      double root = bisection(fct, 0, 10, 0.05);
      System.out.println(root);
      
      System.out.println(intDivison(12, 3));
      System.out.println(12/3);
      System.out.println(intDivisionIt(12, 3));
      
   }
   
   public static class ExampleFunction implements Function{
      private int a, b, c;
      
      public ExampleFunction(int a, int b, int c){
         this.a = a;
         this.b = b;
         this.c = c;
      }
      
      public double f(double x){
         return a*(x*x) + c;
      }

      @Override
      public Object apply(Object t){
         return null;
      }

   }
   
}
