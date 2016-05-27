package barber;

public class Barber implements Runnable{
   
   private int number;
   private BarberShop monitor;

   public Barber(int number, BarberShop monitor){
      this.number = number;
      this.monitor = monitor;
   }

   public int getNumber(){
      return number;
   }

   @Override
   public void run(){
      while(true){
         try
         {
            Thread.sleep(1500);
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         monitor.cuttingTheNext();
      }
   }
   
}
