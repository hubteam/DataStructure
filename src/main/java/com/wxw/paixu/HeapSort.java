package com.wxw.paixu;

/**
 * 堆排序：选择类排序，即每一趟选择一个最小或最大的记录，把他和序列中的第一个或最后一个记录交换，这样最大或者最小的记录到位
 * 堆排序的执行过程：
 * 1、从无序序列所确定的完全二叉树的第一个非叶子节点开始，从右至左，从下至上，对每个节点进行调整，最终得到大根堆
 * 2、将当前无序序列中的第一个元素和最后一个元素交换，无序序列减少一个元素，有序序列增加一个元素
 * 3、重复直到无序序列中剩下一个元素时候停止
 * 
 * O(NlogN)
 * @author 王馨苇
 *
 */
public class HeapSort {
	
	//返回左节点
	private static int leftChild(int i){
		return 2 * i + 1;
	}
	
	private static void percDown(int[] a, int i, int n){
		int child = 0;
		int temp;
		for (temp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			
			if(child != n - 1 && a[child] < a[child + 1]){//如果右节点比较大
				child++;//指向右节点
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
		for (int i = a.length / 2; i >= 0; i--) {//建堆2N次比较
			percDown(a, i, a.length);
		}
		
		for (int i = a.length - 1; i > 0; i--) {//删除最大，用2logi比较
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
