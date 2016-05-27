package tasker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class TaskClient {

   private RemoteTaskList list;
   
   public TaskClient() throws MalformedURLException, RemoteException, NotBoundException{
      super();
      list = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/tasks");
      String message = "";
      Scanner sc = new Scanner(System.in);
      while(!message.equals("Q")){
         message = sc.nextLine();
         if(message.equals("add")){
            System.out.println("Task description");
            message = sc.nextLine();
            list.add(message);
         }
         else if(message.equals("remove")){
            System.out.println("Removing task" + list.remove());
         }
         else if(message.equals("size")){
            System.out.println(list.size());
         }
      }
   }
   
   public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
      TaskClient client = new TaskClient();
   }
   
}
