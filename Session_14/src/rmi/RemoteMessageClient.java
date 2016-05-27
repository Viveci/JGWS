package rmi;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient implements RemoteMessageList, Serializable, Reply{
  
   private static final long serialVersionUID = 1L;
   private RemoteMessageList server;

   public RemoteMessageClient(){
      super();
      try{
         server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
         Scanner sc = new Scanner(System.in);
                  
         while(!sc.nextLine().equals("Q")){
            String msg = sc.nextLine();
            server.addMessage(msg, this);
         }
         sc.close();
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
   }
   
   @Override
   public void addMessage(String msg, Reply who) throws RemoteException{
      server.addMessage(msg, this);
      System.out.println("Client: " + msg + "was sent");
   }
   
   public static void main(String[] args){
      RemoteMessageClient client = new RemoteMessageClient();
   }

   @Override
   public void replyMessage(String msg) throws RemoteException{
      System.out.println("Server: " + msg +" so we are good");
   }

}
