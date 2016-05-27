package Burger;

public class BurgerBarCustomer implements Runnable{

   private String name;
   private int burgersToEat;
   private BurgerBar burgerBar;
   
   public BurgerBarCustomer(int burgersToEat, String name,BurgerBar burgerBar){
      this.name = name;
      this.burgersToEat = burgersToEat;
      this.burgerBar = burgerBar;
   }

   @Override
   public void run(){
      for (int i = 0; i < burgersToEat; i++){
         try{
            Thread.sleep(1000);
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
         burgerBar.eatABurger(this.name);
      }
      System.out.println(name+ " ate a burger, left: " + burgerBar.getnumberOfBurgers());
   }
   
}
