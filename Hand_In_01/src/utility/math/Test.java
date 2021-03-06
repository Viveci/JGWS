package utility.math;

public class Test{

   public static void main(String[] args){
      System.out.println("isPrime test\n");
      
      NaturalNumber a = new NaturalNumber(31);
      NaturalNumber b = new NaturalNumber(20);
      NaturalNumber c = new NaturalNumber(16);
      NaturalNumber d = new NaturalNumber(27);
      NaturalNumber e = new NaturalNumber(6);
      NaturalNumber f = new NaturalNumber(28);
      NaturalNumber g = new NaturalNumber(6);
      
      //isPrime test
      System.out.println(a.isPrime());
      System.out.println(b.isPrime());
      System.out.println(c.isPrime());
      System.out.println(d.isPrime());
      
      System.out.println("\nisPrimePower test\n");
      
      System.out.println(a.isPrimePower());
      System.out.println(b.isPrimePower());
      System.out.println(c.isPrimePower());
      System.out.println(d.isPrimePower());
      
      int [] ePD = e.getProperDivisors();
      int [] fPD = f.getProperDivisors();
      int [] gPD = g.getProperDivisors();
      System.out.println();
      
      System.out.println("PerfectNumber test\n");
      System.out.println(e.isPrefectNumber());
      System.out.println(f.isPrefectNumber());
      System.out.println(g.isPrefectNumber());
   }
   
}
