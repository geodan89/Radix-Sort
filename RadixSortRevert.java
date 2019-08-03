package radixsort;

import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSortRevert {

	public static int getMaxNumber(int[] array) {
		int max=array[0]; 
		for(int i=1;i<array.length;i++){ 
			if(array[i]>max){ 
				max=array[i]; 
			} 
		}
		System.out.println(max);
		return max;
	}
	
	public static int count(int m) {
		int counter = 0;
		while(m>0) {
			m/=10;
			counter++;
		}
		System.out.println(counter);
		return counter;
	}
	
	public static void print(int[] array) {
		for(int i = 0 ; i <array.length ; i ++){
			System.out.print(array[i] + " ");
		}
	}

	public static int[] radixSortRevert(int[] array){ 
		Queue<Integer>[] queue=new Queue[10]; 
		for(int i=0;i<10;i++){ 
			queue[i]=new ArrayDeque<Integer>(); 
		} 
		int max = getMaxNumber(array);
		int digitNumber = count(max);
		for(int i=0;i<digitNumber;i++){ 
			for(int j=0;j<array.length;j++){  
			queue[array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i)].offer(array[j]); 
			} 
			int n=0;
			for(int k=9;k>=0;k--){ 
				while(queue[k].size()>0){ 
					array[n]=(Integer) queue[k].poll(); 
					n++; 
				} 
			} 
		}
		return array;
	}
	public static void main(String[] args) {
		int[] arr={1000,4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		int max = getMaxNumber(arr);
		int counter = count(max);
		int[] array = radixSortRevert(arr);
		print(array);
	}
}
