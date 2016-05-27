package airport;

public class USA_Airport{

   public static void main(String[] args){
   
      System.out.println("Random USA Airport queue concept proof testing");
      
      AirportQueue USA = new AirportQueue();
      AirportQueue Non_USA = new AirportQueue();
      
      Thread controller1 = new Thread(new PassportController(USA));
      Thread controller2 = new Thread(new PassportController(Non_USA));
      
      Thread Guide = new Thread(new Guide(USA,Non_USA), "Guide");
      
      Guide.start();
      controller1.start();
      controller2.start();
      
   }
   
}
