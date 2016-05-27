package concurrency.cookies;

public class CookieEater implements Runnable{
   
   private String name;
   private CookieJar jar;

   public CookieEater(String name, CookieJar jar){
      this.name = name;
      this.jar = jar;
   }
   
   @Override
   public void run(){
      while(true){
         if(jar.isEmpty()){
            try{
               wait();
               }
            catch(InterruptedException e){
               
            }
         }
         else{
            try{
               Thread.sleep(500);
               jar.eat();
            }
            catch (InterruptedException e){
               e.printStackTrace();
            }
         }
      }
   }

}
