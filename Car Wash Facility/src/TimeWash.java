public class TimeWash {

	public static void timeWash(long tw) {
		try { Thread.sleep(tw);}
		catch(InterruptedException e) {}
	}
}
