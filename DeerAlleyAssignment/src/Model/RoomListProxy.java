package Model;


public class RoomListProxy implements RoomListInterface {

	private RoomList roomList;
	
	public RoomListProxy(){
		this.roomList = new RoomList();
	}
	
	@Override
	public synchronized int size() {
		return this.roomList.size();
	}

	@Override
	public synchronized Room getRoom(int index) {
		return this.roomList.getRoom(index);
	}

	@Override
	public synchronized String getAllBookedRooms() {
		return this.roomList.getAllBookedRooms();
	}

	@Override
	public synchronized String getAllAvailableRooms() {
		return this.roomList.getAllAvailableRooms();
	}


}
