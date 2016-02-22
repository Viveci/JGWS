package doors;

public class CarStayOpen extends CarState {
    
    public void click(Car door) {
        door.setState(CLOSING);
    }
}