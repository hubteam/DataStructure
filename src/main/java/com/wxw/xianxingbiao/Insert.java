package com.wxw.xianxingbiao;

/**
 * �������Ա�����һ��Ԫ��x�󣬱�֤��Ȼ����
 * �������ҵ���һ����x���λ��
 * @author ��ܰέ
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
