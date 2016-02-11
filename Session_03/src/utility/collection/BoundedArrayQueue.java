package utility.collection;

public class BoundedArrayQueue<T> implements QueueADT<T>{
   
   private int count, front;
   private T[] queue;
   
   public BoundedArrayQueue(int capacity){
      this.front = 0;
      this.count = 0;
      this.queue = (T[]) new Object[capacity];
   }

   @Override
   public void enqueue(T element){
      if(element == null){
         throw new IllegalArgumentException("The element is null");
      }
      else if(queue.length <= count){
         throw new IllegalStateException("The queue is full");
      }
      queue[((front+count)%queue.length)] = element;
      count++;
   }

   @Override
   public T dequeue(){
      if(isEmpty()){
         throw new IllegalStateException("The queue is emty");
      }
      T element = queue[front];
      queue[front] = null;
      if(front == queue.length-1){
         front = 0;
      }
      else{
         front ++;
      }
      count--;
      return element;
   }

   @Override
   public T frist()
   {
      if(isEmpty()){
         throw new IllegalStateException("The queue is emty");
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
         for(int i = 0; i < queue.length; i++){
            if(element.equals(queue[i])){
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
