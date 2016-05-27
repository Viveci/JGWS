package concurrency.parkingplace;

public class Garage implements ParkingPalce{
   
   private int size;
   private int capacity;
   
   public Garage(int maxSize){
      size = maxSize;
      capacity = 0;
   }

   @Override
   public synchronized void arrive(){
      while(capacity > size){
         try
         {
            wait(1000);
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      capacity++;
      System.out.println("Someone parked");
      notifyAll();
   }

   @Override
   public synchronized void leave()
   {
      while(capacity <= 0){
         try{
            wait(1000);
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
      }
      capacity--;
      System.out.println("Someone leaved");
      notifyAll();
   }

   @Override
   public int freePalces()
   {
      return size - capacity;
   }

}
