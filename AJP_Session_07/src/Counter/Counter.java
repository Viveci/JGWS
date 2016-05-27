package Counter;

public class Counter{

   private long value;
   private long max;
   private long min;
   
   public Counter(long min,long max){
      this.max = max;
      this.min = min;
   }
   
   public synchronized void increment(){
      while(value >= max){
         try{
            System.out.println("Increment is Waiting");
            wait();
         }
         catch(InterruptedException e){
            System.out.println("Interrupted");
         }
      }
      value++;
      System.out.println("Incrementing & The counter value is: " + value);
      notifyAll();
   }
   
   public synchronized void decrement(){
      while(value <= min){
         try{
            System.out.println("Decrement is Waiting");
            wait();
         }
         catch(InterruptedException e){
            System.out.println("Interrupted");
         }
      }
      value--;
      System.out.println("Decrementing & The counter value is: " + value);
      notifyAll();
   }
   
   public long getValue(){
      return this.value;
   }
   
   
}
