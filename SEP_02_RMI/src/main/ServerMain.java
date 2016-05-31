package main;

import java.net.BindException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.RmiServer;
import RMI.ServerInterface;
import View.ServerFrame;
import controllers.ServerController;

public class ServerMain {

   private RmiServer server;
   private ServerFrame view;
   private ServerController cntrl;

   public ServerMain() throws RemoteException, MalformedURLException {
      Registry reg = LocateRegistry.createRegistry(1001);
      ServerInterface rmiServer = new RmiServer();
      try {
         Naming.rebind("ViaEvents", rmiServer);
      }
      catch (MalformedURLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("Starting server...");
      this.view = new ServerFrame();
      cntrl = new ServerController();
      view.start(cntrl);
   }

   public static void main(String[] args)
         throws RemoteException, MalformedURLException {
      ServerMain m = new ServerMain();
   }

}
