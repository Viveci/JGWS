package RMI;

import java.rmi.RemoteException;

import utility.observer.RemoteSubject;

public interface ServerInterface extends RemoteSubject<String>{
   
   public void addMessage(ClientInterface reply, String msg) throws RemoteException;
   
   public String getAvailableRooms() throws RemoteException;
   
   public String getBookedRooms() throws RemoteException;

}
