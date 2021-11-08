import java.io.*;
import java.util.*;

public class MyBST{
	public static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static Node construct(int[] arr, int lo, int hi){
		if(lo > hi){
			return null;
		}
		int mid = (lo + hi) / 2;
		int d = arr[mid];

		Node left = construct(arr, lo, mid - 1);
		Node right = construct(arr, mid + 1, hi);
		Node root = new Node(d, left, right);

		return root;
	}

	public static void display(Node node){
		if(node == null)
			return;

		String op = "";
		op += node.left == null ? "." : node.left.data;
		op += "<-" + node.data + "->";
		op += node.right == null ? "." : node.right.data;
		System.out.println(op);
		display(node.left);
		display(node.right);
	}

	public static void main(String[] args){
		int[] array = {12, 25, 37, 50, 62, 75, 87};
		Node root = construct(array, 0, array.length - 1);
		display(root);
	}


}