package com.wxw.paixu;

/**
 * 插入排序属于插入类排序：在一个有序的序列中，插入一个新的记录，新插入的找到自己合适的位置保证队伍仍然有序
 * 需要N-1趟排序组成
 * 时间复杂度：
 * 嵌套的循环花费是0(N^2);如果事先是排好序的，就不会进入嵌套的那层循环，此时时间复杂度是O(N)
 * 
 * 定理：
 * N个互异数的数组的平均逆序数是N(N-1)/4
 * 通过交换相邻元素进行任何元素进行排序的任何算法都需要N2时间
 * @author 王馨苇
 *
 */
public class InsertSort {

	private static void insertSort(int[] a){
		int j;
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];//要插入的值
			for (j = i; j > 0 && temp < a[j - 1]; j--) {//新插入位置之前的，都和新插入的位置进行比较
				a[j] = a[j-1];//向后移动
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
