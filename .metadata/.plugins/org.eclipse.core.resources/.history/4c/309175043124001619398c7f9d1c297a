package RMI;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RmiClient implements Serializable{
   
   private ServerInterface server;

   public RmiClient() throws RemoteException {
      super();
      try {
         server = (ServerInterface) Naming.lookup("rmi://localhost:1099/ViaEvents");
         String msg = server.Auth("Ping!", this);
         System.out.println(msg);

      }
      catch (MalformedURLException e) {
         e.printStackTrace();
      }
      catch (NotBoundException e) {
         e.printStackTrace();
      }
   }
   
}
