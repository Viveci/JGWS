package task3;

import java.util.ArrayList;
import java.util.Random;

public class Sender implements Runnable{

   private ArrayList<Port> ports;
   private int rndm;
   
   public Sender(){
      this.ports = new ArrayList<>();
   }
   
   public void addPort(Port port){
      ports.add(port);
   }
   
   private void send(String msg){
      try{
         Thread.sleep(500);
         rndm = new Random().nextInt(ports.size());
         ports.get(rndm).send(msg);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
   }
   
   @Override
   public void run(){
      String msg = "";
      for (int i = 0; i < 3; i++){
         msg = "Message " + (i+1) + " (" + Thread.currentThread().getName()+ ")";
         send(msg);
      }
   }

}
