package concurrent;

import java.util.Vector;

import concurrent.ThreadLocalExample.MyRunnable;

//# sometime, it will return 
//		Thread-0finished
//		Thread-2finished
//		Thread-3finished
//		Thread-1finished
//# sometimes, it will return exception
//java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 8
//Thread-9finished
//	at java.util.Vector.remove(Vector.java:834)
//	at concurrent.VectorFailure.deleteLast(VectorFailure.java:59)
//	at concurrent.VectorFailure$MyRunnable.run(VectorFailure.java:26)
//	at java.lang.Thread.run(Thread.java:748)

public class VectorFailure {
	static Vector v = new Vector();

    public static class MyRunnable implements Runnable {
        public void run() {
    		getLast(v);
    		deleteLast(v);
    		System.out.println(Thread.currentThread().getName() + "finished");
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
        MyRunnable sharedRunnableInstance = new MyRunnable();
        for (int i = 0; i< 10; i++){
        	Thread thread1 = new Thread(sharedRunnableInstance);
            thread1.start();
        }
	}

//	public static Object getLast(Vector list){
//		int lastIndex = list.size()-1;
//		return list.get(lastIndex);
//	}
//	
//	public static void deleteLast(Vector list){
//		int lastIndex = list.size()-1;
//		list.remove(lastIndex);
//	}
	public static Object getLast(Vector list){
		synchronized(list){
			int lastIndex = list.size()-1;
			return list.get(lastIndex);			
		}
	}
	
	public static void deleteLast(Vector list){
		synchronized(list){
			int lastIndex = list.size()-1;
			list.remove(lastIndex);			
		}
	}
}
