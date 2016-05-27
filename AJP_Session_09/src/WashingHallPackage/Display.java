package WashingHallPackage;

public class Display implements Runnable{

 public WashingHall wh;
   
   public Display(WashingHall wh){
      this.wh = wh;
   }
   
   @Override
   public void run(){
      
      while(true){
         int free = wh.getFreePlaces();
         System.out.println("Free places " + free);
      }
      
   }

   
   
}
