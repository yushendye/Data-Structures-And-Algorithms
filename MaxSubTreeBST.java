import java.io.*;
import java.util.*;

public class MaxSubTreeBST {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }  
  
  public static class BSTPair{
      int max;
      int min;
      boolean is_bst;
      Node root;
      int size;      
  }     
  public static BSTPair isBST(Node node){
    if(node == null){
        BSTPair pair = new BSTPair();
        pair.is_bst = true;
        pair.max = Integer.MIN_VALUE;
        pair.min = Integer.MAX_VALUE;
        pair.root = null;
        pair.size = 0;
        return pair;
    }
    
    BSTPair left = isBST(node.left);
    BSTPair right = isBST(node.right);
    
    BSTPair mp = new BSTPair();
    mp.is_bst = left.is_bst && right.is_bst && 
                (node.data >= left.max && node.data <= right.min);
    mp.max = Math.max(node.data, Math.max(left.max, right.max));
    mp.min = Math.min(node.data, Math.max(left.min, right.min));

    if(mp.is_bst){
    	mp.root = node;
    	mp.size = left.size + right.size + 1;    	
    }else if(left.size > right.size){
    	mp.root = left.root;
    	mp.size = left.size;
    }else{
    	mp.root = right.root;
    	mp.size = right.size;
    }
    
    return mp;
  }  
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    BSTPair pair = isBST(root); 

    System.out.println(pair.root.data + "@" + pair.size);
  }

}