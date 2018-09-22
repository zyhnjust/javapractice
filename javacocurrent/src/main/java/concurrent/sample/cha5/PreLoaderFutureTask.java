/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Homer
 *
 */
public class PreLoaderFutureTask {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		start();

		System.out.println("start get");
		get();
		System.out.println("end get");

	}
	
	private static final FutureTask<ProductInfo> future =
			new FutureTask<ProductInfo> (new Callable<ProductInfo>(){
				public ProductInfo call(){
					
					return loadProductInfo();
					
				}

				private ProductInfo loadProductInfo() {
					// TODO Auto-generated method stub
					System.out.println("loading data from db");
					try {
						Thread.sleep(3000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return new ProductInfo("dbProduct");
				}
				
	});

	private static Thread t1 = new Thread(future);
	public static void start(){
		t1.start();
	}
	
	public static ProductInfo get() throws Exception{
		
		try {
			return future.get();
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			
			// In fact, here should handle it by different exception type. 
			if(cause instanceof Exception)
				throw (Exception)cause;
			else
				throw (Exception)cause;
		}
		
	}
}
