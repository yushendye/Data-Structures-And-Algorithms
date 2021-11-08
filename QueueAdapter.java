import java.io.*;
import java.util.*;

public class QueueAdapter {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      mainS.push(val);
      System.out.println(mainS);
    }

    int remove() {
        if(mainS.size() == 0) {
          System.out.println("queue underflow");
          return -1;
        }
        
        while(mainS.size() > 1){
            helperS.push(mainS.pop());
        }
        int val = mainS.pop();
        
        while(helperS.size() > 0)
            mainS.push(helperS.pop());
            
        return val;
    }

    int peek() {
        if(mainS.size() == 0) {
          System.out.println("queue underflow");
          return -1;
        }
        while(mainS.size() > 1){            
            helperS.push(mainS.peek());
            mainS.pop();
        }
        int val = mainS.peek();
        
        helperS.push(mainS.pop());
        while(helperS.size() > 0)
            mainS.push(helperS.pop());
            
        return val;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}