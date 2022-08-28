/*Inon Meirzadeh - 315858399
 * Tom Basha - 311425714
*/


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class MainProgramCarsWash {

	public static void main(String[] args) {
		final int num_of_cars;
		final int washing_stands1;
		final int washing_stands2;
		Semaphore s12 = new Semaphore(0, true);
		Semaphore s13 = new Semaphore(0, true);
		Semaphore s23 = new Semaphore(0, true);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount of cars: ");
		num_of_cars = sc.nextInt();
		System.out.print("Enter amount of wash positions for Wash Station 1: ");
		washing_stands1 = sc.nextInt();
		System.out.print("Enter amount of wash positions for Wash Station 2: ");
		washing_stands2 = sc.nextInt();
		sc.close();

		final long start = System.currentTimeMillis();

		
		ExecutorService executor = Executors.newFixedThreadPool(num_of_cars);
  	for (int i = 0; i < num_of_cars; i++) {
		AverageTimeBetweenCars.delay(1500);

			executor.execute(new WashingFacility1(washing_stands1, s12, s13, num_of_cars,start));
			executor.execute (new WashingFacility2(washing_stands2, s12, s23, start));


			executor.execute (new WaitingArea(s13, s23, start,num_of_cars));
		}
//			
			 
			((ExecutorService) executor).shutdown();
		}
	}
