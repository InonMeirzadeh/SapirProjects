import java.util.concurrent.Semaphore;

public class WaitingArea implements Runnable {
	Semaphore s13, s23;
	Car car;
	long start;
	static int finished = 0;
	final int cars;
	
	public WaitingArea(Semaphore s13, Semaphore s23, long start, int cars) {
		this.s13 = s13;
		this.s23 = s23;
		this.start = start;
		this.cars = cars;
	}

	@Override
	public void run() {
		try{
			car = new Car(start);
			car.addCarListener(new CarTakenListener());
			s13.acquire();
			s23.acquire();
			car.action("exit","WaitingArea");
			finished++;
			if(cars == finished)
				car.action("finish", null);
		}
		catch (Exception ignored){}

	}

}
