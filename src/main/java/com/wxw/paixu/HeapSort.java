package com.wxw.paixu;

/**
 * ������ѡ�������򣬼�ÿһ��ѡ��һ����С�����ļ�¼�������������еĵ�һ�������һ����¼������������������С�ļ�¼��λ
 * �������ִ�й��̣�
 * 1��������������ȷ������ȫ�������ĵ�һ����Ҷ�ӽڵ㿪ʼ���������󣬴������ϣ���ÿ���ڵ���е��������յõ������
 * 2������ǰ���������еĵ�һ��Ԫ�غ����һ��Ԫ�ؽ������������м���һ��Ԫ�أ�������������һ��Ԫ��
 * 3���ظ�ֱ������������ʣ��һ��Ԫ��ʱ��ֹͣ
 * 
 * O(NlogN)
 * @author ��ܰέ
 *
 */
public class HeapSort {
	
	//������ڵ�
	private static int leftChild(int i){
		return 2 * i + 1;
	}
	
	private static void percDown(int[] a, int i, int n){
		int child = 0;
		int temp;
		for (temp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			
			if(child != n - 1 && a[child] < a[child + 1]){//����ҽڵ�Ƚϴ�
				child++;//ָ���ҽڵ�
			}
			
			if(temp < a[child]){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = temp;
	}

	private static void swapReference(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void heapSort(int[] a){
		for (int i = a.length / 2; i >= 0; i--) {//����2N�αȽ�
			percDown(a, i, a.length);
		}
		
		for (int i = a.length - 1; i > 0; i--) {//ɾ�������2logi�Ƚ�
			swapReference(a, 0, i);
			percDown(a, 0, i);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,7};
		heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
