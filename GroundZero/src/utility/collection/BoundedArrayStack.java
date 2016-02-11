package utility.collection;

public class BoundedArrayStack<T> implements StackADT<T>{
   
   private T[] stack;
   private int top;
   
   public  BoundedArrayStack(int boundary){
      this.stack = (T[])new Object[boundary];
      this.top = 0;
   }

   @Override
   public void push(T element)throws IllegalArgumentException,
   IllegalStateException{
      if(top == stack.length){
         throw new IllegalStateException("Out of bounds");
      }
      else if(top == stack.length+1){
         throw new IllegalStateException();
      }
      else if(element == null){
         throw new IllegalArgumentException();
      }
      else{
         stack[top] = element;
         top++;
      }
      
   }

   @Override
   public T pop()throws IllegalStateException {
      if(isEmpty()){
         throw new IllegalStateException("The stack is empty");
      }
      top--;
      T rtrn = stack[top];
      stack[top] = null;
      return rtrn;
   }

   @Override
   public T peek()throws IllegalStateException{
      if(isEmpty()){
         throw new IllegalStateException("The stack is empty");
      }
      return stack[top-1];
   }

   @Override
   public int indexOf(T element)throws IllegalArgumentException,
   IllegalStateException{
      int rtrn = -1;
      if(element == null){
         throw new IllegalArgumentException("The element is null");
      }
      else if(isEmpty()){
         throw new IllegalStateException("The stack is null");
      }
      for(int i = 0; i < top; i++){
         if(stack[i].equals(element)){
            rtrn = i;
         }
      }
      return rtrn;
   }

   @Override
   public boolean isEmpty(){
      return (top==0);
   }

   @Override
   public int size(){
      return top;
   }

   public String toString() {
      String s = "";
      if (isEmpty())
         s += "{ }";
      else {
         for (int i = top; i > 0; i--) {
            if (i == top)
               s += "{" + stack[i - 1];
            else
               s += "," + stack[i - 1];
         }
         s += "}";
      }
      return s;
   }
}
