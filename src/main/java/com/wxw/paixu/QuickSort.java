package com.wxw.paixu;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序：交换类排序，在C++，java基本类型排序中特别有用
 * 平均时间：O(NlogN)，该算法之所以特别快是因为非常精炼和告诉优化的内部循环
 * 最坏：O(N2)
 * 也是一种分治递归算法
 * 
 * 步骤：
 * 1.如果数组S中元素个数是0或1，则返回
 * 2.S中任意选一个元素V，称为枢纽元
 *   一种错误的选择：选择第一个，如果输入是随机的，可以接受，如果输入时预排序或者是反序的，就是劣质的分割，因为所有元素不是在S1就是在S2，这种情况会发生在所有递归中
 *              实际上第一个元素用作枢纽元，而且输入时预先排序的，那么快速排序花费的时间是二次的，而实际上啥也没做
 *   一种安全的做法：随机
 *   三树中值分割法：一组N个数的中值，是第N/2个最大的数，枢纽元的最好的元素的中值，很难算出且影响速度
 *              随机选三个数，用他们的中值作为枢纽，更一般的做法是选择左，右，中三个元素的中值
 *              
 * 3、将S-V划分为不想叫的集合，S1 S2
 *    分割策略：将枢纽元和最后元素交换，使得枢纽元离开要被分割的数据段。
 *           I从第一个元素开始，J从倒数第二个元素开始
 *    注意：遇到和枢纽元相等的元素的时候，I J都停止，在相等元素间会有多次交换
 * 4、返回quicksort(S1) v QUICKSORT(S2)
 * 
 * 注意：对于N<=20的小数组，快速不如插入，因为快速是递归的
 * 
 * 快速排序为什么会快：选择一个基准，左边是小于基准的，右边是大于基准的，从这已时刻开始，小于基准的数就在也没有机会和大于基准的数进行比较了
 * 
 * 时间复杂度：最坏：O(N2)
 *         最好：O(NlogN)
 *         平均：O(NlogN)
 * @author 王馨苇
 *
 */
public class QuickSort {

	//实现简单的递归排序
	//是快速排序的基础，但是会产生额外的列表
	public static void sort(List<Integer> items){
		
		List<Integer> smaller = new ArrayList<Integer>();
		List<Integer> same = new ArrayList<Integer>();
		List<Integer> lager = new ArrayList<Integer>();
		
		//取中间数
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
		
		//递归
		sort(smaller);
		sort(lager);
		
		items.clear();
		items.addAll(smaller);
		items.addAll(same);
		items.addAll(lager);
	}
	
	//选取枢纽元,用选三个数字的中间一个数字
	//方法的好处：
	//1、三个元素中的最小和最大分别在最左和最右，这也是分割阶段需要将它放到的合适的位置，所以我们将枢纽放在right-1的位置上去
	//  并将I J的位置分别指向left+1，和right-2的位置上去
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
