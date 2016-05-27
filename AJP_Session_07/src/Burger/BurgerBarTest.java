package Burger;

public class BurgerBarTest{

   public static void main(String[] args){
      
      BurgerBar burgerBar = new BurgerBar(20);
      
      BurgerBarEmployee emp1 = new BurgerBarEmployee("Bob", burgerBar);
      BurgerBarEmployee emp2 = new BurgerBarEmployee("Rob", burgerBar);
      
      BurgerBarCustomer cust1 = new BurgerBarCustomer(5, "Joe", burgerBar);
      BurgerBarCustomer cust2 = new BurgerBarCustomer(10, "Moe", burgerBar);
      
      Thread worker1 = new Thread(emp1);
      Thread worker2 = new Thread(emp2);
      
      Thread customer1 = new Thread(cust1);
      Thread customer2 = new Thread(cust2);
      
      worker1.start();
      worker2.start();
      
      customer1.start();
      customer2.start();
      
   }
   
}
