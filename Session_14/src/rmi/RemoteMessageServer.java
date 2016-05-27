package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList{

   private ArrayList<String> list;
   
   public static void main(String[] args){
      try{
         Registry reg = LocateRegistry.createRegistry(1099);
         RemoteMessageList server = new RemoteMessageServer();
         Naming.rebind("addMessage", server);     
         
         System.out.println("Crashing in 3... 2... 1...");
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
   }
   
   protected RemoteMessageServer() throws RemoteException{
      super();
      list = new ArrayList<>();
   }

   @Override
   public void addMessage(String msg, Reply who) throws RemoteException
   {
      list.add(msg);
      System.out.println("Client : " + msg);
      who.replyMessage("Danke schön auf wiedersehen");
   }

}
