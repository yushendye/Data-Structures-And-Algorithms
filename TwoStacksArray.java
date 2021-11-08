import java.io.*;
import java.util.*;

public class TwoStacksArray {

  public static class TwoStack {
    int[] data;
    int tos1;
    int tos2;

    public TwoStack(int cap) {
      data = new int[cap];
      
      tos1 = -1;
      tos2 = cap;
    }

    int size1() {
      // write your code here
      return tos1 + 1;
    }

    int size2() {
      // write your code here
      return tos2 + 1;
    }

    void print(int[] d){
        System.out.print("[");
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.print("]");
    }

    void push1(int val) {
      print(data);
      if(tos1 == -1){
        tos1++;
        data[tos1] = val;
      }
      else{
        if( (Math.abs(tos1 - tos2) != 0) || (tos1 + tos2 != data.length) ){
          tos1++;
          data[tos1] = val;        
        }
        else
          System.out.println("Stack overflow");
      }
    }

    void push2(int val) {
      print(data);
      // write your code here
      if( (Math.abs(tos1 - tos2) != 0) || (tos1 + tos2 != data.length) ){
        tos2--;
        data[tos2] = val;
      }else
        System.out.println("stack overflow");
    }

    int pop1() {
      if(tos1 == -1){
        System.out.println("Stack underflow");
        return -1;
      }else{
        int val = data[tos1];
        data[tos1] = 0;
        tos1--;

        return val;
      }
    }

    int pop2() {
      if(tos2 == data.length){
        System.out.println("Stack underflow");
        return -1;
      }else {
        int val = data[tos2];
        data[tos2] = 0;
        tos2++;

        return val;
      }
    }

    int top1() {
      if(tos1 == -1){
        System.out.println("Stack underflow");
        return 0;
      }else{
        return data[tos1];
      }
    }

    int top2() {
      if(tos2 == -1){
        System.out.println("Stack underflow");
        return 0;
      }else{
        return data[tos2];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TwoStack st = new TwoStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = br.readLine();
    }
  }
}