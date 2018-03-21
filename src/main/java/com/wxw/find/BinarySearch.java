package com.wxw.find;

/**
 * 二分查找：O(logN)
 * 
 * @author 王馨苇
 *
 */
public class BinarySearch {

	public static int bSearch(int a[], int k){
		
		int left = 0;
		int right = a.length - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			
			if(a[mid] == k){
				return mid;
			}else if(a[mid] > k){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		System.out.println(bSearch(a, 6));
	}
}
