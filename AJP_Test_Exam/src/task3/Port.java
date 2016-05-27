package task3;

import ADT.BoundedArrayQueue;

public class Port implements IPort{
   
   private BoundedArrayQueue<String> queue;
   
   public Port(int upperBound){
      queue = new BoundedArrayQueue<>(upperBound);
   }

   @Override
   public synchronized boolean send(String message){
      try{
         queue.enqueue(message);
         notifyAll();
         return true;
      }
      catch(IllegalStateException e){
         return false;
      }
   }

   @Override
   public synchronized String recieve(){
      while(queue.isEmpty()){
         try{
            wait();
         }
         catch(InterruptedException e){
            e.printStackTrace();
         }
      }
      return queue.dequeue();
   }

}
