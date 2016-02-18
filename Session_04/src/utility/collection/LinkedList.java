package utility.collection;

public class LinkedList<T> implements ListADT<T>{
   
   private int count;
   private DoubleNode<T> list;
   
   public LinkedList(){
      count = 0;
      list = new DoubleNode<T>();
   }

   public void add(T element){
      if(count == 0){
         list = new DoubleNode<>(element,null,null);
         count++;
      }
      else{
      add(count,element);
      }
   }
   
   @Override
   public void add(int index, T element){
         if (index < 0 || index > count){
            throw new IndexOutOfBoundsException();
      }
         else if (count == 0){
         list = new DoubleNode<T>(element,null,null);
         count++;
      }
      else{
         DoubleNode<T> temp = getNode(index-1);
         if(temp.getNext()== null){
         temp.setNext(new DoubleNode<>(element,null,temp));
         }
         else if(index == 0){
            list =  new DoubleNode<>(element,temp,null);
            temp.setPrevious(list);
         }
         else{
            DoubleNode<T> next = temp.getNext();
            DoubleNode<T> current = new DoubleNode<>(element,next,temp);
            next.setPrevious(current);
            temp.setNext(current);
         }
      }
      count++;
   }

   @Override
   public void set(int index, T element){
         DoubleNode<T> temp = getNode(index);
         temp.setElement(element);  
   }

   @Override
   public T get(int index){
      return getNode(index).getElement();
   }

   @Override
   public T remove(int index){
      if(index >= count || index < 0){
         throw new IllegalArgumentException("Out of bounds");
      }
      else if(index == 0){
         DoubleNode<T> temp = list;
         list = list.getNext();
         return temp.getElement();
      }
      else{
         DoubleNode<T> temp = getNode(index);
         if(temp.getNext()== null){
            DoubleNode<T> prev = temp.getPrevious();
            prev.setNext(null);
            return temp.getElement();
         }
         else{
            DoubleNode<T> prev = temp.getPrevious();
            prev.setNext(temp.getNext());
            return temp.getElement();
         }
      }
   }

   @Override
   public T remove(T element){
      return remove(indexOf(element));
   }

   @Override
   public int indexOf(T element){
      DoubleNode<T> temp = list;
      int counter = 0,rtrn = -1;
      while(temp!=null){
         if(temp.getElement().equals(element)){
            rtrn = counter;
         }
         temp = temp.getNext();
         counter++;
      }
      return rtrn;
   }

   @Override
   public boolean contains(T element){
      return (indexOf(element)!=-1);
   }

   @Override
   public boolean isEmpty(){
      return (count <= 0);
   }

   @Override
   public int size(){
      return count;
   }
   
   private DoubleNode<T> getNode(int index){
      if(index >= count || index < 0){
         throw new IllegalArgumentException("out of bounds");
      }
      DoubleNode<T> current = list;
      for(int i = 0; i < index; i++){
         current = current.getNext();
         }
      return current;
      }

   public String toString(){
      String s = "{";
      DoubleNode<T> temp = list;
         while(temp.getNext()!=null){
            s += temp.getElement() + ",";
            temp = temp.getNext();
         }
      s+=temp.getElement() + "};";
      return s;
   }
   
}
