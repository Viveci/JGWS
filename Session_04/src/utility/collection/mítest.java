package utility.collection;

public class m�test{
   public static void main(String[] args){
      LinkedList<String> list = new LinkedList<>();
      list.add("$A$");
      list.add("asd");
      list.add("sala");
      list.set(2, "lala");
      System.out.println(list.get(1));
      System.out.println(list.contains(null));
   }
}
