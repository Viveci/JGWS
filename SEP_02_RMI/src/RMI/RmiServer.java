package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {
   
   public RmiServer() throws RemoteException {
      super();
   }

   @Override
   public String Auth(String msg, Object client) throws RemoteException {
      System.out.println("RandomUselessMsage: client = " + msg);
      return msg.toUpperCase();
   }
}