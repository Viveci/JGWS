package tasker;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList{
   
   private TaskList tasks;
   
   public TaskServer() throws RemoteException{
      super();
      tasks = new TaskList();
   }
   
   public static void main(String[] args){
      try{
         Registry reg = LocateRegistry.createRegistry(1099);
         RemoteTaskList server = new TaskServer();
         Naming.rebind("tasks", server);
         System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "/ Task server is running");
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
   }

   @Override
   public void add(String task) throws RemoteException{
      tasks.add(task);
      System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + 
                        "/ Server: [" + task + "] Task have been added");      
   }

   @Override
   public String remove() throws RemoteException{
      String rtrn = tasks.getAndRemove();
      System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) +
                        "/ Server: Task [" + rtrn + "] have been removed");
      return rtrn;
   }

   @Override
   public int size() throws RemoteException{
      int rtrn = tasks.size();
      System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) +
                        "/ Server: size is " + rtrn);
      return rtrn;
   }

}
