package Logger;

public class ArrayQueue<T> implements QueueADT<T>{
   
   private static int DEFAULT_CAPACITY = 100;
   private int front, count;
   private T[] queue;
   
   public ArrayQueue(){
      this.front = 0;
      this.count = 0;
      this.queue = (T[]) new Object[DEFAULT_CAPACITY];
   }
   
   public ArrayQueue(int capacity){
      this.front = 0;
      this.count = 0;
      this.queue = (T[]) new Object[capacity];
   }

   @Override
   public void enqueue(T element){
      if(count+1 >= queue.length){
         expandCapacity();
      }
      else if(element == null){
         throw new IllegalArgumentException("The element cannot be null");
      }
      queue[((front+count)%queue.length)] = element;
      count++;      
   }

   private void expandCapacity()
   {
      T[] nw = (T[])new Object[queue.length*2];
      for (int i = 0; i < queue.length; i++)
      {
         nw[i] = queue[i];
      }
      queue = nw;
   }

   @Override
   public T dequeue(){
      return null;
   }

   @Override
   public T frist()
   {
      if(count == 0){
         throw new IllegalStateException("The queue is empty");
      }
      T element = queue[front]; 
      return element;
   }

   @Override
   public int indexOf(T element){
      if(isEmpty()){
         throw new IllegalStateException("The queue is emty");
      }
      if(element == null){
         throw new IllegalArgumentException("The argument cannot be null");
      }
         for(int i = 0; i < count; i++){
            if(element.equals(queue[((front+i)%queue.length)])){
               return i;
            }
         }
      
      return -1;
   }

   @Override
   public boolean isEmpty(){
      return count==0;
   }

   @Override
   public int size(){
      return count;
   }

}
