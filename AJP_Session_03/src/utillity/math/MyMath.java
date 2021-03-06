package utillity.math;

import utillity.math.*;

public class MyMath{

   public static int factorial(int n){
      return 1 + sum(n);
   }
   
   public static int sum(int n){
      if(n <= 1){
         return 0;
      }
      else{
         return n + sum(n-1);
      }
   }
   
   public static void main(String[] args){
      NaturalNumber n = new NaturalNumber(212);
      System.out.println(n.getValueInBase(11));
   }
   
   
}
