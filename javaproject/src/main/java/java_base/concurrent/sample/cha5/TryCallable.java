/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Homer
 *
 */
public class TryCallable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		// Creates a thread pool that creates new threads as needed, but
//	     * will reuse previously constructed threads when they are
//	     * available.  
		
		Task task = new Task();
		Future<Integer> result = executor.submit(task);
		
		//why this; comment or not will not block. 
		executor.shutdown();
//		Initiates an orderly shutdown in which previously submitted
//	     * tasks are executed, but no new tasks will be accepted.
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main thread is running. ");
		
		try {
			System.out.println("The result form child task: " + result.get());
//		     * Waits if necessary for the computation to complete, and then
//		     * retrieves its result.
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All thread finished. ");
	}
	

}


class Task implements Callable<Integer>{

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		System.out.println("Child task is started.");
		Thread.sleep(3000L);
		System.out.println("Child task is finished.");

		return 10;
	}
	
	
}


