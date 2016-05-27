package concurrency.parkingplace;

import java.util.Random;

public class Car implements Runnable{

   private String name;
   private Garage park;
   
   public Car(String name, Garage park){
      this.name = name;
      this.park = park;
   }
   
   private void Drive(){
      System.out.println(name + " drives");
   }
   
   private void Arrive(){
      if(park.freePalces() > 0){
         park.arrive();
         try{
            Thread.sleep(3000);
            System.out.println(name + " has parked and waits 3 seconds");
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
      }
   }
   
   private void Leave(){
      park.leave();
      System.out.println(name+" leaves");
   }
   
   @Override
   public void run(){
      int i = 0;
      while(i < 3){
         Drive();
         Arrive();
         Leave();
         Drive();
         i++;
      }
   }

}
