package com.wxw.paixu;

/**
 * ϣ�����򣺲���������
 * �ֽ���С��������ͨ���Ƚ����һ�������Ԫ�������������˱Ƚ����õľ��������㷨�Ľ��ж���С��ֱ���Ƚ�����Ԫ�ص����һ������Ϊֹ��
 * ע�⣺���һ������һ����1��
 * �䱾�ʻ��ǲ��������Խ�����������а���ĳ�ֹ���ָ�������ֳɼ��������У��ֱ���⼸�������н��в�������
 * 
 * ϣ�����������ʱ���������������е�ѡ��
 * ʹ��ϣ������ʱϣ�����������������O(N2)
 * @author ��ܰέ
 *
 */
public class ShellSort {

	//��ʱ�������������У�Ht=N/2 Hk=H(k+1) / 2
	public static void shellSort(int[] a){
		int j;
		
		for (int gap = a.length / 2; gap > 0; gap /= 2) {//�����ı仯
			
			//����֮ǰ���൱�����Ѿ��ź��������
			//�൱�ڼ򵥲���������0��λ��
			for (int i = gap; i < a.length; i++) {
				
				int temp = a[i];
				//j >= gap �൱��ֱ�Ӳ��������е�j > 0
				for (j = i; j >= gap && temp < a[j - gap]; j -= gap) {
					a[j] = a[j - gap];
				}
				
				a[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,7};
		shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
