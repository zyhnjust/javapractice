/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Homer
 * This is first memory code 
 */
interface Computable<A, V>{
	V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger>{
	public BigInteger compute(String arg) throws InterruptedException{
		try {
			System.out.println(Thread.currentThread().getName() + " start execute ");
			Thread.sleep(1000L);
			System.out.println(Thread.currentThread().getName() + " executing ");
			Thread.sleep(1000L);
			System.out.println(Thread.currentThread().getName() + " end execute ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new BigInteger(arg);
	}
}

public class Memorizer1<A, V> implements Computable<A, V>{
	private final Map<A, V> cache = new HashMap<A, V>();
	private final Computable<A, V> c;
	
	public Memorizer1(Computable<A, V> c){
		this.c =c;
	}
	
	public synchronized V compute(A arg) throws InterruptedException{
		V result = cache.get(arg);
		if(result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how to test
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ExpensiveFunction func = new ExpensiveFunction();
		Memorizer1 mem = new Memorizer1(func);
		
		Thread t1 = new Thread();
		t1.start();
		// question, whether it should be static
		
		
	}
}
	

