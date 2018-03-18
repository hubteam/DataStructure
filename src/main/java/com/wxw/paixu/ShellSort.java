package com.wxw.paixu;

/**
 * 希尔排序：插入类排序
 * 又叫缩小增量排序【通过比较相距一定间隔的元素来工作，各趟比较所用的举例随着算法的进行而减小，直到比较相邻元素的最后一趟排序为止】
 * 注意：最后一个增量一定是1，
 * 其本质还是插入排序，试讲待排序的序列按照某种规则（指增量）分成几个子序列，分别对这几个子序列进行插入排序
 * 
 * 希尔排序的运行时间依赖于增量序列的选择
 * 使用希尔增量时希尔排序的最坏运行情况是O(N2)
 * @author 王馨苇
 *
 */
public class ShellSort {

	//此时采用增量的序列：Ht=N/2 Hk=H(k+1) / 2
	public static void shellSort(int[] a){
		int j;
		
		for (int gap = a.length / 2; gap > 0; gap /= 2) {//增量的变化
			
			//增量之前的相当于是已经排好序的区域
			//相当于简单插入排序中0的位置
			for (int i = gap; i < a.length; i++) {
				
				int temp = a[i];
				//j >= gap 相当于直接插入排序中的j > 0
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
