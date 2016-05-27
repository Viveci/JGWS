package Counter;

public class TestCounterMonitor{

   public static void main(String[] args){
      
      Counter counter = new Counter(5,10);
      
      CounterIncrement i1 = new CounterIncrement(counter, 10);
      CounterIncrement i2 = new CounterIncrement(counter, 10);
      
      CounterDecrement d1 = new CounterDecrement(counter, 10);
      CounterDecrement d2 = new CounterDecrement(counter, 10);
      
      Thread inc1 = new Thread(i1,"Increment 01");
      Thread inc2 = new Thread(i2,"Increment 02");
      
      Thread dec1 = new Thread(d1,"Decrement 01");
      Thread dec2 = new Thread(d2,"Decrement 02");
      
      inc1.start();
      dec1.start();
      inc2.start();
      dec2.start();
      
   }
   
}
