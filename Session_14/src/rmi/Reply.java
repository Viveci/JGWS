package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reply extends Remote{

   public void replyMessage(String msg) throws RemoteException;
   
}
