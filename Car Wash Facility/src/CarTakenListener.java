public class CarTakenListener implements CarEventHandler {

	@Override
	public synchronized void onCarHandler(CarEvent car) {
		System.out.println(car.getMessage());
		
	}
}

