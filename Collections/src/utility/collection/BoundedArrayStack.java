package utility.collection;

public class BoundedArrayStack<T> implements StackADT<T>{

   private static final long serialVersionUID = 1L;
   private int top;
   private T[] stack;
   
   public BoundedArrayStack(int size){
      this.top = 0;
      this.stack = (T[]) new Object[size];
   }
   
   @Override
   public void push(Object element)
   {
      // TODO Auto-generated method stub
      
   }
   @Override
   public T pop()
   {
      // TODO Auto-generated method stub
      return null;
   }
   @Override
   public T peak()
   {
      // TODO Auto-generated method stub
      return null;
   }
   @Override
   public int indexOfElement(Object element)
   {
      // TODO Auto-generated method stub
      return 0;
   }
   @Override
   public boolean isEmpty()
   {
      // TODO Auto-generated method stub
      return false;
   }
   @Override
   public int size()
   {
      // TODO Auto-generated method stub
      return 0;
   }
   
}