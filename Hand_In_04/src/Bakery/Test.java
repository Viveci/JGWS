package Bakery;

public class Test{

   public static void main(String[] args){
      
      NumberDispenser dispenser = new NumberDispenser();
      
      Thread[] customers = new Thread[10];
      for (int i = 0; i < customers.length; i++){
         customers[i] =  new Thread(new Customer(dispenser), "Customer " + (i+1));
         customers[i].start();
      }
      
      
      Clerk clerk1 = new Clerk(dispenser);
      Clerk clerk2 = new Clerk(dispenser);
      Thread clerkt1 = new Thread(clerk1, "Clerk 1");
      Thread clerkt2 = new Thread(clerk2, "Clerk 2");
      
      
      clerkt1.start();
      clerkt2.start();
      
   }
   
}
