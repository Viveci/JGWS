package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{

   public void reply(Object from, String msg) throws RemoteException;
   
}
