package WashingHallPackage;

public class Car implements Runnable{
   
   public WashingHall wh;
   
   public Car(WashingHall wh){
      this.wh = wh;
   }

   @Override
   public void run(){
      
      for (int i = 0; i < 5; i++){
         drive(1000,2000);
         wh.enterForWashing();
         wash(2000,3000);
         wh.leaveWashing();
      }
      
   }
   
   private void drive(int min, int max){
      
      int time = (int)(Math.random()*(max-min) + min);
      try{
         Thread.sleep(time);
      }
      catch(InterruptedException e){
         e.printStackTrace();
      }
      
   }
   
private void wash(int min, int max){
      
      int time = (int)(Math.random()*(max-min) + min);
      try{
         Thread.sleep(time);
      }
      catch(InterruptedException e){
         e.printStackTrace();
      }
      
   }
   
}
