package design;


//同步校驗鎖 這個是可以的 
public class Singleton4 {

	private volatile static Singleton4 singleton;
	
	private Singleton4(){}
	
	public static Singleton4 getInstance(){
		if(singleton==null){
			synchronized(Singleton4.class){
				if(singleton == null){
					singleton = new Singleton4();
				}
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
