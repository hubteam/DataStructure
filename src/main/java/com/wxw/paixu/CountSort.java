package com.wxw.paixu;

/**
 * ��������
 * 
 * ������±�С�ڵ��ڸ�λ�õ�Ԫ�صĸ���
 * �����������Ԫ��
 * @author ��ܰέ
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
