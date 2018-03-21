package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * 求后缀式的数值
 * 遇到数值的时候入栈，遇到运算符的时候连续两次出栈，将两个出栈元素结合运算符进行运算，把结果当成新遇到的数值入栈
 * @author 王馨苇
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
					throw new Exception("后缀表达式不正确");
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
