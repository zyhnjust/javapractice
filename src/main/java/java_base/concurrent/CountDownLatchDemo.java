package java_base.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	private static int N = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch endSignal = new CountDownLatch(N);
		
		for(int i=0; i< N; i++) {
			new Thread(new Worker(startSignal, endSignal)).start();
		}
		
		System.out.println("main start");
		startSignal.countDown();
		System.out.println("main ip");
		try {
			endSignal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");		
	}
}

class Worker implements Runnable{
	
	private final CountDownLatch startSignal;
	private final CountDownLatch endSignal;
	
	Worker(CountDownLatch startSignal, CountDownLatch endSignal){
		this.startSignal = startSignal;
		this.endSignal = endSignal;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			startSignal.await();
			System.out.println(Thread.currentThread().getName() + "_start");
			doWork();
			System.out.println(Thread.currentThread().getName() + "_Done");
			endSignal.countDown();
		}catch (InterruptedException ex) {}
	}
	
	void doWork() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}



