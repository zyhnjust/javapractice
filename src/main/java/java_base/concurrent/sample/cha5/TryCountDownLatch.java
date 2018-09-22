/**
 * 
 */
package java_base.concurrent.sample.cha5;

import java.util.concurrent.CountDownLatch;

/**
 * @author Homer
 *
 *闭锁 可以确保某些活动指导其他活动都完成后才继续执行。
 *确保某个计算在其所需要的所有资源都初始化之后才继续执行。 
 *
 *闭锁状态包括一个计数器， 计数器被初始化成为一个正数。 表示需要等待的事件数量。 
countdown 方法是递减计数器。 表示有一个事件发生了。 
await 方法
	Causes the current thread to wait until the latch has counted down to zero

代码示例是
两个所。 
第一个锁呢， 起始门， 就是说希望一起来开始执行。 在气动门等待。 
第二个锁呢， 是结束门， 每个线程做的最后一个事情就是调用结束门的countdown来减一。这可以使得主线程高效的等待所有线程都执行完成。 
所以start 那个 startDate  是1 做了即可
endDate 这个是5 所有结束才是的。 
cool

 */
public class TryCountDownLatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long time = timeTasks(5, new Player(10));
			System.out.println("time: " + time);
			// this time should be executed the last one. 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException
	{
		final CountDownLatch startDate = new CountDownLatch(1);
		final CountDownLatch endDate = new CountDownLatch(nThreads);
		
		for(int i=0; i< nThreads; i++){
			Thread t = new Thread(){
				public void run(){
					try{
						startDate.await();
						try{
							task.run();
						}finally{
							System.out.println("finally " + System.currentTimeMillis());
							endDate.countDown();
						}
					}catch(InterruptedException ignored){}
				}
			};
			t.start();
			
			//sleep 1 seconds
			Thread.sleep(1000L);
			// check start time. the time should be same. all the thread will start at same time.
			// result
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			Play10 arrived.1463750174981
//			time: 133228046
		}

		long start = System.nanoTime();
		startDate.countDown();
		endDate.await();
		long end = System.nanoTime();
		return end-start;
	}

}
