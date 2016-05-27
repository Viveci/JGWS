package Burger;

public class BurgerBarEmployee implements Runnable{

   private String name;
   private BurgerBar burgerBar;
   
   public BurgerBarEmployee(String name, BurgerBar burgerBar){
      this.name = name;
      this.burgerBar = burgerBar;
   }

   @Override
   public void run(){
      
    while(true){
       try{
         Thread.sleep(500);
      }
      catch (InterruptedException e){
         e.printStackTrace();
      }
       burgerBar.makeABurger(this.name);
       System.out.println("A burger is made by " + name);
    }
    
   }
   
}
