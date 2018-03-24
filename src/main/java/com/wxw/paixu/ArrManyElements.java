package com.wxw.paixu;

/**
 * 一个数组中出现次数最多的那个元素
 * @author 王馨苇
 *
 */
public class ArrManyElements {

	private static int divide(int[] arr, int left, int right){
		int temp = arr[right];
		
		while(left < right){
			
			while(left < right && temp > arr[left]){
				left++;
			}
			if(left < right){
				arr[right] = arr[left];
				arr[left] = temp;
				right--;
			}
			
			while(left < right && temp < arr[right]){
				right--;
			}
			if(left < right){
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
			}
		}
		
		return right;
	}
	
	public static void find(int[] arr, int left, int right){
		int i = divide(arr, left, right);
		int mid = arr.length / 2;
		while(mid != i){
			if(mid < i){
				i = divide(arr, left, i - 1);
			}else{
				i = divide(arr, i + 1, right);
			}
		}

		System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,1,2,5,3,4,2,2,2,3,2,1,2,2,6,2};
		find(a, 0, a.length - 1);
	}
}
