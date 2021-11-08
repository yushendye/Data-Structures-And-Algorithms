import java.io.*;
import java.util.*;

public class NumericKeyPad{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String seq = scn.next();

        List<String> op = letterCombinations(seq);
        System.out.println(op);
    }
    
    public static List<String> letterCombinations(String digits) {        
        String[] sequences = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if(digits.length() == 0){
            List<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }
        
        char first_digit = digits.charAt(0);
        String remaining_digits = digits.substring(1);
        
        List<String> subseq_of_remaining = letterCombinations(remaining_digits);
        List<String> my_list = new ArrayList<String>();
        
        String seq_at_first_digit = sequences[first_digit - '0'];
        for(int i = 0; i < seq_at_first_digit.length(); i++){
            for(String seq : subseq_of_remaining){
                my_list.add(seq_at_first_digit.charAt(i) + seq);
            }
        }
        
        return my_list;
    }
}