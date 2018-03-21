package com.wxw.paixu;

/**
 * 计数排序
 * 
 * 数组的下标小于等于该位置的元素的个数
 * 数组的内容是元素
 * @author 王馨苇
 *
 */
public class CountSort {

	public void countSort(int[] a, int[] b, int n){
		int count;
		for (int i = 0; i < n; i++) {
			
			count = 0;
			for (int j = 0; j < n; j++) {
				if(a[j] < a[i]){
					count++;
				}
			}
			b[count] = a[i];
		}
	}
}
