package java_base.concurrent.sample.cha5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Homer
 * This is second memory code 
 * 因为第一个版本是HashMap，所以compute 的时候呢需要同步。 这样的话， 只能一个线程访问。
 * 如果耗时多的话， 效率比较地下。 
 * 第二个版本呢改成了 ConcurrentHashMap, 利用map自身来保证线程安全。 所以不需要synchronize。 
 * 
 * 这个版本虽然有着更好的并发性能， 但是作为缓存仍有不足。 两个线程同时进行计算的时候， 每个都会去计算。 事实上有一个计算就足够了。 另外一个只需要等待前一个计算的记过就可以了。 
 * 另外， 如果只是提供单次初始化的对象缓存， 这个可能会导致计算两次，带来安全风险。 
 * 
 * 第三个版本实现在线程调用的时候， 如果已经有一个计算在进行， 这个线程就会等待， 查询到结果之后返回， 而不是自己再计算一遍。 使用FutureTask 
 * 
 * 这个实现比较优秀， 因为它有着比较好的并发性。 
 * 如果结果已经计算出来， 那么将立即返回。 如果其他线程在计算该结果， 那么新的线程会等待直到结果算出来。
 * 
 * 这个版本仍然有个小问题， 就是说 if 里面仍然不是原子的， 有可能put 两次， 两个地方同时计算。 
 * 
 * 第四个版本， 这个版本会判断是否已经存在再替换， 这个地方使用自身的putifabsent 这个操作是线程安全的。 
 * 
 * 另外的问题
 * 1） 缓存的是future 而不是value， 可能导致缓存污染--》 如果某个计算被取消啥的， 里面就得不到之了。 这个时候需要把future 移除。 
 * 2） 如果runtimeexception 也应该移除。 
 * 3） 缓存逾期的问题。 futuretask 子类加一个时间。 
 * 
 * 
 * TODO list
 * 1） 写个程序来用它。  博客
 * 2） 然后呢关于上面的问题如何实现， 真正的缓存是如何做的。 
 * 
 * 
 */

public class Memorizer4<A, V> implements Computable<A, V>{
//	private final Map<A, V> cache = new HashMap<A, V>();
	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	private final Computable<A, V> c;
	
	public Memorizer4(Computable<A, V> c){
		this.c =c;
	}
	
	//remove synchronized 
	//note, here A　must is final
	public V compute(final A arg) throws InterruptedException{
		Future<V> result = cache.get(arg);
		
		if(result == null){
			Callable cal = new Callable<V>(){
				public V call()throws InterruptedException {
					return c.compute(arg);
				}
			};
			FutureTask<V> ft = new FutureTask<V>(cal);
			result = cache.putIfAbsent(arg, ft);
			if(result == null){
				result = ft;
				ft.run();// here will compute 				
			}
		}

		try {
			return result.get();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw launderThroable(e.getCause());
		}
		return null;
		
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
	

