import java.util.*;
import java.io.*;

public class MyBinaryTree{
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

	public static class Pair{
		Node node;
		int level;

		public Pair(Node node, int level){
			this.node = node;
			this.level = level;			
		}
	}

	public static void display(Node root){
		if(root == null)		
			return;
		String op = "";		
		op += root.left == null ? "." : root.left.data;
		op += "<-" + root.data + "->";
		op += root.right == null ? "." : root.right.data;	
		System.out.println(op);			

		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {
		Integer[] arr = {50, 25, 12, null, null, 37, 30 , null, null, null, 75, 62, null, 70, null, null, 87, null, null};

		Node root = new Node(arr[0], null, null);
		Pair root_pair = new Pair(root, 1);

		Stack<Pair> st = new Stack<Pair>();
		st.push(root_pair);
		int index = 0;

		while(st.size() != 0){
			Pair top_pair = st.peek();

			if(top_pair.level == 1){
				index++;

				if(arr[index] != null){
					Node left_node = new Node(arr[index], null, null);
					top_pair.node.left = left_node;

					Pair left_pair = new Pair(left_node, 1);
					st.push(left_pair);
				}

				top_pair.level++;
			}else if(top_pair.level == 2){
				index++;

				if(arr[index] != null){
					Node right_node = new Node(arr[index], null, null);
					top_pair.node.right = right_node;

					Pair left_pair = new Pair(right_node, 1);
					st.push(left_pair);
				}

				top_pair.level++;
			}else if(top_pair.level == 3){
				st.pop();
			}
		}

		display(root);
	}	
}