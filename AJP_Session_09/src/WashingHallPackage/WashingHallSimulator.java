package WashingHallPackage;

public class WashingHallSimulator{

   public static void main(String[] args){
      
      WashingHall wh = new WashingHall(3);
      
      Thread display = new Thread(new Display(wh),"Display");
      display.start();
      
      Thread[] cars = new Thread[10];
      for (int i = 0; i < cars.length; i++){
         cars[i] = new Thread(new Car(wh),"Car " + (i+1));
         cars[i].start();
      }
      
   }
   
}
