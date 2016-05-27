package barber;

public class Test{
   
   public static void main(String[] args){
      BarberShop monitor = new BarberShop(3);
      
      Customer c1 = new Customer(1, monitor);
      Customer c2 = new Customer(2, monitor);
      Customer c3 = new Customer(3, monitor);
      Customer c4 = new Customer(4, monitor);
      
      Barber b1 = new Barber(1, monitor);
      
      Thread cus1 = new Thread(c1,"Customer 1");
      Thread cus2 = new Thread(c2,"Customer 2");
      Thread cus3 = new Thread(c3,"Customer 3");
      Thread cus4 = new Thread(c4,"Customer 4");
      Thread bar1 = new Thread(b1,"Barber 1");
      
     cus1.start();
     cus2.start();
     cus3.start();
     cus4.start();
     bar1.start();
      
   }
}
