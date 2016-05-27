package barber;

public class BarberShop implements barberTemplate{
   
   private QueueADT<Customer> customers;
   private int free;
   
   public  BarberShop(int capacity){
      this.customers = new BoundedArrayQueue<>(capacity);
      free = capacity;
   }
   
   @Override
   public synchronized void wantsToBeCut(Customer c){
      while(free <= 0){
         try{
            wait();
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
      }
      free--;
      customers.enqueue(c);
      System.out.println(Thread.currentThread().getName() + " is waiting");
      notifyAll();
   }

   @Override
   public synchronized Customer cuttingTheNext(){
      while(customers.size() == 0){
         try{
            wait();
         }
         catch (IllegalStateException | InterruptedException e){
            e.printStackTrace();
         }
      }
      free++;
      Customer rtrn = customers.dequeue();
      System.out.println("The barber is cutting " + rtrn.getNumber());
      notifyAll();
      return rtrn;
   }

   
   
}
