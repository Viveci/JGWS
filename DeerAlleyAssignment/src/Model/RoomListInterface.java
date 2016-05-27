package Model;

public interface RoomListInterface {
	
	public int size();
	
	public Room getRoom(int index);
	
	public String getAllBookedRooms();
	
	public String getAllAvailableRooms();
	
	public String toString();

}
