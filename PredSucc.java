import java.io.*;
import java.util.*;

public class PredSucc {
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
  
  static Node pred = null;
  static Node succ = null;
  static int state = 0;

  public static void predSucc(Node node, int data){
    if(state == 0){
      if(node.data == data)
        state = 1;
      else{
        pred = node;
      }        
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

    int d = Integer.parseInt(br.readLine());

    Node root = construct(arr);    
    display(root);

    predSucc(root, d);
    System.out.println(pred.data);
    System.out.println(succ.data);
  }

}