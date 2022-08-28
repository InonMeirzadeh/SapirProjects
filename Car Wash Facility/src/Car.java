/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/

import java.util.ArrayList;
import java.util.List;

public class Car {
    String msg; 
	public List<CarEventHandler> listeners;
	long start;
	
	public Car(long start) {
		this.listeners = new ArrayList<>();
		this.start= start;
	}
	
	public void action(String event, String location){
        msg = getTime() + " seconds passed, " + update(event, location);
    	for (CarEventHandler listener : listeners) {
			listener.onCarHandler(new CarEvent(listener, msg));
			
		}
    }
	
	public double getTime(){
        double time = (System.currentTimeMillis()- start)/1000.0;
        return time;
    }
	
	public String update(String event, String location) {
        String sen = "", name = Thread.currentThread().getName();
        switch(event) {
            case "arrive":
                sen = name + " arrived to " + location;
                break;
            case "begin":
                sen = name + " entered a washing station in " + location;
                break;
            case "done":
                sen = name + " left the washing station from " + location;
                break;
            case "exit":
                sen = name + " left the " + location;
                break;
            case "finish":
            	sen = "All the cars finished their wash";
        }
        return sen;
    }
	
	
	
	public void addCarListener(CarEventHandler listener) {
		listeners.add(listener);
	}
	
	public void removeCarListener(CarEventHandler listener) {
		listeners.remove(listener);
	}
	
	
	
}
