package com.wxw.paixu;

import java.util.ArrayList;

/**
 * ��������
 * �ַ�����������ļ�ʵ��
 * @author ��ܰέ
 *
 */
public class RadixSort {

	@SuppressWarnings("unchecked")
	public static void radixSort(String[] arr, int stringLen){
		//����Ͱ��
		final int BUCKETS = 256;
		ArrayList<String>[] buckets = new ArrayList[BUCKETS];
		
		//��ʼ��Ͱ
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<String>();
		}
		
		
		for (int i = stringLen - 1; i >= 0; i--) {
			//Ԫ�ط���Ԫ��
			for (String s : arr) {
				buckets[s.charAt(i)].add(s);
			}
			//Ͱ���Ԫ�س�Ͱ�� ���·�������
			int idx = 0;
			for (ArrayList<String> arrayList : buckets) {
				for (String string : arrayList) {
					arr[idx++] = string;
				}
				//Ͱ��Ԫ�����
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
