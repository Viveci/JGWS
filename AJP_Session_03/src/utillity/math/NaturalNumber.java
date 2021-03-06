package utillity.math;

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
      int input = value;
      return getValueInBase(input,base);
   }
   
   private String getValueInBase(int value, int base){
      if(value <= 0){
         return "";
      }
      else if(base < 2){
         throw new IllegalArgumentException("The base cannot be less then 2");
      }
      else if(base == 2){
         int number = value % base;
         String numString = "";
         if(value/base == 0){
            numString += "0b" + number; 
            return numString + getValueInBase(value/base, base);
         }
         else{
            numString += number; 
            return getValueInBase(value/base, base) +numString;
         }         
      }
      else if(base < 10){
         int number = value % base;
         String numString = "" + number;
         System.out.println(numString);
         if(value/base == 0){
            return numString+"";
         }
         else if(value == this.value){
            return getValueInBase(value/base, base)+ (value%base) + " [Base "+  base + "]";
         }
         else{
            return getValueInBase(value/base, base) + numString;
         }
      }
      else if(base == 10){
         return getValueInBase(value/base, base) + (value%base);
      }
      else if(base == 16){
         int number = value % base;
         String numString = "";
         if(value/base == 0){
            if(number > 9){
               String c = (char) (number+55)+"";
               numString += "0x" + c;
               return numString + getValueInBase(value/base, base);
            }
            else{
               numString = "0x" + number;
               return numString + getValueInBase(value/base, base);
            }
         }
         else{
            if(number > 9){
               String c = (char) (number+55)+"";
               numString += c;
            }
            else{
               numString = ""+number;
            }
            return getValueInBase(value/base, base) + numString;
         }
      }
      else if(base > 10 && base <= 36){
         int number = value % base;
         String numString = "";
         if(value == this.value){
            if(number > 9){
               String c = (char) (number+55)+"";
               numString = c;
               return getValueInBase(value/base, base) + numString  + " [Base " + base + "]";
            }
            else{
               return getValueInBase(value/base, base) + (value%base) + " [Base " + base + "]";
            }
         }
         if(number > 9){
            String c = (char) (number+55)+"";
            numString = c;
            return getValueInBase(value/base, base) + numString;
         }
         else{
            numString = ""+number;
            return getValueInBase(value/base, base) + numString;
         }
      }
      else if(base > 36){
         int number = value % base;
         String numString = "";
         if(value == this.value){
            return getValueInBase(value/base, base) +"."+ (value%base) + " [Base " + base + "]";
         }
         if(value/base == 0){
            numString += number+"";
         }
         else{
            numString += "."+number;
         }
         return getValueInBase(value/base, base) + numString;
      }
      else{
         return "";
      }
   }
   
   public boolean isLuckyNumber(){
      boolean rtrn = false;
      int [] nums = new int[147483647];
      for(int i = 0; i < 147483647; i++){
         nums[i] = i;
      }
      int rd = 1, th = 1;
      for(int i = 0; i < nums.length; i++){
         if(nums[i]%2 == 0){
            nums[i] = 0;
         }
         if(rd == 3){
            nums[i] = 0;
            rd = 1;
         }
         if(th == 7){
            nums[i] = 0;
            th = 1;
         }
         rd++;
         th++;
      }
      for (int i = 0; i < nums.length; i++){
         if(value == nums[i]){
            rtrn = true;
         }
      }
      return rtrn;
   }

   public int getDigitSum(){
      int input = value;
      return getDigitSum(input);
   }
   
   private static int getDigitSum(int value){
      if(value <= 0){
         return 0;
      }
      else{
         int rtrn = value%10 + getDigitSum(value/10);
         return rtrn;
      }
   }
   
   public int getDigitalRoot(){
      return getDigitalRoot(value);
   }
   
   private static int getDigitalRoot(int value){
      int digit = getDigitSum(value);
      if(value <= 0){
         return 0;
      }
      else if(digit > 10){
         return getDigitSum(digit);
      }
      else{
         return getDigitSum(value/10);
      }
   }
}
