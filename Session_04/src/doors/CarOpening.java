package doors;

public class CarOpening extends CarState {
    
    public void click(Car door) {
        door.setState(CLOSING);
    }
    
    public void complete(Car door) {
        door.setState(door.OPEN);
    }
}