package TemperatureGui;

public class DoubleNode<T>{

   private T element;
   private DoubleNode<T> next;
   private DoubleNode<T> previous;
   
   public DoubleNode(){
      this.element = null;
      next = null;
      previous = null;
   }
   
   public DoubleNode(T element){
      this.element = element;
      next = null;
      previous = null;
   }
   
   public DoubleNode(T element,DoubleNode<T> next,DoubleNode<T>prev){
      this.element = element;
      this.next = next;
      this.previous = prev;
   }
   
   public DoubleNode<T> getNext(){
      return this.next;
   }
   
   public DoubleNode<T> getPrevious(){
      return this.previous;
   }
   
   public void setNext(DoubleNode<T> next){
      this.next = next;
   }
   
   public void setPrevious(DoubleNode<T> previous){
      this.previous = previous;
   }
      
   public T getElement(){
      return this.element;
   }
   
   public void setElement(T element){
      this.element = element;
   }
   
}