package Bakery;

public class Clerk implements Runnable{

   private NumberDispenser dispenser;
   
   public Clerk(NumberDispenser dispenser){
      this.dispenser = dispenser;
   } 
   
   @Override
   public void run(){
      
      while(true){
      int i = dispenser.nextCustomer();
      serving(500,1000);
      }
   }
   
   private void serving(int min, int max){
      int time = (int)(Math.random()*(max-min) + min);
      try{
         Thread.sleep(time);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
   }

}
