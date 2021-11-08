import java.io.*;
import java.util.*;

public class GetKPC {
    public static String[] arr = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(getKPC(str));
    }

    public static ArrayList < String > getKPC(String str) {
        if (str.length() == 0) {
            ArrayList < String > list = new ArrayList < > ();
            list.add("");
            return list;
        }

        int c = Integer.parseInt(String.valueOf(str.charAt(0)));
        String substring = str.substring(1);

        ArrayList < String > recursion_list = getKPC(substring); //got all for 23
        ArrayList < String > my_list = new ArrayList < String > ();
        String str_left = arr[c];
        for (int i = 0; i < str_left.length(); i++) {
            char ch = str_left.charAt(i);

            for (String s: recursion_list) {
                my_list.add(String.valueOf(ch) + s);
            }
        }

        return my_list;
    }

}