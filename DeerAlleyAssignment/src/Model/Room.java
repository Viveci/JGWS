package Model;

public class Room {

	private Date date;
	private boolean booked;
	private int price, roomNumber;

	public Room(int roomNumber, String typeOfRoom) {
		this.roomNumber = roomNumber;
		this.date = null;
		this.booked = false;
		setPrice(typeOfRoom);
	}

	public void setBooked(int startDay, int startMonth, int startYear,
			int endDay, int endMonth, int endYear) {
		Date date = new Date(startDay, startMonth, startYear, endDay, endMonth,
				endYear);
		this.date = date;
		this.booked = true;
	}

	public Date getDate() {
		return date;
	}

	public boolean isBooked() {
		return booked;
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(String roomType) {
		if (roomType.equalsIgnoreCase("Single")) {
			this.price = 110;
		}
		if (roomType.equalsIgnoreCase("Double")) {
			this.price = 160;
		}
		if (roomType.equalsIgnoreCase("Twin beds")) {
			this.price = 220;
		}
		if (roomType.equalsIgnoreCase("King size")) {
			this.price = 320;
		}
	}

	@Override
	public String toString() {
		if (booked) {
			return "Room #" + this.roomNumber + " status" + "\nPrice: "
					+ this.price + "\n" + bookedOrNotBooked() + "from/to: \n"
					+ date.toString();
		}
		return "Room #" + this.roomNumber + " status" + "\n" + "Price: "
				+ this.price + "\n" + bookedOrNotBooked();
	}

	private String bookedOrNotBooked() {
		return (this.booked) ? "Booked " : "Not booked.";
	}

}
