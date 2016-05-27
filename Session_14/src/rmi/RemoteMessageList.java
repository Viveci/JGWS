package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote{

   public void addMessage(String msg, Reply who) throws RemoteException;
   
}
