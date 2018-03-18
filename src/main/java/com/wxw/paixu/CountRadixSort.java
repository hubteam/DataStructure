package com.wxw.paixu;

/**
 * 计数基数排序：不用比较，需要占用大量空间，适用于数据比较集中的情况
 * 基本思想：对每一个输入的元素Arr[i]，确定小于arr[i]的个数，搜偶一可以直接把arr[i]放到它输出数组中的位置上
 * @author 王馨苇
 *
 */
public class CountRadixSort {

	public static void countRadixSort(String[] arr, int stringLen){
		final int BUCKET = 256;
		
		
		
		for (int i = stringLen - 1; i >= 0; i--) {
			int[] count = new int[BUCKET + 1];//记录桶中元素的个数
			
			//统计桶中的元素个数
			for (int j = 0; j < arr.length; j++) {
				count[arr[j].charAt(i) + 1]++;
			}
			//统计桶j中小于等于j的元素的个数
			for (int j = 1; j <= BUCKET; j++) {
				count[j] += count[j - 1];
			}
			
			String[] out = new String[arr.length];
			for (int j = 0; j < out.length; j++) {
				//这里的加加是为了重复，在同一个桶中的，出来一个后，下一个要在他的后面
				out[count[arr[j].charAt(i)]++] = arr[j];
			}
			
			for (int j = 0; j < out.length; j++) {
				arr[j] = out[j];
			}
		}
		
	}
	
	public static void main(String[] args) {
		String[] arr = {"wer","dgs","dsa","bgt","hyd","jyw","abc","120","231"};
		countRadixSort(arr, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
