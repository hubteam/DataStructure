package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * 判断括号表达式是否匹配
 * 
 * 左括号入栈，右括号出栈（出栈之前看看是不是空， 是空的话，肯定不匹配；不是空的，就出栈）
 * 最后栈是空，就是匹配
 * @author 王馨苇
 *
 */
public class BracketStack {

	public static int match(char[] c){
		Stack<String> s = new Stack<String>();
		for (int i = 0; i < c.length; i++) {
			if(c[i] == '('){
				s.push("(");
			}
			if(c[i] == ')'){
				if(s.isEmpty()){
					return -1;
				}else{
					s.pop();
				}
			}
		}
		
		if(s.isEmpty()){
			return 1;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String s = "(()()(()))";
		int i = match(s.toCharArray());
		System.out.println(i);
	}
}
