package com.wxw.tree;

import java.util.Stack;

/**
 * 二叉树的遍历：非递归
 * 
 * @author 王馨苇
 *
 */
public class BianLi {

	/**
	 * 前序遍历：
	 * 头结点入栈
	 * 弹出栈顶，如果这个节点有右孩子，右孩子入栈，如果有左孩子，左孩子入栈
	 * 不断重复至栈空
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
	 * 中序遍历
	 * 头结点入栈
	 * 左节点入栈，当左节点为空的时候，打印栈顶，出栈，右节点入栈
	 * @param root
	 */
	public void zhongxu(TreeNode root){
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		//一开始没有节点入栈,栈空，通过root != null保证循环的进行
		while(!s.isEmpty() || root != null){
			
			while(root != null){//左节点入栈，直到左节点为空
				s.push(root);
				root = root.left;
			}
			
			if(!s.isEmpty()){
				TreeNode cur = s.pop();
				System.out.println(cur.val);
				root = cur.right;//出栈后，右节点入栈
			}
		}
	}
	
	/**
	 * 用两个栈来实现
	 * 根节点入栈1
	 * 栈1不为空，弹出栈顶cur，压入第二个栈，如果cur有左孩子将左孩子入栈1，如果有右孩子，将右孩子入栈1
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
		//s2中出栈的顺序就是后续遍历的结果
	}
	
	/**
	 * 一个栈实现:cur表示栈顶元素，h元素表示最近出栈的元素，初始化h为头结点
	 * 根节点入栈，初始化H变量
	 * 栈不空，CUR为栈顶元素：
	 *  1如果CUR的左孩子不为空，且H不等于CUR的左孩子和右孩子，那么左孩子入栈（如果最近H等于当前节点的左孩子，说明左孩子已经打印完了，否则代表还没有打印过，就应该将左孩子或右孩子入栈）
	 *  2如果1条件不成立，CUR右孩子不等于H，且不为空，说明右子树没有处理，右孩子入栈
	 *  上述两个条件都不成立，说明左右子树都打印完毕，或者当前节点为叶子节点，此时就应该将栈顶元素出栈，并且另H=CUR
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
				h = cur;//指向最近出栈的元素
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
