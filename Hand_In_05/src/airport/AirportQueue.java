package airport;

public class AirportQueue implements PassengerQueue{
   
   private ArrayQueue<Passenger> queue;
   
   public AirportQueue(){
      queue = new ArrayQueue<>();
   }

   @Override
   public synchronized void putPassengerInQueue(Passenger p){
      queue.enqueue(p);
      notify();
   }

   @Override
   public synchronized Passenger getNextPassenger(){
      while(queue.isEmpty()){
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
      return queue.dequeue();
   }

}
