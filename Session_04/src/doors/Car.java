package doors;

public class Car implements CarConstants {
	
	private CarState state = CLOSED;
    
    public void click() {
        state.click(this);
    }
    
    public void complete() {
        state.complete(this);
    }
    
    public void setState(CarState state) {
        this.state = state;
        //	setChanged();
    }
    
    public String status() {
        return state.status();
    }
    
    public void timeout() {
        state.timeout(this);
    }
}