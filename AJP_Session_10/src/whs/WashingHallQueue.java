package whs;

   public class WashingHallQueue{
      
    private QueueADT<Hall> availableHalls;
    private int occupiedHalls;
    
    public WashingHallQueue(int numberOfWashingHalls){
       this.availableHalls = new BoundedArrayQueue<>(numberOfWashingHalls);
       occupiedHalls = 0;
       for (int i = 0; i < numberOfWashingHalls; i++){
         availableHalls.enqueue(new Hall(i+1));
      }
    }
    
    public synchronized Hall enterForWashing(){
     
       while(occupiedHalls >= availableHalls.size()){
          try{
            wait();
            System.out.println(Thread.currentThread().getName() + " is on wait");
         }
         catch (InterruptedException e){
            e.printStackTrace();
         }
       }
       occupiedHalls++;
       System.out.println(Thread.currentThread().getName() + " has entered " + availableHalls.frist().getNumber());
       notifyAll();
       return availableHalls.dequeue();
    }
    
    public synchronized void leaveWashing(Hall hall){
      System.out.println(Thread.currentThread().getName() +" is leaving");
      occupiedHalls--;
      availableHalls.enqueue(hall);
      notifyAll();
    }
    
    public synchronized int getFreePlaces(){
       return availableHalls.size() - occupiedHalls;
    }
    
}
