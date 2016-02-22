package doors;

public abstract class CarState implements CarConstants {
    
    public abstract void click(Car door);
    
    public void complete(Car door) {
    }
    
    public String status() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }
    
    public void timeout(Car door) {
    }
}