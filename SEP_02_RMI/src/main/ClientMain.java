package main;

import java.rmi.RemoteException;

import RMI.RmiClient;
import View.ClientFrame;
import controllers.ClientController;

public class ClientMain {
   
   private RmiClient client;
   private ClientFrame view;
   private ClientController cntrl;
   
   public ClientMain() throws RemoteException{
      client = new RmiClient();
      cntrl = new ClientController();
      view = new ClientFrame();
      view.start(cntrl);
   }
   
   public static void main(String[] args) {
      try {
         ClientMain cm = new ClientMain();
      }
      catch (RemoteException e) {
         e.printStackTrace();
      }
      System.out.println("ClientMain: Started");
   }

}
