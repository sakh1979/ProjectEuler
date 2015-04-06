import java.util.ArrayList;
import java.util.Collections;

/**
 * A palindromic number reads the same both ways. The largest
 * palindrome made from the product of two 2-digit numbers is 9009 =
 * 91 * 99. Find the largest palindrome made from the product of two
 * 3-digit numbers.
 */
public class P004 {

    public static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                Integer value = i * j;
                if (isPalindrome(value.toString())) {
                    a.add(value);
                }
            }
        }

        Collections.sort(a);

        System.out.println(a);
    }
}
