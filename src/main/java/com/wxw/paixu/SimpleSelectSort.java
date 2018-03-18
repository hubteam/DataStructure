package com.wxw.paixu;

/**
 * ��ѡ��ѡ���࣬��ͷ��βɨ�����У��ҳ���С��һ����¼���͵�һ����¼���������Ŵ�ʣ�µļ�¼�м�������ѡ��ͽ���
 * ʱ�临�Ӷ� O(N2)
 * @author ��ܰέ
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
