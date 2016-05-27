package Model;
import java.util.ArrayList;


public class RoomList implements RoomListInterface{
	
	private ArrayList<Room> roomList;
	private RoomBuilder builder;
	
	public RoomList(){
		this.roomList = new ArrayList<Room>();
		this.builder = new RoomBuilder();
		
		for(int i = 0; i < 5; i++){
			this.roomList.add(builder.buildSingleRoom(i));
		}
		
		for(int i = 5; i < 10; i++){
			this.roomList.add(builder.buildDoubleRoom(i));
		}
		
		for(int i = 10; i < 15; i++){
			this.roomList.add(builder.buildTwinBedRoom(i));
		}
		
		for(int i = 15; i < 20; i++){
			this.roomList.add(builder.buildKingSizedRoom(i));
		}
		
		this.roomList.get(0).setBooked(21, 3, 2016, 24, 3, 2016);
		this.roomList.get(3).setBooked(3, 7, 2016, 4, 8, 2016);
		this.roomList.get(7).setBooked(17, 1, 2016, 19, 1, 2016);
		this.roomList.get(9).setBooked(5, 9, 2016, 24, 10, 2016);
		this.roomList.get(10).setBooked(30, 3, 2016, 8, 4, 2016);
		this.roomList.get(13).setBooked(4, 2, 2016, 7, 2, 2016);
		this.roomList.get(16).setBooked(6, 4, 2016, 16, 4, 2016);
		this.roomList.get(18).setBooked(18, 6, 2016, 10, 7, 2016);
		this.roomList.get(19).setBooked(9, 8, 2016, 1, 11, 2016);
		
	}
	
	public int size(){
		return this.roomList.size();
	}
	
	public Room getRoom(int index){
		index--;
		return this.roomList.get(index);
	}
	
	public String getAllBookedRooms(){
		
		String s = "";
		
		for(int i = 0; i < this.roomList.size(); i++){
			if(this.roomList.get(i).isBooked()){
				s += this.roomList.get(i).toString() + "\n\n";
			}
		}
		
		return s;
	}

	public String getAllAvailableRooms(){
		
		String s = "";
		
		for(int i = 0; i < this.roomList.size(); i++){
			if(!this.roomList.get(i).isBooked()){
				s += this.roomList.get(i).toString()+ "\n\n";
			}
		}
		
		return s;
	}
	
}
