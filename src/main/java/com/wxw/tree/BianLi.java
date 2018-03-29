package com.wxw.tree;

import java.util.Stack;

/**
 * �������ı������ǵݹ�
 * 
 * @author ��ܰέ
 *
 */
public class BianLi {

	/**
	 * ǰ�������
	 * ͷ�����ջ
	 * ����ջ�����������ڵ����Һ��ӣ��Һ�����ջ����������ӣ�������ջ
	 * �����ظ���ջ��
	 * 
	 * @param root
	 */
	public void qianXu(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode cur = s.pop();
			System.out.println(cur.val);
			if(cur.right != null){
				s.push(cur.right);
			}
			if(cur.left != null){
				s.push(cur.left);
			}
		}
	}
	
	/**
	 * �������
	 * ͷ�����ջ
	 * ��ڵ���ջ������ڵ�Ϊ�յ�ʱ�򣬴�ӡջ������ջ���ҽڵ���ջ
	 * @param root
	 */
	public void zhongxu(TreeNode root){
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		//һ��ʼû�нڵ���ջ,ջ�գ�ͨ��root != null��֤ѭ���Ľ���
		while(!s.isEmpty() || root != null){
			
			while(root != null){//��ڵ���ջ��ֱ����ڵ�Ϊ��
				s.push(root);
				root = root.left;
			}
			
			if(!s.isEmpty()){
				TreeNode cur = s.pop();
				System.out.println(cur.val);
				root = cur.right;//��ջ���ҽڵ���ջ
			}
		}
	}
	
	/**
	 * ������ջ��ʵ��
	 * ���ڵ���ջ1
	 * ջ1��Ϊ�գ�����ջ��cur��ѹ��ڶ���ջ�����cur�����ӽ�������ջ1��������Һ��ӣ����Һ�����ջ1
	 * 
	 * @param root
	 */
	public void houxu1(TreeNode root){
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()){
			TreeNode cur = s1.pop();
			s2.push(cur);
			if(cur.left != null){
				s1.push(cur.left);
			}
			if(cur.right != null){
				s1.push(cur.right);
			}
		}
		//s2�г�ջ��˳����Ǻ��������Ľ��
	}
	
	/**
	 * һ��ջʵ��:cur��ʾջ��Ԫ�أ�hԪ�ر�ʾ�����ջ��Ԫ�أ���ʼ��hΪͷ���
	 * ���ڵ���ջ����ʼ��H����
	 * ջ���գ�CURΪջ��Ԫ�أ�
	 *  1���CUR�����Ӳ�Ϊ�գ���H������CUR�����Ӻ��Һ��ӣ���ô������ջ��������H���ڵ�ǰ�ڵ�����ӣ�˵�������Ѿ���ӡ���ˣ��������û�д�ӡ������Ӧ�ý����ӻ��Һ�����ջ��
	 *  2���1������������CUR�Һ��Ӳ�����H���Ҳ�Ϊ�գ�˵��������û�д����Һ�����ջ
	 *  ����������������������˵��������������ӡ��ϣ����ߵ�ǰ�ڵ�ΪҶ�ӽڵ㣬��ʱ��Ӧ�ý�ջ��Ԫ�س�ջ��������H=CUR
	 * @param root
	 */
	public static void houxu2(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode h = root;
		while(!s.isEmpty()){
			TreeNode cur = s.peek();
			if(cur.left != null && h != cur.left && h != cur.right){
				s.push(cur.left);
			}else if(cur.right != null && h != cur.right){
				s.push(cur.right);
			}else{
				s.pop();
				h = cur;//ָ�������ջ��Ԫ��
				System.out.println(cur.val);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		root1.left = root2;
		root1.right = root4;
		root2.left = root3;
		root2.right = root5;
		houxu2(root1);
	}
}
