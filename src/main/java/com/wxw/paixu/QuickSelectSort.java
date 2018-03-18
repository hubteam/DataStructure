package com.wxw.paixu;

/**
 * �޸Ŀ���������ѡ������
 * 
 * �������������Ҽ���S�е�K����СԪ���㷨
 * ���裺
 * 1��|S|=1,��ôK=1��S������Ԫ�ط���
 * 2��ѡ����ŦV
 * 3��������S-V���ָ��������S1  S2
 * 4�����K <= |S1|��ô����S1�У�����quickSort(S1,K)
 *   ���K = 1 + |S1|��ô������Ŧ��
 *   �������S2�У���S2�е�K - |S1| - 1λ����СԪ������quickSort(S2,K - |S1| - 1)
 *   
 * ʱ�临�Ӷȣ����O��N2��
 *         ƽ����O(N)
 * @author ��ܰέ
 *
 */
public class QuickSelectSort {

	private static int divide(int[] arr, int left, int right){
		int temp = arr[right];
		
		while(left < right){
			
			while(left < right && temp > arr[left]){
				left++;
			}
			if(left < right){
				arr[right] = arr[left];
				arr[left] = temp;
				right--;
			}
			
			while(left < right && temp < arr[right]){
				right--;
			}
			if(left < right){
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
			}
		}
		return right;
	}
	
	public static void find(int[] arr, int left, int right, int k){
		int i = divide(arr, left, right);
		while(k != i){
			if(k < i){
				i = divide(arr, left, i - 1);
			}else{
				i = divide(arr, i + 1, right);
			}
		}

		System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,8,7,0,11};
		find(a, 0, a.length - 1, 3);
	}
}
