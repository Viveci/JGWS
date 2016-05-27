package whs;

public class WhTest{

   public static void main(String[] args){
      
      WashingHallQueue whq = new WashingHallQueue(5);
      
      Car c1 = new Car(whq);
      Car c2 = new Car(whq);
      Car c3 = new Car(whq);
      Car c4 = new Car(whq);
      Car c5 = new Car(whq);
      Car c6 = new Car(whq);
      
      Thread car1 = new Thread(c1, "Car 1");
      Thread car2 = new Thread(c2, "Car 2");
      Thread car3 = new Thread(c3, "Car 3");
      Thread car4 = new Thread(c4, "Car 4");
      Thread car5 = new Thread(c5, "Car 5");
      Thread car6 = new Thread(c6, "Car 6");
      
      car1.start();
      car2.start();
      car3.start();
      car4.start();
      car5.start();
      car6.start();
      
   }
   
}
