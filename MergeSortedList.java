import java.util.*;
import java.io.*;

public class MergeSortedList{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for(int i = 0; i < n1; i++){
            int num = scn.nextInt();
            l1.addLast(num);
        }

        int n2 = scn.nextInt();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for(int i = 0; i < n2; i++){
            int num = scn.nextInt();
            l2.addLast(num);
        }

        LinkedList<Integer> op = mergeTwoSortedLists(l1, l2);
        for(int i = 0; i < op.size(); i++)
            System.out.print(op.get(i) + "\t");
    }
    public static LinkedList<Integer> mergeTwoSortedLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
            LinkedList op = new LinkedList();

            int p1 = 0;
            int p2 = 0;

            int min_size = Math.min(l1.size(), l2.size());
            while(p1 != min_size && p2 != min_size){
                if(l1.get(p1) < l2.get(p2)){
                    op.addLast(l1.get(p1));
                    p1++;
                }else{
                    op.addLast(l2.get(p2));
                    p2++;
                }
            }

            if(l1.size() == min_size){
                for(int i = p2; i < l2.size(); i++)
                    op.addLast(l2.get(i));
            }else{
                for(int i = p1; i < l1.size(); i++)
                    op.addLast(l1.get(i));
            }
            return op;        
    }
}