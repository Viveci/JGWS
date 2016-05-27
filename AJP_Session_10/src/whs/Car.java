package whs;

public class Car implements Runnable{
   
   public WashingHallQueue wh;
   private Hall hall;
   
   public Car(WashingHallQueue wh){
      this.wh = wh;
   }

   @Override
   public void run(){
      
      for (int i = 0; i < 5; i++){
         drive(100,200);
         Hall asd = wh.enterForWashing();
         wash(200,300);
         wh.leaveWashing(asd);
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
