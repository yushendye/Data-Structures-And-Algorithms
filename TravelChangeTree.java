import java.io.*;
import java.util.*;

public class TravelChangeTree {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static int size = 0;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;
  static int height = Integer.MIN_VALUE;
  public static void multisolver(Node node, int depth){
    size++;
    min = Math.min(min, node.data);
    max = Math.max(max, node.data);
    height = Math.max(height, depth);

    for(Node ch : node.children)
      multisolver(ch, depth + 1);  
  }

  static Node pred = null;
  static Node succ = null;
  static int state = 0;

  public static void predSucc(Node node, int data){
    if(node.data != data)
      state = 0;
    else if(data == node.data){
      pred = node;
      state = 1;
    }else if(state == 1){
      succ = node;
      state = 2;
    }

    for(Node ch : node.children){
      predSucc(ch, data);
    }
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);    
    display(root);

    multisolver(root, 0);

    System.out.println("Height : " + height);
    System.out.println("min : " + min);
    System.out.println("max : " + max);
    System.out.println("size : " + size);

    int d = Sc
  }

}