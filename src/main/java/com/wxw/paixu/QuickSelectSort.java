package com.wxw.paixu;

/**
 * 修改快速排序解决选择问题
 * 
 * 问题描述：查找集合S中第K个最小元的算法
 * 步骤：
 * 1、|S|=1,那么K=1将S中所有元素返回
 * 2、选择枢纽V
 * 3、将集合S-V，分割成两部分S1  S2
 * 4、如果K <= |S1|那么答案在S1中，返回quickSort(S1,K)
 *   如果K = 1 + |S1|那么答案在枢纽，
 *   否则答案在S2中，是S2中的K - |S1| - 1位置最小元，返回quickSort(S2,K - |S1| - 1)
 *   
 * 时间复杂度：最坏：O（N2）
 *         平均：O(N)
 * @author 王馨苇
 *
 */
public class QuickSelectSort {

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
	
	public static void find(int[] arr, int left, int right, int k){
		int i = divide(arr, left, right);
		while(k != i){
			if(k < i){
				i = divide(arr, left, i - 1);
			}else{
				i = divide(arr, i + 1, right);
			}
		}

		System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,8,7,0,11};
		find(a, 0, a.length - 1, 3);
	}
}
