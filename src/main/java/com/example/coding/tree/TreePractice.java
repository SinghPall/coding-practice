package com.example.coding.tree;
class Node{
	int data;
	Node left, right;
	Node(int d){data = d; left = null; right = null;}
}
public class TreePractice {
	Node root;
	public void printPathFromRoot(){
		if(root != null){
			int path[] = new int[100];
			printPathRecur(root, path, 0);
		}
	}
	public void printPathRecur(Node root, int []path, int len){
		if(root == null) return;
		path[len++] = root.data;
		
		if(root.left == null && root.right == null)
			print(path, len);
		else{
			printPathRecur(root.left, path, len);
			printPathRecur(root.right, path, len);
		}
	}
	
	public void print(int a[], int l){
		for(int i=0; i<l; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreePractice tree = new TreePractice();
		tree.root = new Node(0);
		tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2);
        
        tree.printPathFromRoot();
	}

}
