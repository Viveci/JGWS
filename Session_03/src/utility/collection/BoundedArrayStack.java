package utility.collection;

public class BoundedArrayStack<T> implements StackADT<T>{
   
   private int top;
   private T[] stack;
   
   public BoundedArrayStack(int capacity){
      this.top = 0;
      this.stack = (T[]) new Object[capacity];
   }
   
   public String toString(){
      String s = "{";
      for (int i = 0; i < top; i++){
         s += stack[i];
         if(i<top-1){
            s+=",";
         }
      }
      s+="}";
      return null;
   }

   @Override
   public void push(T element){
      if(top>=stack.length){
         throw new IllegalStateException("The stack is full");
      }
      stack[top] = element;
      top++;
   }

   @Override
   public T pop(){
      if(isEmpty()){
         throw new IllegalStateException("The stack is empty");
      }
      T element = stack[top-1];
      stack[top-1] = null;
      top--;
      return element;
   }

   @Override
   public T peek(){
      if(isEmpty()){
         throw new IllegalStateException("The stack is empty");
      }
         T element = stack[top-1];
         return element;
   }

   @Override
   public int indexOf(T element){
      if(element == null){
         for (int i = top-1; i >=0; i--){
            if(stack[i] == null){
               return top-1-i;
            }
         }
      }
      else{
         for (int i = top-1; i >= 0; i--){
            if(element.equals(stack[i])){
               return top-1-i; 
            }
         }
      }
      return -1;
   }

   @Override
   public boolean isEmpty(){
      return top == 0;
   }

   @Override
   public int size(){
      return top;
   }
}
