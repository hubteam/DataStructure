package com.wxw.paixu;

/**
 * �鲢���򣺹鲢������򣬾��ǽ����������������������кϲ���һ�� �µ����������
 * ʱ�临�Ӷȣ������ã�ƽ������O(NlogN)
 * ����������
 * 1������㷨�Ļ��������Ǻϲ������Ѿ�����ı���Ϊ�����������Ѿ�����ģ�������������Ľ���ŵ����������У����㷨����ͨ�����������ݽ���һ����������ɡ�
 * 2�������ĺϲ������ǣ�ȡ������������A��B��һ���������C���Լ����������������ǳ�ʼλ�ö�Ӧ����Ŀ�ʼ�ˣ���A[I] B[J]�н�С�Ŀ�����C�У���ؼ�������ǰ�ƽ�һ����
 * ��A B����һ�������ʱ���򽫱���ʣ�ಿ�ֿ�����C��
 * 
 * ���÷��εĲ��ԣ�
 * 1���֣�������ֳ�һЩС�����⣬Ȼ��ݹ����
 * 2���Σ����ֵĽ׶εõ��Ĵ��޲���һ��
 * 
 * ���ƹ�ʽ��T(1) = 1 ����N=1ʱ�򣬹鲢����ʱ���ǳ���
 *        T(N) = 2T(N/2) + N ����N�����鲢������ʱ�������������СΪN/2�ĵݹ��������õ�ʱ����Ϻϲ���ʱ��
 *        
 * �����ǣ��ϲ������Ѿ�����ı��õ������Ը����ڴ棬�������㷨��������л�Ҫ���ѽ����鿽������ʱ�����ڿ�����������һЩ���ӹ����������������ٶ�
 * 
 * �鲢�������������е������㷨�����ٵıȽϴ�������ʹ��java��ͨ�������㷨�кõ�ѡ����java��ⷺ��������ʹ�õ�����
 * @author ��ܰέ
 *
 */
public class MergeSort {

	private static void mergeSort(int[] a, int[] temp, int left, int right){
		
		if(left < right){
			
			int center = (left + right) / 2;
			mergeSort(a, temp, left, center);//�����󲿷�
			//ע��������center+1
			mergeSort(a, temp, center + 1, right);//�����Ҳ���
			//�ϲ�
			merge(a, temp, left, center + 1, right);
		}
	}
	
	public static void mergeSort(int[] a){
		
		int[] temp = new int[a.length];
		mergeSort(a, temp, 0, a.length - 1);
	}
	
	/**
	 * 
	 * @param a ��������
	 * @param temp �������
	 * @param leftpos ��������
	 * @param rightpos �ڶ�����������
	 * @param rightend ���鳤��
	 */
	private static void merge(int[] a, int[] temp, int leftpos, int rightpos, int rightend){
		
		int leftend = rightpos - 1;
		int temppos = leftpos;//ע��������Ǵ洢��������±�
//		int num = rightend - leftpos + 1;
		int templeftpos = leftpos;
		
		while(leftpos <= leftend && rightpos <= rightend){
			if(a[leftpos] <= a[rightpos]){
				temp[temppos++] = a[leftpos++];
			}else{
				temp[temppos++] = a[rightpos++];
			}
		}
		
		//����һ������û�б������ʱ��
		while(leftpos <= leftend){
			temp[temppos++] = a[leftpos++];
		}
		while(rightpos <= rightend){
			temp[temppos++] = a[rightpos++];
		}
		
		//������õ�����copy��ȥ
//		for (int i = 0; i < num; i++, rightend--) {
//			a[rightend] = temp[rightend];
//		}
		
		for (int i = templeftpos; i <= rightend; i++) {
			a[i] = temp[i];
		}
	}
	

	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,7};
		mergeSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
