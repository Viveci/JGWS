package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class DeerAlleyClient implements ClientInterface,RemoteObserver<String>,Runnable {

	private ServerInterface server;

	public DeerAlleyClient() throws RemoteException {
		super();
		UnicastRemoteObject.exportObject(this, 0);
		try {
			server = (ServerInterface) Naming.lookup("//10.52.225.122:1099/available");
			server.addObserver(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getTime() {
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	}

	@Override
	public void reply(Object from, String msg) {
		System.out.println(getTime() + ": Server: " + msg);
	}

	public static void main(String[] args) throws RemoteException {
		System.out.println(getTime() + ": Client is running");
		Runnable client = new DeerAlleyClient();
		Thread t1 = new Thread(client);
		t1.start();

	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String in = "";
		while(true){
			System.out.println("Do you want to see available rooms or booked?");
			in = sc.nextLine();
			if(in.equalsIgnoreCase("available")){	
				try {
					System.out.println(this.server.getAvailableRooms());
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
				try {
					this.server.addMessage(this, "We have received a all available rooms request.");
				} catch (RemoteException e) {
					
					e.printStackTrace();
				}
			}
			if(in.equalsIgnoreCase("booked")){
				try {
					System.out.println(this.server.getBookedRooms());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				try {
					this.server.addMessage(this, "All booked rooms request.");
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			if(in.equalsIgnoreCase("exit")){
				System.out.println("Thank you for using this DeerAlleyHotel, Goody bye...");
				System.exit(0);
				sc.close();
			}
		}
	}

	@Override
	public void update(RemoteSubject<String> arg0, String arg1)
			throws RemoteException {
		System.out.println("We have just received a request: " + arg1);
		
	}

}
