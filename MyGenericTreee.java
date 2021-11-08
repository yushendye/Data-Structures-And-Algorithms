import java.io.*;
import java.util.*;

public class MyGenericTreee{
	public static class Node{
		int data;
		List<Node> children = new ArrayList<>();
	}

	public static void printTree(Node root){
		String str = root.data + " -> ";

		for(Node child : root.children){
			str += child.data + ", ";			
		}
		str += ".";
		System.out.println(str);
		for(Node child : root.children){
			printTree(child);
		}
	}

	public static void traverse(Node root){
		//inOrder(root);
		preOrder(root);
		System.out.println("--------------------------");
		postOrder(root);
	}	

	public static void preOrder(Node root){
		System.out.print("Node ");
		for(Node child : root.children){
			preOrder(child);
			System.out.print("Edge ");
		}
		System.out.println(root.data);
	}

	public static void postOrder(Node root){
		System.out.print("Node ");
		System.out.println(root.data);
		for(Node child : root.children){
			System.out.print("Edge ");
			preOrder(child);
		}		
	}

	public static void depthWiseDisplay(Node root){	
		System.out.print(root.data + " ");
		List<Integer> list = new ArrayList();		
		for(Node child : root.children){
			list.add(child.data);

			depthWiseDisplay(child);
		}

		for(int item : list){
			System.out.print(item +  " ");
		}
	}

	public static void mirror(Node node){
      for(Node child : node.children){
          if(child.children.size() > 0){
              int left = 0;
              int right = child.children.size();
              
              while(left <= right){
                  int temp = child.children.get(left).data;
                  child.children.get(left).data = child.children.get(right).data;
                  child.children.get(right).data = temp;                  
                  left++;
                  right--;
              }
          }
      }
  }

	public static void main(String[] args) {
		Node root = null;
		Stack<Node> st = new Stack<>();

		int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

		for(int i = 0; i < array.length; i++){
			int item = array[i];

			if(item == -1){
				st.pop();
			}else{				
				Node temp = new Node();
				temp.data = item;

				if(st.size() == 0)
					root = temp;
				else{
					st.peek().children.add(temp);								
				}
				st.push(temp);
			}
		}

		//printTree(root);
		depthWiseDisplay(root);
	}
}