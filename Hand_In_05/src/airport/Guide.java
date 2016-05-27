package airport;

import java.util.Random;

public class Guide implements Runnable{

   private String[] Nationality = {"USA" , "French" , "Danish" , "Canadian" , "Italian"};
   private AirportQueue USA_queue;
   private AirportQueue Non_queue;
   
   public Guide(AirportQueue queue, AirportQueue non){
      this.USA_queue = queue;
      this.Non_queue = non;
   }
   
   @Override
   public void run(){
      while(true){
         Passenger temp = passengerPopUp(500, 3000);
         if(temp.getNationality().equals("USA")){
            USA_queue.putPassengerInQueue(temp);
            System.out.println(temp.getPassportNumber() + " passenger arrived. Nationality: " + temp.getNationality() + ". Was put into USA queue");
         }
         else{
            Non_queue.putPassengerInQueue(temp);
            System.out.println(temp.getPassportNumber() + " passenger arrived. Nationality: " + temp.getNationality() + ". Was put into Non USA queue");
         }
      }
   }
   
   private Passenger passengerPopUp(int min, int max){
      Random r = new Random();
      
      int PassportNumber = (r.nextInt(9999 - 1000) + 1000);
      String PassengerNationality = Nationality[r.nextInt(Nationality.length)];
      Passenger rtrn = new Passenger(PassengerNationality,PassportNumber);
      
      int time = r.nextInt(max - min) + min;
      
      try{
         Thread.sleep(time);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
      return rtrn;
   }
}
