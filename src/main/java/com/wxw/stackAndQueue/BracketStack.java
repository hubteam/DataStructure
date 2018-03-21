package com.wxw.stackAndQueue;

import java.util.Stack;

/**
 * �ж����ű��ʽ�Ƿ�ƥ��
 * 
 * ��������ջ�������ų�ջ����ջ֮ǰ�����ǲ��ǿգ� �ǿյĻ����϶���ƥ�䣻���ǿյģ��ͳ�ջ��
 * ���ջ�ǿգ�����ƥ��
 * @author ��ܰέ
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
