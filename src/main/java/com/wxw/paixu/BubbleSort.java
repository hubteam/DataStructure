package com.wxw.paixu;

/**
 * ð������
 * ���O(N2)
 * ��ã�O(N)
 * ƽ����O(N2)
 * @author ��ܰέ
 *
 */
public class BubbleSort {
	
	private static void bubbleSort(int[] a){
		boolean flag;
		for (int i = 0; i < a.length - 1; i++) {
			flag = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if(a[j+1] < a[j]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = true;
				}
			}
			if(flag == false){
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,8,7,0};
		
		bubbleSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
