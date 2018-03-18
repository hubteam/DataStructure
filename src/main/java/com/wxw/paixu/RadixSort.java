package com.wxw.paixu;

import java.util.ArrayList;

/**
 * 基数排序：
 * 字符串基数排序的简单实现
 * @author 王馨苇
 *
 */
public class RadixSort {

	@SuppressWarnings("unchecked")
	public static void radixSort(String[] arr, int stringLen){
		//定义桶数
		final int BUCKETS = 256;
		ArrayList<String>[] buckets = new ArrayList[BUCKETS];
		
		//初始化桶
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<String>();
		}
		
		
		for (int i = stringLen - 1; i >= 0; i--) {
			//元素放入元素
			for (String s : arr) {
				buckets[s.charAt(i)].add(s);
			}
			//桶里的元素出桶， 重新放入数组
			int idx = 0;
			for (ArrayList<String> arrayList : buckets) {
				for (String string : arrayList) {
					arr[idx++] = string;
				}
				//桶里元素清空
				arrayList.clear();
			}
		}
	}
	
	public static void main(String[] args) {
		String[] arr = {"wer","dgs","dsa","bgt","hyd","jyw"};
		radixSort(arr, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
