package design;

// 這個是有效率問題的。 
public class Singleton2 {
	
	private static Singleton2 instance;
	public static Singleton2 getInstance(){
		if(instance==null){
			instance = new Singleton2();
		}
		return instance;
	}
	public static void Singleton2(){
		System.out.println("init");
	}

	public void getString(){
		System.out.println("init print");
	
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton2 s1 = Singleton2.getInstance();
		s1.getString();
	}

}
