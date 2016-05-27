package WashingHallPackage;

public class WashingHall{

   private int maxPlaces;
   private int occupied;
   
   public WashingHall(int halls){
      this.maxPlaces = halls;
      occupied = 0;
   }
   
   public synchronized void enterForWashing(){
      
      while(occupied >= maxPlaces){
         try{
            System.out.println(Thread.currentThread().getName() + " is on wait");
            wait();
         }
         catch(InterruptedException e){
            e.printStackTrace();
         }
      }
      System.out.println(Thread.currentThread().getName() + " is being washed");
      occupied++;
      notifyAll();
      
   }
   
   public synchronized void leaveWashing(){
      System.out.println(Thread.currentThread().getName() + " is feinshed being washed");
      occupied--;
      notifyAll();// Notify cars (and display)
      
   }
   
   public synchronized int getFreePlaces(){
      try{
         wait();
      }
      catch(InterruptedException e){
         e.printStackTrace();
      }
      return maxPlaces - occupied;
   }
   
}
