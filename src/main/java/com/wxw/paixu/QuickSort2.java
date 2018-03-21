package com.wxw.paixu;

public class QuickSort2 {

	private static void quickSortByMid3(int[] arr, int left, int right) {
		if(left > right)
			return;
		else {
			int base = partitionMid3(arr, left, right);
			quickSortByMid3(arr, left, base - 1);
			quickSortByMid3(arr, base + 1, right);
		}
	}	
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,8,7,0,11};
		
		quickSortByMid3(a, 0 , a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	private static int partitionMid3(int[] arr, int left, int right) {
		if(left < right) {
//			mid3ToRight(arr, left, right);
			int i = left;
			int j = right;
			int key = arr[j];
			while(i < j) {
				while(i < j && arr[i] < key)
					i++;
		            
				if(i < j) {
					arr[j] = arr[i];
					j--;
				}
					
				
				while(i < j && arr[j] > key) 
					j--;
		            
				if(i < j) {
					arr[i] = arr[j];
					i++;					
				}
					
			}
			
			arr[j] = key;
			return j;
		}
		
		return right;
	}
}
