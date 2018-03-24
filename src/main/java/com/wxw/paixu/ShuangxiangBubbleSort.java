package com.wxw.paixu;

/**
 * 双向冒泡排序:在排序过程中交替改变扫描方向
 * 先从底向上从无序区冒了一个最小的元素，在从上向底从无序区冒出最大的一个元素
 * @author 王馨苇
 *
 */
public class ShuangxiangBubbleSort {

	public void bubble(int[] a){
		int left = 0;
		int right = a.length - 1;
		boolean flag = true;
		
		while(flag){
			flag = false;
			
			//从前向后，最大的放右面
			for (int i = left; i < right - 1; i++) {
				if(a[i] < a[i+1]){
					swap(a, i, i+1);
					flag = true;
				}
			}
			--right;
			
			//从后向前，最小的放左边
			for (int i = right; i > left; i--) {
				if(a[i] < a[i-1]){
					swap(a, i, i-1);
					flag = true;
				}
			}
			++left;
		}
	}
	
	private void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
