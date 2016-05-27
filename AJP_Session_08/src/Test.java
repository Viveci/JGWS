import concurrency.parkingplace.Car;
import concurrency.parkingplace.Garage;

public class Test{

   public static void main(String[] args){
      
      Garage garage = new Garage(4);
      
      Car c1 = new Car("Bmw",garage);
      Car c2 = new Car("Merci",garage);
      Car c3 = new Car("Ford",garage);
      
      Thread car1 = new Thread(c1);
      Thread car2 = new Thread(c2);
      Thread car3 = new Thread(c3);
      
      car1.start();
      car2.start();
      car3.start();
      
      System.out.println("Main thread ended");
      
   }
   
}
