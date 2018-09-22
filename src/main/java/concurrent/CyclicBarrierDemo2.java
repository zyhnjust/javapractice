package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=4;
		CyclicBarrier barrier = new CyclicBarrier(N);
		
		for(int i=0; i<N; i++){
			new Writer(barrier).start();
		}
		
	}

	static class Writer extends Thread{
		private CyclicBarrier cyclicBarrier;
		public Writer(CyclicBarrier cyclicBarrier){
			this.cyclicBarrier = cyclicBarrier;
		}
		
		public void run(){
			System.out.println(Thread.currentThread().getName() + " write data");
			
			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + "write down, wait for else");
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
