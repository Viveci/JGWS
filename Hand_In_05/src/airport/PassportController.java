package airport;

import java.util.Random;

public class PassportController implements Runnable
{

   private AirportQueue queue;

   public PassportController(AirportQueue queue){
      this.queue = queue;
   }

   @Override
   public void run(){
      while (true){
         Passenger temp = queue.getNextPassenger();
         passportCheck(temp);
      }
   }
   
   private void passportCheck(Passenger p){
      Random r = new Random();
      int time = r.nextInt(3000 - 2000) + 2000;
      try{
         Thread.sleep(time);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
      
      System.out.println(p.getNationality()+ " " + p.getPassportNumber() + " has passed passport controll");
   }

}
