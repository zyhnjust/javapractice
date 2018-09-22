package javaconcurrent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ProcessExcel {
	
	public Queue<String> readcsv(String fileName) throws IOException{
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
        Queue<String> queue = new LinkedList<String>();
        int i = 0;
		for (CSVRecord record : records) {
//		    System.out.println(record);
		    String name = record.get(0);
		    String type = record.get(1);
			queue.offer(i+ "-" + name);
			i++;
//		    System.out.println(lastName);
//		    System.out.println(firstName);
		}
	    System.out.println("Queue is ready. Count for records  is: " + queue.size());

		return queue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ProcessExcel().readcsv("./test.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
