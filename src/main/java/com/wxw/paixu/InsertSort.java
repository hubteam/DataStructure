package com.wxw.paixu;

/**
 * �����������ڲ�����������һ������������У�����һ���µļ�¼���²�����ҵ��Լ����ʵ�λ�ñ�֤������Ȼ����
 * ��ҪN-1���������
 * ʱ�临�Ӷȣ�
 * Ƕ�׵�ѭ��������0(N^2);����������ź���ģ��Ͳ������Ƕ�׵��ǲ�ѭ������ʱʱ�临�Ӷ���O(N)
 * 
 * ����
 * N���������������ƽ����������N(N-1)/4
 * ͨ����������Ԫ�ؽ����κ�Ԫ�ؽ���������κ��㷨����ҪN2ʱ��
 * @author ��ܰέ
 *
 */
public class InsertSort {

	private static void insertSort(int[] a){
		int j;
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];//Ҫ�����ֵ
			for (j = i; j > 0 && temp < a[j - 1]; j--) {//�²���λ��֮ǰ�ģ������²����λ�ý��бȽ�
				a[j] = a[j-1];//����ƶ�
			}
//			System.out.println(j);
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,7};
		insertSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
