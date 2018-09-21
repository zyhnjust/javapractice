package algo.ds.sort;

import java.util.ArrayList;

// first version
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList arr = new ArrayList();
		arr.add(6);
		arr.add(2);
		arr.add(4);
		arr.add(9);
		arr.add(10);
		arr.add(5);
		System.out.println(arr);
		ArrayList arr2 = doBubbleSort(arr);
		System.out.println(arr2);
	}

	private static ArrayList doBubbleSort(ArrayList arr) {
		// TODO Auto-generated method stub
		int length = arr.size();
		for(int i=0; i< length-1; i++){
//			for(int j=0; j < length-i; j++){ // need minus 1? 
			for(int j=0; j < length-i-1; j++){

				int value_j = (int)arr.get(j);
				int value_j2 = (int)arr.get(j+1);
				if (value_j > value_j2){
					int tmp = value_j;
					arr.set(j, value_j2);
					arr.set(j+1, tmp);
				}
			}
		}
		return arr;
	}

}
