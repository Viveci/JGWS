package doors;
public class CarOpen extends CarState {
    
    public void click(Car door) {
        door.setState(STAYOPEN);
    }
    
    public void timeout(Car door) {
        door.setState(door.CLOSING);
    }
}