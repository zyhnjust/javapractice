package java_base.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	private static CyclicBarrier barrier = new CyclicBarrier(6, ()->{
		System.out.println("athethes are there, start");
	}); //简洁 就是一个runnable， 里面打印一下。 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Atheletes are ready to go ");
		
		ExecutorService service = Executors.newFixedThreadPool(6);
		for(int i=0; i< 6; i++){
			service.execute( ()  -> {
				try{
					System.out.println(Thread.currentThread().getName() + " Athelete in");
					barrier.await();
					System.out.println(Thread.currentThread().getName() + " athelete start");
				}catch (Exception e){
					e.printStackTrace();
				}
			});
		}
		
	}

}
