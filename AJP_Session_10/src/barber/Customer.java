package barber;

public class Customer implements Runnable{
   
   private int number;
   private BarberShop monitor;

   public Customer(int number, BarberShop monitor){
      this.number = number;
      this.monitor = monitor;
   }

   public int getNumber(){
      return number;
   }

   @Override
   public void run(){
      for (int i = 0; i < 5; i++){
         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         monitor.wantsToBeCut(new Customer(number, monitor));
      }
   }
   
}
