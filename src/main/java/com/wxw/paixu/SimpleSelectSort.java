package com.wxw.paixu;

/**
 * 简单选择：选择类，从头至尾扫描序列，找出最小的一个记录，和第一个记录交换，接着从剩下的记录中继续这种选择和交换
 * 时间复杂度 O(N2)
 * @author 王馨苇
 *
 */
public class SimpleSelectSort {

	public static void selectSort(int[] a){
		int i, j, k;
		int temp;
		
		for (i = 0; i < a.length; i++) {
			
			k = i;
			for (j = i + 1; j < a.length; j++) {
				if(a[k] > a[j]){
					k = j;
				}
			}
			
			temp = a[i];
			a[i] = a[k];
			a[k] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,7};
		selectSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
