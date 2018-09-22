package javaconcurrent;

import java.util.Queue;

public class ProcessHandler implements Runnable {
	private String name; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public ProcessHandler(String name){
		this.name = name;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + name);
	}

}
