package Bakery;

public class Customer implements Runnable{

   private NumberDispenser dispenser;
   
   public Customer(NumberDispenser dispenser){
      this.dispenser = dispenser;
   }

   @Override
   public void run(){
      
      for (int i = 0; i < 5; i++){
         queing(1500,2000);
         dispenser.takeNextNumber();
      }
   }
   
   private void queing(int min, int max){
      int time = (int)(Math.random()*(max-min) + min);
      try{
         Thread.sleep(time);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
   }
   
}
