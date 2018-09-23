package design;

//£¨¶öºº£©£º
public class Singleton1 {
	
	private static Singleton1 instance = new Singleton1();
	public static Singleton1 getInstance(){
		return instance;
	}
	public static void Singleton1(){
	}
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
	}

}
