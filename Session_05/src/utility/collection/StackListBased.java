package utility.collection;

public class StackListBased<T> implements StackADT<T>{

   private ListADT<T> list;
   
   public StackListBased(){
      list = new LinkedList();
   }

   @Override
   public void push(T element){
      list.add(0, element);
   }

   @Override
   public T pop(){
      T rtrn = list.get(0);
      list.remove(0);
      return rtrn;
   }

   @Override
   public T peek(){
      return list.get(0);
   }

   @Override
   public int indexOf(T element){
      if(element == null){
         throw new IllegalArgumentException();
      }
      return list.indexOf(element);
   }

   @Override
   public boolean isEmpty(){
      return list.isEmpty();
   }

   @Override
   public int size(){
      return list.size();
   }
   
}
