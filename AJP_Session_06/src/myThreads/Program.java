package myThreads;

public class Program implements Runnable{
   
   private String program;
   private int maxFrequency;
   private String action;
   private int count;
   private static long RUNTIME = 100000;
   
   public Program(String program, String aciton, int Count){
      this.program = program;
      this.action = aciton;
      this.count = Count;
   }

   @Override
   public void run(){
      for (int i = 0; i < RUNTIME/count; i++){
         System.out.println(program + " " + action);
         normalOperation();
      }
   }
   
   private void normalOperation(){
      try
      {
         Thread.sleep(RUNTIME/count);
      }
      catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
}
