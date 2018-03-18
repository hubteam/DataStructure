package com.wxw.paixu;

/**
 * 归并排序：归并类的排序，就是将两个或两个以上有序序列合并成一个 新的有序的序列
 * 时间复杂度：最坏，最好，平均都是O(NlogN)
 * 具体做法：
 * 1、这个算法的基本操作是合并两个已经排序的表，因为这两个表是已经排序的，所以若将输出的结果放到第三个表中，该算法可以通过对输入数据进行一趟排序来完成。
 * 2、基本的合并操作是：取两个输入数组A、B，一个输出数组C，以及三个计数器，他们初始位置对应数组的开始端，将A[I] B[J]中较小的拷贝到C中，相关计数器向前推进一步，
 * 当A B中有一个用完的时候，则将表中剩余部分拷贝到C中
 * 
 * 采用分治的策略：
 * 1、分：将问题分成一些小的问题，然后递归求解
 * 2、治：将分的阶段得到的答案修补在一起
 * 
 * 递推公式：T(1) = 1 对于N=1时候，归并排序时间是常数
 *        T(N) = 2T(N/2) + N 对于N个数归并排序用时等于完成两个大小为N/2的递归排序所用的时间加上合并的时间
 *        
 * 问题是：合并两个已经排序的表用到的线性附加内存，在整个算法排序过程中还要花费将数组拷贝到临时数组在拷贝回来这样一些附加工作，减慢了排序速度
 * 
 * 归并排序是所有流行的排序算法中最少的比较次数，是使用java的通用排序算法中好的选择，是java类库泛型排序所使用的排序
 * @author 王馨苇
 *
 */
public class MergeSort {

	private static void mergeSort(int[] a, int[] temp, int left, int right){
		
		if(left < right){
			
			int center = (left + right) / 2;
			mergeSort(a, temp, left, center);//处理左部分
			//注意下面是center+1
			mergeSort(a, temp, center + 1, right);//处理右部分
			//合并
			merge(a, temp, left, center + 1, right);
		}
	}
	
	public static void mergeSort(int[] a){
		
		int[] temp = new int[a.length];
		mergeSort(a, temp, 0, a.length - 1);
	}
	
	/**
	 * 
	 * @param a 输入数组
	 * @param temp 输出数组
	 * @param leftpos 数组最左
	 * @param rightpos 第二个数组最左
	 * @param rightend 数组长度
	 */
	private static void merge(int[] a, int[] temp, int leftpos, int rightpos, int rightend){
		
		int leftend = rightpos - 1;
		int temppos = leftpos;//注意这个，是存储的数组的下标
//		int num = rightend - leftpos + 1;
		int templeftpos = leftpos;
		
		while(leftpos <= leftend && rightpos <= rightend){
			if(a[leftpos] <= a[rightpos]){
				temp[temppos++] = a[leftpos++];
			}else{
				temp[temppos++] = a[rightpos++];
			}
		}
		
		//当有一个数组没有遍历完的时候
		while(leftpos <= leftend){
			temp[temppos++] = a[leftpos++];
		}
		while(rightpos <= rightend){
			temp[temppos++] = a[rightpos++];
		}
		
		//把排序好的数组copy回去
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
