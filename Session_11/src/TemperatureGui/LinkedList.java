package TemperatureGui;

public class LinkedList<T> implements ListADT<T>
{
   private DoubleNode<T> list;
   private int count;

   public LinkedList()
   {
      list = null;
      count = 0;
   }

   @Override
   public void add(T element)
   {
      add(count, element);
   }
   @Override
   public void add(int index, T element)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      DoubleNode<T> current = list;
      DoubleNode<T> next = getNode(current,index);
      DoubleNode<T> prev;
      DoubleNode<T> newNode = new DoubleNode<T>(element);

      if (index == 0){
         
         prev = getNode(count - 1);
         list = newNode;
      }
      else{
         prev = getNode(current,index - 1);
      }
      if (index == count)
         next = list;
      if (count == 0){
         newNode.setNext(newNode);
         newNode.setPrevious(newNode);
         list = newNode;
      }
      else{
         newNode.setNext(next);
         newNode.setPrevious(prev);
         next.setPrevious(newNode);
         prev.setNext(newNode);
      }
      count++;
   }
   @Override
   public void set(int index, T element)
   {
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");
      DoubleNode<T> current = list;
      getNode(current,index).setElement(element);

   }

   @Override
   public T get(int index)
   {
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");
      DoubleNode<T> current = list;
      return getNode(current,index).getElement();

   }

   @Override
   public T remove(int index)
   {
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");
      DoubleNode<T> current = list;
      DoubleNode<T> node = getNode(current,index);
      DoubleNode<T> next = node.getNext();
      DoubleNode<T> prev = node.getPrevious();
      if (index == 0)
         list = node.getNext();
      node.setNext(null);
      node.setPrevious(null);
      prev.setNext(next);
      next.setPrevious(prev);
      count--;
      return node.getElement();
   }

   @Override
   public T remove(T element)
   {
      if (indexOf(element) == -1)
         throw new IllegalStateException("Element is not in the list");
      return remove(indexOf(element));
   }

   @Override
   public int indexOf(T element)
   {
      DoubleNode<T> current = list;
      if (element == null)
      {
         for (int i = 0; i < count; i++)
         {
            if (element == current.getElement())
            {
               return i;
            }
            current = current.getNext();
         }
      }
      else
      {
         for (int i = 0; i < count; i++)
         {
            if (element.equals(current.getElement()))
            {
               return i;
            }
            current = current.getNext();
         }
      }

      return -1;
   }
   
   public int indexOf(DoubleNode<T> current, T element, int index){
      if(index >= count){
         return -1;
      } 
      else if(element == null){
         if(element == current.getElement()){
            return index;
         }
      }
      else{
         if(element.equals(current.getElement())){
            return index;
         }
      }
      current = current.getNext();
      index += 1;
      return indexOf(current,element,index);
   }

   @Override
   public boolean contains(T element)
   {
      DoubleNode<T> current = list;
      return indexOf(current,element,0) >= 0;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public int size()
   {
      return count;
   }

   private DoubleNode<T> getNode(int index)
   {

      DoubleNode<T> current = list;
      for (int i = 0; i < index; i++)
      {
         current = current.getNext();
      }
      return current;
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < count; i++)
      {
         s += getNode(i).getElement();
         if (i < count - 1)
            s += ", ";
      }
      return s += "}";
   }
   
   private DoubleNode<T> getNode(DoubleNode<T> current, int index){
      if(index == 0){
         return current;
      }
      else{
         current = current.getNext();
         index--;
         return getNode(current,index);
      }
   }
}
