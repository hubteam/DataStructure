package com.wxw.paixu;

/**
 * ˫��ð������:����������н���ı�ɨ�跽��
 * �ȴӵ����ϴ�������ð��һ����С��Ԫ�أ��ڴ�����״�������ð������һ��Ԫ��
 * @author ��ܰέ
 *
 */
public class ShuangxiangBubbleSort {

	public void bubble(int[] a){
		int left = 0;
		int right = a.length - 1;
		boolean flag = true;
		
		while(flag){
			flag = false;
			
			//��ǰ������ķ�����
			for (int i = left; i < right - 1; i++) {
				if(a[i] < a[i+1]){
					swap(a, i, i+1);
					flag = true;
				}
			}
			--right;
			
			//�Ӻ���ǰ����С�ķ����
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
