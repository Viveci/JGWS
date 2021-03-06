package utility.math;

import java.util.ArrayList;

public class NaturalNumber{

   private int value;
   
   public NaturalNumber(int value){
      if(value < 0){
         throw new IllegalArgumentException("The number cannot be less then 0");
      }
      this.value = value;
   }
   
   public void setValue(int value){
      if(value < 0){
         throw new IllegalArgumentException("The number cannot be less then 0");
      }
      this.value = value;
   }
   
   public int getValue(){
      return this.value;
   }
   
   public String toString(){
      return "The value is: "+this.value;
   }
   
   public int[] getPrimeFactors(){
      int value = this.value;
      ArrayList<Integer> factors = new ArrayList<>();
      int i = 2;
      while(value > 1)
      {
         while (value % i == 0)
         {
            factors.add(i);
            value /= i;
         }
         i++;
      }
      return convertToIntArray(factors);
   }
   
   private static int[] convertToIntArray(ArrayList<Integer> list)
   {
      int[] array = new int[list.size()];
      for (int i = 0; i < list.size(); i++)
      {
         array[i] = list.get(i);
      }
      return array;
   }

   public boolean isPrime(){
      boolean prime = true;
      if(value > 0){
         for (int i = 2; i < this.value; i++){
            if((value % i) == 0){
               prime = false;
            }
         }
      }
      else{
         return false;
      }
      return prime;
   }
   
   public boolean isPrimePower(){
      boolean pp = true;
      int [] pf = getPrimeFactors();
      for (int i = 0; i < pf.length-1; i++){
         if(pf[i] != pf[i+1]){
          pp = false;  
         }
      }
      return pp;
   }
   
   public int[] getProperDivisors(){
      ArrayList<Integer> a = new ArrayList<>();
      for (int i = 1; i < value; i++){
         if((value % i) == 0){
            a.add(i);
         }
      }
      return convertToIntArray(a);
   }

   public boolean isPrefectNumber(){
      int sum = 0;
      int [] pp = getProperDivisors();
      for (int i = 0; i < pp.length; i++){
         sum += pp[i];
      }
      return(sum==value);
   }

   public String getValueInBase(int base){
      return getValueInBase(value,base);
   }
   
   private String getValueInBase(int value, int base){
      if(value <= 0){
         return "";
      }
      else if(base < 2){
         throw new IllegalArgumentException("The base cannot be less then 2");
      }
      else if(base <= 10){
         return getValueInBase(value/base, base) + (value%base);
      }
      else if(base > 10 && base <= 36){
         return "v�rj�l";
      }
      else{
         return "v���rj�lm��r";
      }
   }
}
