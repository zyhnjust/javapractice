package java_base.concurrent.sample.cha5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Homer
 * This is second memory code 
 * 因为第一个版本是HashMap，所以compute 的时候呢需要同步。 这样的话， 只能一个线程访问。
 * 如果耗时多的话， 效率比较地下。 
 * 第二个版本呢改成了 ConcurrentHashMap, 利用map自身来保证线程安全。 所以不需要synchronize。 
 * 
 * 
 */

public class Memorizer2<A, V> implements Computable<A, V>{
//	private final Map<A, V> cache = new HashMap<A, V>();
	private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

	private final Computable<A, V> c;
	
	public Memorizer2(Computable<A, V> c){
		this.c =c;
	}
	
	//remove synchronized 
	public V compute(A arg) throws InterruptedException{
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
	

