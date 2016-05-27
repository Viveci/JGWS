package Bus_Exercise;


import utility.observer.*;
import java.util.Observable;


public class Bus extends Observable{
	private String info;
	

	public Bus() {
	
		this.info = "eXpress " + hashCode() % 100;
	}

	public void passengerGettingIn(BusPassenger p) {
		super.setChanged();
		super.notifyObservers("Enter: " + p.getName());
		super.addObserver(p);
	}

	public void passengerGettingOut(BusPassenger p) {
		
		super.setChanged();
		super.notifyObservers("Leave: " + p.getName());
		super.deleteObserver(p);
		
	}

	public String getInfo() {
		return info;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus b = (Bus) obj;
		return info.equals(b.info);
	}
}