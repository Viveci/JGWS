package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Model.RoomListProxy;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class DeerAlleyServer implements ServerInterface {
	private ArrayList<String> messages;
	@SuppressWarnings("unused")
	private ClientInterface reply;
	private RoomListProxy listOfRooms;
	private RemoteSubjectDelegate<String> var;

	private static DeerAlleyServer instance;

	private DeerAlleyServer() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		messages = new ArrayList<>();
		this.listOfRooms = new RoomListProxy();
		this.var = new RemoteSubjectDelegate<String>(this);
	}

	public static DeerAlleyServer getInstance() throws Exception {
		if (instance == null) {
			instance = new DeerAlleyServer();
		}
		return instance;
	}

	@Override
	public void addMessage(ClientInterface reply, String msg)
			throws RemoteException {
		this.messages.add(msg);
		System.out.println(getTime() + ": Client: " + msg);
		reply.reply(this, "Message recieved, processing...");
		this.var.notifyObservers(msg);
	}

	public static String getTime() {
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
				.getTime());
	}

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			Registry reg = LocateRegistry.createRegistry(1099);
			new DeerAlleyServer();
			ServerInterface server = DeerAlleyServer.getInstance();
			Naming.rebind("//10.52.225.122/available", server);
			System.out.println(getTime() + ": Starting server...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addObserver(RemoteObserver<String> arg0) throws RemoteException{
		var.addObserver(arg0);
	}

	@Override
	public void deleteObserver(RemoteObserver<String> arg0)
			throws RemoteException {
		var.deleteObserver(arg0);

	}

	@Override
	public String getAvailableRooms() throws RemoteException {
		
		return this.listOfRooms.getAllAvailableRooms();
	}

	@Override
	public String getBookedRooms() throws RemoteException {
	
		return this.listOfRooms.getAllBookedRooms();
	}
}
