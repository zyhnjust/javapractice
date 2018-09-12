package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCallable call = new MyCallable(1000);
		FutureTask<String> futureTask= new FutureTask<String>(call);
		
		MyCallable call2 = new MyCallable(2000);
		FutureTask<String> futureTask2= new FutureTask<String>(call2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask);
		executor.execute(futureTask2);
		
		while(true) {
			try {
				if(futureTask.isDone() && futureTask2.isDone() ) {
					System.out.println("All are done!");
					executor.shutdown();
					return;
				}
				if(futureTask.isDone()) {
					System.out.println("featuretask 1 output= " + futureTask.get());
					System.out.println("wait for futuretask2");
				}
				if(futureTask2.isDone()) {
					System.out.println("featuretask 2 output= " + futureTask2.get());
					System.out.println("wait for futuretask1");
				}
			}catch(Exception e) {
				
			}
			
		}
		
	}

}

class MyCallable implements Callable{

	private int waitTime;
	
	public MyCallable(int timeMillis) {
		this.waitTime=timeMillis;
	}
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "call");
		return Thread.currentThread().getName();
	}
}
