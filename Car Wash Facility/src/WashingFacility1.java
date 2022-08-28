import java.util.concurrent.Semaphore;

public class WashingFacility1 implements Runnable {
	Semaphore stations , s12 , s13;
	static int finished = 0;
	final int cars;
	Car car;
	long start;
	
	public WashingFacility1(int stations, Semaphore s12, Semaphore s13, int cars, long start) {
		this.stations = new Semaphore(stations, true);
		this.s12 = s12;
		this.s13 = s13;
		this.cars = cars;
		this.start = start;
	}

	public void run() {
		try{
			car = new Car(start);
			car.addCarListener(new CarTakenListener());
			car.action("arrive", "WashingFacility1");
			stations.acquire();
			car.action("begin", "WashingFacility1");
			TimeWash.timeWash(3000);
			car.action("done", "WashingFacility1");
			stations.release();
			finished++;
			s12.release();
			if(cars == finished)
				s13.release(cars);
		}
		catch(Exception ignored){}
	}
}
