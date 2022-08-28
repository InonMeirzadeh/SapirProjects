/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/

import java.util.EventObject;
public class CarEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	private String message;
	private int id;
	
	public CarEvent(Object source , String message) {
		super(source);
		this.message = message;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return this.message;
		
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
