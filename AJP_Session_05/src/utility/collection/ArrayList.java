package utility.collection;

public class ArrayList<T> implements ListADT<T>{

   private int size;
   private T[] list;
   private static int DEFAULT_CAPACITY = 100;
   
   public ArrayList(int capacity){
      this.size = 0;
      this.list = (T[])new Object[capacity];
   }
   
   public ArrayList(){
      this.size = 0;
      this.list = (T[]) new Object[DEFAULT_CAPACITY];
   }
   
   @Override
   public void add(int index, T element){
      
      
      
   }

   @Override
   public void add(T element){
      
      
      
   }

   @Override
   public void set(int index, T element){
      list[index] = (T)element;
   }

   @Override
   public T get(int index){
      T rtrn = list[index];
      return rtrn;
   }

   @Override
   public T remove(int index){
      T rtrn = list[index];
      list[index] = null;
      return rtrn;
   }

   @Override
   public T remove(T element){
      T rtrn = list[indexOf(element)];
      list[indexOf(element)] = null;
      return rtrn;
   }

   @Override
   public int indexOf(T element){
      for (int i = 0; i < list.length; i++){
         if(element == null){
            if(element == list[i]){
               return i;
            }
         }
         else{
            if(element.equals(list[i])){
               return i;
            }
         }
      }
      return -1;
   }

   @Override
   public boolean contains(T element){
      boolean rtrn = false;
      for (int i = 0; i < list.length; i++){
         if(element == null){
            if(element == list[i]){
               return true;
            }
         }
         else{
            if(element.equals(list[i])){
               return true;
            }
         }
      }
      return rtrn;
   }

   @Override
   public boolean isEmpty(){
      return size>0;
   }

   @Override
   public int size(){
      return this.size;
   }
   
   
   
}
