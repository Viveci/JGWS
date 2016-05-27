package tasker;

import java.util.ArrayList;

public class TaskList{

   private ArrayList<String> list;
   
   public TaskList(){
      list = new ArrayList<>();
   }
   
   public void add(String task){
      list.add(task);
   }
   
   public String getAndRemove(){
      String rtrn = list.get(list.size()-1);
      list.get(list.size()-1);
      list.remove(list.size()-1);
      return rtrn;
   } 
   
   public int size(){
      return list.size();
   }
   
}
