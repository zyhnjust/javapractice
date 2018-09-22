package concurrent;

public class NoVisibility {

	
//	private volatile static boolean ready;
//	private volatile static int number;
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready)
				System.out.println(ready);
				Thread.yield();
//			System.out.println("number");
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReaderThread().start();
		number=42;
		ready=true;
	}

}
