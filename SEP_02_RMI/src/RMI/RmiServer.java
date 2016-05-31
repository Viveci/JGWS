package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {
   
   public static void main(String[] args) {
      try {
         Registry reg = LocateRegistry.createRegistry(1099);
         ServerInterface rmiServer = new RmiServer();
         Naming.rebind("toUpperCase", rmiServer);
         System.out.println("Starting server...");
      }
      catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   public RmiServer() throws RemoteException {
      super();
   }

   @Override
   public String Auth(String msg, Object client) throws RemoteException {
      System.out.println("RandomUselessMsage: client = " + msg);
      return msg.toUpperCase();
   }
}