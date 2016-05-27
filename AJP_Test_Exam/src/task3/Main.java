package task3;

public class Main{
   
   public static void main(String[] args){
      System.out.println("Asynchronous messenger simulation");
      
      Port port1 = new Port(5);
      Port port2 = new Port(5);
      
      Sender sender1 = new Sender();
      sender1.addPort(port1);
      Sender sender2 = new Sender();
      sender2.addPort(port1);
      sender2.addPort(port2);
      Sender sender3 = new Sender();
      sender3.addPort(port1);
      sender3.addPort(port2);
      
      Reciever reciever1 = new Reciever(port1);
      Reciever reciever2 = new Reciever(port2);
      
      
      Thread t1 = new Thread(sender1,"Sender1");
      Thread t2 = new Thread(sender2,"Sender2");
      Thread t3 = new Thread(sender3,"Sender3");
      
      
      Thread t4 = new Thread(reciever1,"Receiver1");
      Thread t5 = new Thread(reciever2,"Receiver2");
      
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t5.start();
      
   }
   
}
