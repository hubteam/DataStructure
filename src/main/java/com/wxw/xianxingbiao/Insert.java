package com.wxw.xianxingbiao;

/**
 * 有序线性表，插入一个元素x后，保证仍然有序
 * 解析：找到第一个比x大的位置
 * @author 王馨苇
 *
 */
public class Insert {

	public static int locate(ShunXuBiao s, int x){
		
		for (int i = 0; i < s.length; i++) {
			if(x < s.data[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static void insert(ShunXuBiao s, int x){
		int p = locate(s, x);
		
		for (int i = s.length - 1; i >= p; i--) {
			s.data[i+1] = s.data[i];
		}
		s.data[p] = x;
		
		++s.length;
	}
}
