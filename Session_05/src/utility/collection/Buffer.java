package utility.collection;

public interface Buffer<T>{
   
   public void put(T element);
   
   public T take();
   
   public T look();
   
   public int indexOf(T element);
   
   public boolean isFull();
   
   public int size();
   
}