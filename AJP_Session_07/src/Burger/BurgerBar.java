package Burger;

public class BurgerBar{
   
   private int numberOfBurgers;
   private int maxNumberOfBurgers;
   
   public BurgerBar(int max){
      this.maxNumberOfBurgers = max;
      numberOfBurgers = 0;
   }
   
   public synchronized void makeABurger(String employeeName){
      while(numberOfBurgers >= maxNumberOfBurgers){
         try{
            wait();
         }
         catch(InterruptedException e){
            //intrptd
         }
      }
      numberOfBurgers++;
      System.out.println("The number of " + ((numberOfBurgers == 1) ? "burger is " : "burgers are ") + numberOfBurgers);
      notifyAll();
   }
   
   public synchronized void eatABurger(String name){
      while(numberOfBurgers <= 0){
         try{
            wait();
         }
         catch(InterruptedException e){
            //Intrptd
         }
      }
      numberOfBurgers--;
      System.out.println("The number of burgers " + ((numberOfBurgers == 1) ? "is " : "are ") + numberOfBurgers);
      notifyAll();
   }
   
   public int getnumberOfBurgers(){
      return this.numberOfBurgers;
   }
   
}
