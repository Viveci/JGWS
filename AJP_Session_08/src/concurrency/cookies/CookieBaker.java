package concurrency.cookies;

public class CookieBaker implements Runnable{

   private String name;
   private int traySize;
   private int limit;
   private CookieJar jar;
   
   public CookieBaker(String name, int size, int limit, CookieJar jar){
      this.name = name;
      this.traySize = size;
      this.limit = limit;
      this.jar = jar;
   }
   
   public CookieBaker(String name,CookieJar jar){
      this.name = name;
      this.traySize = 16;
      this.jar = jar;
   }
   
   @Override
   public void run(){
      while(true){
         if(jar.getNumberOfCookies() < limit){
            try{
               Thread.sleep(1000);
               jar.bake();
               notifyAll();
            }
            catch (InterruptedException e){
               e.printStackTrace();
            }
         }
         else{
            try{
               wait();
            }
            catch (InterruptedException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
   }

}
