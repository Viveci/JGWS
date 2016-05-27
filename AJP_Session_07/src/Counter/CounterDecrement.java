package Counter;

public class CounterDecrement implements Runnable{

   private int update;
   private Counter counter;
   
   public CounterDecrement(Counter counter, int updates){
      this.update = updates;
      this.counter = counter;
   }
   
   @Override
   public void run(){
      for(int i = 0; i < this.update; i++){
         counter.decrement();
      }
      System.out.println("Thread ended");
   }

}
