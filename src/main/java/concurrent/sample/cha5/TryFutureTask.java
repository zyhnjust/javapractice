/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Homer
 *
 * the first get is time-used. 
 * The second one will be immediately. So it store the result. 
 */
public class TryFutureTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		func();
	}

	/**
	 * 
	 */
	private static void func() {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>(){
			public Integer call() throws Exception{
				System.out.println("Start time: " + System.currentTimeMillis());
				Thread.sleep(1000L);

				int sum=0;
				for(int i=0; i<100; i++){
					sum=sum+i;
				}
				System.out.println("end time: " + System.currentTimeMillis());
				return sum;
			}
			
		});
		
		executor.execute(task);

		System.out.println("Main thread is running: ");
        long begin = new Date().getTime();  
        System.out.println("begin" + begin);  

		try {
			System.out.println("result is: " + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("end  " + (new Date().getTime() - begin));  		
		System.out.println("Main thread is running 2: ");
		
		begin = new Date().getTime();  
        System.out.println("begin" + begin);  
		try {
			System.out.println("result is: " + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
        System.out.println("end  " + (new Date().getTime() - begin));  
		executor.shutdown();
		
	}

}
