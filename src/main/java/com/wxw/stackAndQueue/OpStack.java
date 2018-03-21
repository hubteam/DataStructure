package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * ���׺ʽ����ֵ
 * ������ֵ��ʱ����ջ�������������ʱ���������γ�ջ����������ջԪ�ؽ��������������㣬�ѽ����������������ֵ��ջ
 * @author ��ܰέ
 *
 */
public class OpStack {

	public static int op(int a, char op, int b) throws Exception{
		if(op == '+'){
			return a + b;
		}
		if(op == '-'){
			return a - b;
		}
		if(op == '*'){
			return a * b;
		}
		if(op == '/'){
			if(b == 0){
				return -1;
			}
			return a / b;
		}
		return -1;
	}
	
	public static int com(char[] c) throws Exception{
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < c.length; i++) {
			if(c[i] >= '0' && c[i] <= '9'){
				s.push(c[i] - '0');
			}else{
				if(s.size() < 2){
					throw new Exception("��׺���ʽ����ȷ");
				}else{
					int a = s.pop();
					int b = s.pop();
					int res = op(b, c[i], a);
					s.push(res);
				}
			}
		}
		return s.pop();
	}
	
	public static void main(String[] args) throws Exception {
		String s = "1234*++5/";
		System.out.println(com(s.toCharArray()));
	}
}
