package task3;

public class Reciever implements Runnable{

   private Port port;
   
   public Reciever(Port port){
      this.port = port;
   }
   
   public void changePort(Port port){
      this.port = port;
   }
   
   private void doStgWithIt(){
      try{
         Thread.sleep(250);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
   }
   
   @Override
   public void run(){
      
      while(true){
         String s = port.recieve();
         doStgWithIt();
         System.out.println(Thread.currentThread().getName() + ": received new message >> " + s);
      }
      
   }

}
