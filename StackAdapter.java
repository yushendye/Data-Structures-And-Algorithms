import java.io.*;
import java.util.*;

public class StackAdapter {
  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      return mainQ.size();
    }

    void push(int val) {    
      mainQ.add(val);
      while (mainQ.size() > 0) {
        helperQ.add(mainQ.remove());
      }      
      while(helperQ.size() > 0){
        mainQ.add(helperQ.remove());
      }
      System.out.println(mainQ);
    }

    int pop() {
      while(mainQ.size() > 1) 
        helperQ.add(mainQ.remove());

      int val = mainQ.remove();

      while(helperQ.size() > 0)
        mainQ.add(helperQ.remove());
      return val;
    }

    int top() {
      while(mainQ.size() > 1) 
        helperQ.add(mainQ.remove());

      int val = mainQ.peek();
      helperQ.add(mainQ.remove());

      while(helperQ.size() > 0)
        mainQ.add(helperQ.remove());
      return val;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}