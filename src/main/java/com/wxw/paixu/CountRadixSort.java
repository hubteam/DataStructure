package com.wxw.paixu;

/**
 * �����������򣺲��ñȽϣ���Ҫռ�ô����ռ䣬���������ݱȽϼ��е����
 * ����˼�룺��ÿһ�������Ԫ��Arr[i]��ȷ��С��arr[i]�ĸ�������żһ����ֱ�Ӱ�arr[i]�ŵ�����������е�λ����
 * @author ��ܰέ
 *
 */
public class CountRadixSort {

	public static void countRadixSort(String[] arr, int stringLen){
		final int BUCKET = 256;
		
		
		
		for (int i = stringLen - 1; i >= 0; i--) {
			int[] count = new int[BUCKET + 1];//��¼Ͱ��Ԫ�صĸ���
			
			//ͳ��Ͱ�е�Ԫ�ظ���
			for (int j = 0; j < arr.length; j++) {
				count[arr[j].charAt(i) + 1]++;
			}
			//ͳ��Ͱj��С�ڵ���j��Ԫ�صĸ���
			for (int j = 1; j <= BUCKET; j++) {
				count[j] += count[j - 1];
			}
			
			String[] out = new String[arr.length];
			for (int j = 0; j < out.length; j++) {
				//����ļӼ���Ϊ���ظ�����ͬһ��Ͱ�еģ�����һ������һ��Ҫ�����ĺ���
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
