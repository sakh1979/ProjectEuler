import java.util.ArrayList;
import java.util.List;

/**
 * The sequence of triangle numbers is generated by adding the natural
 * numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6
 * + 7 = 28. The first ten terms would be:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five
 * divisors.
 *
 * What is the value of the first triangle number to have over five
 * hundred divisors?
 */
public class P012 {

    public static List<Integer> getAllFactors(int n) {

        List<Integer> result = new ArrayList<Integer>();
        int i = 2;

        while (i < Math.sqrt(n)) {
            if (n  % i == 0) {
                result.add(i);
                result.add(n/i);
            }
            i++;
        }

        if (i*i == n) {
            result.add(i);
        }

        return result;
    }

    public static int getTriangularNumber(int n) {
        return (n * (n + 1))/2;
    }

    public static void main(String[] args) {

        int n = 1;
        int numberOfFactors = getAllFactors(n).size();
        while (numberOfFactors <= 500) {
            n++;
            numberOfFactors = getAllFactors(getTriangularNumber(n)).size();
        }

        System.out.println("Answer: " + getTriangularNumber(n));
    }
}
