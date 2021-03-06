

public class Show implements Runnable{

   private Clock clock;

   public Show(Clock clock){
      this.clock = clock;
   }
   
   public void run(){
      for (int i=0; i<1*60; i++){
         try{
            Thread.sleep(1000);
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
         clock.set(clock.getHour(), clock.getMinute(), (clock.getSec()+1));
         System.out.println(clock);
      }
   }
}