package Bakery;

public class NumberDispenser implements TakeANumber{

   private int nextNumberToTake = 1;
   private int nextNumberToServe = 1;

   
   public NumberDispenser(){
      this.nextNumberToTake = 0;
      this.nextNumberToServe = 1;
   }
   
   @Override
   public synchronized void takeNextNumber(){
      while(nextNumberToServe < nextNumberToTake){
         try{
            wait();
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
      }
      nextNumberToTake++;
      System.out.println(Thread.currentThread().getName() + " took the number " + nextNumberToTake + " and waits");
      notifyAll();
   }

   @Override
   public synchronized int nextCustomer(){
      while(nextNumberToTake == nextNumberToServe-1){
         try{
            wait();
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
      }
      int rtrn = nextNumberToServe;
      System.out.println(Thread.currentThread().getName() + " served order number " + rtrn);
      nextNumberToServe++;
      notifyAll();
      return rtrn;
   }

}
