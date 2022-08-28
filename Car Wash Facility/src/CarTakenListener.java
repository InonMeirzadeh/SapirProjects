/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/

public class CarTakenListener implements CarEventHandler {

	@Override
	public synchronized void onCarHandler(CarEvent car) {
		System.out.println(car.getMessage());
		
	}
}

