package com.wxw.paixu;

import java.util.ArrayList;
import java.util.List;

/**
 * �������򣺽�����������C++��java���������������ر�����
 * ƽ��ʱ�䣺O(NlogN)�����㷨֮�����ر������Ϊ�ǳ������͸����Ż����ڲ�ѭ��
 * ���O(N2)
 * Ҳ��һ�ַ��εݹ��㷨
 * 
 * ���裺
 * 1.�������S��Ԫ�ظ�����0��1���򷵻�
 * 2.S������ѡһ��Ԫ��V����Ϊ��ŦԪ
 *   һ�ִ����ѡ��ѡ���һ�����������������ģ����Խ��ܣ��������ʱԤ��������Ƿ���ģ��������ʵķָ��Ϊ����Ԫ�ز�����S1������S2����������ᷢ�������еݹ���
 *              ʵ���ϵ�һ��Ԫ��������ŦԪ����������ʱԤ������ģ���ô�������򻨷ѵ�ʱ���Ƕ��εģ���ʵ����ɶҲû��
 *   һ�ְ�ȫ�����������
 *   ������ֵ�ָ��һ��N��������ֵ���ǵ�N/2������������ŦԪ����õ�Ԫ�ص���ֵ�����������Ӱ���ٶ�
 *              ���ѡ�������������ǵ���ֵ��Ϊ��Ŧ����һ���������ѡ�����ң�������Ԫ�ص���ֵ
 *              
 * 3����S-V����Ϊ����еļ��ϣ�S1 S2
 *    �ָ���ԣ�����ŦԪ�����Ԫ�ؽ�����ʹ����ŦԪ�뿪Ҫ���ָ�����ݶΡ�
 *           I�ӵ�һ��Ԫ�ؿ�ʼ��J�ӵ����ڶ���Ԫ�ؿ�ʼ
 *    ע�⣺��������ŦԪ��ȵ�Ԫ�ص�ʱ��I J��ֹͣ�������Ԫ�ؼ���ж�ν���
 * 4������quicksort(S1) v QUICKSORT(S2)
 * 
 * ע�⣺����N<=20��С���飬���ٲ�����룬��Ϊ�����ǵݹ��
 * 
 * ��������Ϊʲô��죺ѡ��һ����׼�������С�ڻ�׼�ģ��ұ��Ǵ��ڻ�׼�ģ�������ʱ�̿�ʼ��С�ڻ�׼��������Ҳû�л���ʹ��ڻ�׼�������бȽ���
 * 
 * ʱ�临�Ӷȣ����O(N2)
 *         ��ã�O(NlogN)
 *         ƽ����O(NlogN)
 * @author ��ܰέ
 *
 */
public class QuickSort {

	//ʵ�ּ򵥵ĵݹ�����
	//�ǿ�������Ļ��������ǻ����������б�
	public static void sort(List<Integer> items){
		
		List<Integer> smaller = new ArrayList<Integer>();
		List<Integer> same = new ArrayList<Integer>();
		List<Integer> lager = new ArrayList<Integer>();
		
		//ȡ�м���
		Integer chosenItem = items.get(items.size() / 2);
		for (Integer item : items) {
			if(item < chosenItem){
				smaller.add(item);
			}else if(item > chosenItem){
				lager.add(item);
			}else{
				same.add(item);
			}
		}
		
		//�ݹ�
		sort(smaller);
		sort(lager);
		
		items.clear();
		items.addAll(smaller);
		items.addAll(same);
		items.addAll(lager);
	}
	
	//ѡȡ��ŦԪ,��ѡ�������ֵ��м�һ������
	//�����ĺô���
	//1������Ԫ���е���С�����ֱ�����������ң���Ҳ�Ƿָ�׶���Ҫ�����ŵ��ĺ��ʵ�λ�ã��������ǽ���Ŧ����right-1��λ����ȥ
	//  ����I J��λ�÷ֱ�ָ��left+1����right-2��λ����ȥ
//	private static int median3(int[] arr, int left, int right){
//		
//		int center = (left + right) / 2;
//		int a = arr[left], b = arr[center], c = arr[right];
//		if((a>=b&&a<=c)||(a<=b&&a>=c))
//			return a;				
//		else if((b>=a&&b<=c)||(b<=a&&b>=c))
//			return  b;				
//		else return  c;
//		
//	}

	public static void main(String[] args) {
		int[] a = {2,3,1,5,4,8,7,0,11};
		
		quickSort(a, 0 , a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	private static int divide(int[] arr, int left, int right) {
		
		int base = arr[right];
		while (left < right) {
			while(arr[left] < base && left < right)
				left++;
			
			if(left < right) {
				arr[right] = arr[left];
				arr[left] = base;
				
				right--;
			}
			
			while(right > left && arr[right] > base)
				right--;
			
			if(left < right) {
				arr[left] = arr[right];
				arr[right] = base;
				
				left++;
			}
		}
		
		return right;
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left > right)
			return;
		else {
			int temp = divide(arr, left, right);
			quickSort(arr, left, temp - 1);
			quickSort(arr, left + 1, right);
		}
	}
}
