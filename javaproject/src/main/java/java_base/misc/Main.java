package java_base.misc;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	private static String fileName = "./test.csv";
	private static Queue queue = new LinkedList<String>();
	
	public void prepareData(String fileName) throws IOException{
		ProcessExcel pro= new ProcessExcel();
		queue = pro.readcsv(fileName);
	}
	
	public void handleData(){
		ExecutorService service = Executors.newFixedThreadPool(5);
		while(!queue.isEmpty()){
			String name = queue.poll().toString();
			ProcessHandler handler = new ProcessHandler(name);
			service.submit(handler);
		}
	}
	
	public void printData(){
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		try {
			main.prepareData(fileName);
			main.handleData();
//			main.printData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
