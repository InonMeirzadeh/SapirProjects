/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/

import java.util.concurrent.Semaphore;

public class WashingFacility2 implements Runnable {
	Car car;
	Semaphore stations, s12, s23;
	long start;
	
	public WashingFacility2(int stations, Semaphore s12, Semaphore s23, long start) {
		this.stations = new Semaphore(stations, true);
		this.s12 = s12;
		this.s23 = s23;
		this.start = start;
	}

	@Override
	public void run() {
	try{
		car = new Car(start);
		car.addCarListener(new CarTakenListener());
		s12.acquire();
		stations.acquire();
		car.action("arrive", "WashingFacility2");
		car.action("begin", "WashingFacility2");
		TimeWash.timeWash(3000);
		car.action("done", "WashingFacility2");
		stations.release();
		s23.release();
	}
	catch(Exception ignored){}
	}
}
