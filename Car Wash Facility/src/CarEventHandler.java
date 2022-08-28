/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/

import java.util.EventListener;

public interface CarEventHandler extends EventListener {

	public void onCarHandler(CarEvent msg);
}